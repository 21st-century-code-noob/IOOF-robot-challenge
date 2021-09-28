I manually tested the program.

##Test 1: Create a new robot and move.

Instructions:    
*PLACE 1,1,EAST*  
*LEFT*  
*MOVE*  
*REPORT*  
*RIGHT*
*MOVE*
*REPORT*

Eexpected output:  
*Output: 2,1,NORTH*
*Output: 2,2,EAST*

Actual output:
*Output: 2,1,NORTH*
*Output: 2,2,EAST*


##Test 2: All four directions
Instructions:  
*PLACE 0,0,EAST*
*REPORT*
*LEFT*  
*REPORT*  
*LEFT*  
*REPORT*  
*LEFT*
*REPORT*
*LEFT*
*REPORT*

Expected output:  
*Output: 0,0,EAST*  
*Output: 0,0,NORTH*  
*Output: 0,0,WEST*  
*Output: 0,0,SOUTH*  
*Output: 0,0,EAST*  
