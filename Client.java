import java.net.*
//to import Socket class
// defines the server ip address and the port number of server
import java.io.*

public class Client { 
  public static void main (String [] args ) throws IOException { 
    int filesize=2022386; 
    int bytesRead; // number of bytes read from the input channel
    int currentTot = 0;
    
    Socket socket = new Socket("192.168.42.23",17142); //connect to local ip
    byte [] bytearray = new byte [filesize]; //holds temp data
    InputStream is = socket.getInputStream(); 
    FileOutputStream fos = new FileOutputStream("copy.doc"); 
    BufferedOutputStream bos = new BufferedOutputStream(fos); //write data to output file
    bytesRead = is.read(bytearray,0,bytearray.length); 
    currentTot = bytesRead; 
    do { 
      bytesRead = is.read(bytearray, currentTot, (bytearray.length-currentTot)); 
      if(bytesRead >= 0) currentTot += bytesRead; 
    } while(bytesRead > -1); //update currentTot
    bos.write(bytearray, 0 , currentTot); 
    bos.flush(); 
    bos.close(); 
    socket.close(); 
  } 
}



