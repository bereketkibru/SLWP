import java.net.*;
import java.io.*;
import java.rmi.*;
public class slidsender
{
public static void main(String a[])throws Exception
{
//Creates a server socket, bound to the specified port which is 10.
ServerSocket ser=new ServerSocket(10);
//Listens for a connection to be made to this socket and accepts it.
Socket s=ser.accept();
//read primitive Java data types from an underlying input stream in a machine-independent way(form the system or what the user enters)
DataInputStream in=new DataInputStream(System.in);
//getInputStream() returns an input stream for the given socket  
DataInputStream in1=new DataInputStream(s.getInputStream());
String sbuff[]=new String[8];
PrintStream p;
int sptr=0,sws=8,nf,ano,i;
String ch;
do
{
p=new PrintStream(s.getOutputStream());
System.out.print("Enter the no. of frames : ");
nf=Integer.parseInt(in.readLine());
p.println(nf);
if(nf<=sws-1)
{
// accept and send the messages to be sent based on the number of frames sent
System.out.println("Enter "+nf+" Messages to be send\n");
for(i=1;i<=nf;i++)
{
sbuff[sptr]=in.readLine();
p.println(sbuff[sptr]);
sptr=++sptr%8;
}
//decrement the sender window size by the number of frames sent 
sws-=nf;
System.out.print("Acknowledgment received");
ano=Integer.parseInt(in1.readLine());
System.out.println(" for "+ano+" frames");
sws+=nf;
}
else
{
    //if frame size is greater than 7
System.out.println("The no. of frames exceeds window size");
break;
}
// requesting the user he/she wants to send more frames
System.out.print("\nDo you wants to send some more frames : ");
ch=in.readLine(); p.println(ch);
}
while(ch.equals("yes"));
s.close();
}
}
