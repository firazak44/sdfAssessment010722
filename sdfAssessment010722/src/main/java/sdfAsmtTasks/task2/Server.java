package sdfAsmtTasks.task2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static byte[] main( String[] args ) throws IOException{
        String serverPort = args[0];

        while(true){
            ServerSocket svSoc = new ServerSocket(Integer.parseInt(serverPort));
            System.out.println("Server listening on port %s" + svSoc);
            Socket clSoc = svSoc.accept();
            InputStream is = clSoc.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            String requestFromClient = ois.readUTF();
            System.out.printf("Received: %s\n", requestFromClient);
            OutputStream os = clSoc.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);

            String requestID = "1234abcd";
            if(true && requestFromClient.equals(requestID) && requestFromClient.equals(AverageNum)){
                oos.writeUTF(requestID);
                oos.writeUTF("NameAsOfNRIC");
                oos.writeUTF("ValidEmail");
                oos.writeFloat((float) AverageNum);
            }

            //Converting Object to Byte//
            byte[] convertObjectToBytes(String requestID) {
                ByteArrayOutputStream boas = new ByteArrayOutputStream();
                try (ObjectOutputStream oos2 = new ObjectOutputStream(boas)) {
                    oos2.writeObject(requestID);
                    return boas.toByteArray();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
                throw new RuntimeException();
            }

            byte[] b = {1,2,3,4}; //where byte-digits represent as the four objects respectively
            try {
                is = new ByteArrayInputStream(b);
                ois = new ObjectInputStream(is);
                while( ois.available() >0) {
                   System.out.println(ois.readBoolean());
                }
            } catch(Exception e) {
               e.printStackTrace();
            } finally {
               if(is!=null)
                   is.close();
               if(ois!=null)
                   ois.close();
            }
            

            is.close();
            os.close();
            clSoc.close();
        }
    }
}