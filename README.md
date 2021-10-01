# About
This is the code I wrote for IOOF's code test 'toy robot'. The original link is [https://github.com/ioof-holdings/recruitment/wiki/Robot-Challenge](https://github.com/ioof-holdings/recruitment/wiki/Robot-Challenge).

# Instructions
The instructions are case sensitive.

1. *PLACE [X],[Y],[F]* 

Add a toy robot to the board and assign its initial location. X is horizontal coordinate, Y is vertical coordinate, F is initial facing direction (EAST, NORTH, SOUTH or WEST). 

2. *LEFT*

Turn left the robot by 90 degrees. e.g. if the robot is facing south, after the *LEFT* instruction, it will face EAST.

3. *RIGHT*

Turn right the robot by 90 degrees.

4. *REPORT*

Report the status of the active robot.

5. *ROBOT [N]*

N is a nunber. This instruction will change the active robot to the N-th robot. e.g. if there are 3 robots, *ROBOT 3* changes active robot to the third robot.

6. *EXIT*

Exit the program
