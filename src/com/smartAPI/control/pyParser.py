'''
Created on 24/mag/2015

@author: Simone
'''
import ast
import sys

if len(sys.argv) == 1:
    print 'Error: expected python code in input'
    exit(1)
   
codePath = sys.argv[1] 
code = ""
with open(codePath, "r") as ins:
    for line in ins:
        code = code + line
foundMethod_s = set()
#tree = ast.parse("db = MySQLdb.connect(\"localhost\",\"testuser\",\"test123\",\"TESTDB\")\n"
#                 "cursor = db.cursor()")
tree = ast.parse(code)

for node in ast.walk(tree):
    if isinstance(node, ast.Call):
        info = ast.dump(ast.parse(node.func))
        #print info
        if (info.find("attr='") != -1):
            attrFirstIndex = int(info.find("attr='") + 6)
            while attrFirstIndex != 0:            
                attrSecondIndex = 0
                for i,c in enumerate(info):
                    if c=='\'': 
                        if i>attrFirstIndex:
                            attrSecondIndex = i
                            break                    
                foundMethod_s.add(info[int(attrFirstIndex) :int(attrSecondIndex)] + "")
                info = info[int(attrSecondIndex) :]
                if (info.find("attr='") != -1):
                    attrFirstIndex = int(info.index("attr='") + 6)
                else:
                    attrFirstIndex = 0
        if (info.find("id='") != -1):
            attrFirstIndex = int(info.find("id='") + 4)
            while attrFirstIndex != 0:            
                attrSecondIndex = 0
                for i,c in enumerate(info):
                    if c=='\'': 
                        if i>attrFirstIndex:
                            attrSecondIndex = i
                            break                    
                foundMethod_s.add(info[int(attrFirstIndex) :int(attrSecondIndex)] + "")
                info = info[int(attrSecondIndex) :]
                if (info.find("id='") != -1):
                    attrFirstIndex = int(info.index("id='") + 4)
                else:
                    attrFirstIndex = 0

for item in foundMethod_s:
  print item
            
