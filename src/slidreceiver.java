import java.net.*;
import java.io.*;
class slidreceiver
{
public static void main(String a[])throws Exception
{
//open a socket that is connected to the server running on the specified localhost ip and 10:
Socket s=new Socket(InetAddress.getLocalHost(),10);
//read primitive Java data types from an underlying input stream in a machine-independent way
DataInputStream in=new DataInputStream(s.getInputStream());

PrintStream p=new PrintStream(s.getOutputStream());
//
int i=0,rptr=-1,nf,rws=8;
String rbuf[]=new String[8];
String ch; System.out.println();
do
{
nf=Integer.parseInt(in.readLine());
if(nf<=rws-1)
{
//looping through the number of frames and printing the message received
for(i=1;i<=nf;i++)
{
    //incrementing the n
rptr=++rptr%8;
rbuf[rptr]=in.readLine();
System.out.println("The received Frame " +rptr+" is : "+rbuf[rptr]);
}
//received window size = received window size- number of frames
rws-=nf;
System.out.println("\nAcknowledgment sent\n");
p.println(rptr+1); rws+=nf; }
else
break;

ch=in.readLine();
}
while(ch.equals("yes"));
}
}