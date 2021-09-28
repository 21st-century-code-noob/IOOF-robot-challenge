I manually tested the program. I didnt't use automated unit testing such as JUnit. But if it is required, I can add it later.

## Test 1: Create a new robot and move.

### Instructions:   
*PLACE 1,1,EAST*  
*LEFT*  
*MOVE*  
*REPORT*  
*RIGHT*  
*MOVE*  
*REPORT*  

### Eexpected output:
*Output: 1,2,NORTH*  
*Output: 2,2,EAST*

### Actual output:
*Output: 1,2,NORTH*  
*Output: 2,2,EAST*  


## Test 2: All four directions
### Instructions:  
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

### Expected output:
*Output: 0,0,EAST*  
*Output: 0,0,NORTH*  
*Output: 0,0,WEST*  
*Output: 0,0,SOUTH*  
*Output: 0,0,EAST*  

### Actual output:
*Output: 0,0,EAST*  
*Output: 0,0,NORTH*  
*Output: 0,0,WEST*  
*Output: 0,0,SOUTH*  
*Output: 0,0,EAST* 

## Test 3: Robot won't fall off once reached the table border
### Instructions:
*PLACE PLACE 3,4,EAST*  
*MOVE*  
*REPORT*  
*MOVE*  
*REPORT*  
*RIGHT*  
*RIGHT*  
*MOVE*  
*REPORT*  

### Expected output:
*Output:4,4,EAST*  
*Output:4,4,EAST*  
*Output:3,4,WEST*  

### Actual output:
*Output:4,4,EAST*  
*Output:4,4,EAST*  
*Output:3,4,WEST*  

## Test 4: Add multiple robots and move them respectively.
### Instructions:
*PLACE 2,2,EAST*  
*PLACE 2,2,SOUTH*  
*PLACE 2,2,NORTH*  
*REPORT*  
*MOVE*  
*REPORT*  
*ROBOT 2*  
*REPORT*  
*MOVE*  
*REPORT*  
*ROBOT3*  
*REPORT*  
*MOVE*  
*REPORT*  
*ROBOT 1*  
*REPORT*  

### Expected output:
*Output:2,2,EAST*  
*Output:3,2,EAST*   
*Output:2,2,SOUTH*  
*Output:2,1,SOUTH*  
*Output:2,2,NORTH*  
*Output:2,3,NORTH*  
*Output:3,2,EAST*  

### Actual output:
*Output:2,2,EAST*  
*Output:3,2,EAST*   
*Output:2,2,SOUTH*  
*Output:2,1,SOUTH*  
*Output:2,2,NORTH*  
*Output:2,3,NORTH*  
*Output:3,2,EAST*  


## Test 5: Error handling

### Instructions:
*34345*  
*PLACE 1,2,BBB*  
*MOVE*  
*LEFT*  
*PLACE 1,1,EAST*  
*ASDF*  
*ROBOT 2*   

### Expected output:
*Invalid Instruction. Please retry.*   
*Invalid Instruction. Please retry.*   
*Invalid Instruction. Please retry.*   
*Invalid Instruction. Please retry.*   
(Successful. No output.)
*Invalid Instruction. Please retry.*   
*No such robot*  

### Actual output:
*Invalid Instruction. Please retry.*   
*Invalid Instruction. Please retry.*   
*Invalid Instruction. Please retry.*   
*Invalid Instruction. Please retry.*   
(Successful. No output.)
*Invalid Instruction. Please retry.*   
*No such robot*  

