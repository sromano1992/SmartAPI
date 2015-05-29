'''
Created on 24/mag/2015

@author: Simone
'''
import ast
import sys

if len(sys.argv) == 1:
    print 'Error: expected python code in input'
    exit(1)
    
code = sys.argv[1]
#tree = ast.parse("db = MySQLdb.connect(\"localhost\",\"testuser\",\"test123\",\"TESTDB\")\n"
#                 "cursor = db.cursor()")
tree = ast.parse(code)

for node in ast.walk(tree):
    if isinstance(node, ast.Call):
        info = ast.dump(ast.parse(node.func))
        #print info
        attrFirstIndex = int(info.index("attr='") + 6)
        attrSecondIndex = 0
        for i,c in enumerate(info):
            if c=='\'': 
                if i>attrFirstIndex:
                    attrSecondIndex = i                    
        print info[int(attrFirstIndex) :int(attrSecondIndex)]
