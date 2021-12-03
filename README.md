# SLWP
Sliding window protocol implementation.

The implementation that has been done so far is that it will accept a frame size from the user that is one less than the send window size.  and send thos mesages the acknoledgent will reach when all the messages are delivered to the reciever. Here there are two assumptions one is that the messages will reach the reciver without error and with order.

However, this assumption is incorrect for real-time implementation, as some additional time delay and frame loss management will be introduced to the code to correctly support the Slide window protocol.
## Algorithm
1. start the program
2. Get the frame size from the user
3. Create the frame based on the user request
4. send the frames to server from the client side
5. If the frames reach the server the server will send ACK signal to client otherwise it will send NACK signal to the client
6. Stop the program

## To run the program

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/bereketkibru/SLWP.git
   ```
2. Run
### compile the program
   ```sh
    javac slidereceiver.java
    javac slidsender.java
   ```
### run the program 
Then using different terminal run the compiled files using the command.

on the first terminal run this command first
```sh
    java slidesender
   ```
on the second terminal run this command
```sh
   java slidereceiver 
   ```

I implement this program using WSL(windows subsystem for Linux) and Vscode on a single machine. 

## Output
### sender
```sh
Enter the no of frames : 3
Enter 3 messages to be send

first message
second message
third message

Acknowledgment received for 3 frames
```

### Receiver
```sh
The received Frame 0 is : first message
The received Frame 1 is : second message      The received Frame 2 is : third message 

Acknowledgment sent
```