import java.net 
//to import ServerSocket and Socket class
//used to define the server connection port number and to accept connections from client

public class Server { 
  public static void main (String [] args ) throws IOException { 
    ServerSocket serverSocket = new ServerSocket(17142); //waits for incoming client connection on port 17142
    Socket socket = serverSocket.accept(); //store connection in Socket object
    System.out.println("Accepted connection : " + socket); 
    File transferFile = new File ("Document.doc"); //file to be transferred
    byte [] bytearray = new byte [(int)transferFile.length()]; 
    FileInputStream fin = new FileInputStream(transferFile); 
    BufferedInputStream bin = new BufferedInputStream(fin); 
    bin.read(bytearray, 0, bytearray.length); //read file
    OutputStream os = socket.getOutputStream(); 
    System.out.println("Sending Files..."); 
    os.write(bytearray, 0, bytearray.length); 
    os.flush(); 
    
    socket.close(); System.out.println("File transfer complete"); 
  } 
}

