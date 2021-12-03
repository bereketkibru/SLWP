# SLWP
Sliding window protocol implementation
## Algorithm
1. start the program
2. Get the frame size from the user
3. Create the frame based on the user request
4. send the frames to server from the client side
5. If the frames reach the server the server will send ACK signal to client otherwise it will send NACK signal to the client
6. Stop the program

## To run the program
### compile the program
  >  javac slidereceiver.java

  >  javac slidsender.java
### run the program 
Then using different terminal run the compiled files using the command.

on the first terminal run this command first
>java slidesender

on the second terminal run this command
>java slidereceiver 

I implement this program using WSL(windows subsystem for Linux) and Vscode on a single machine. 

## Output

