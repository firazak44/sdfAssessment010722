package sdfAsmtTasks.task2;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String args[]){
        boolean stop = false;
        String[] arr = args[0].split(",");
        

        try {
            String response = null;
            Socket clSoc = new Socket("task02.chuklee.com",80);
            InputStream is = clSoc.getInputStream();
            OutputStream os = clSoc.getOutputStream();
            ObjectInputStream ois = new ObjectInputStream(clSoc.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(clSoc.getOutputStream());

            Console con = System.console();
            String input = con.readLine("Sending to server > ");

            if(!stop){
                try{
                    response = ois.readUTF(); 
                }catch(IOException e){
                   
                }
                
                if(response.contains("1234abcd") || response.contains("email") 
                    || response.contains("NRIC") || response.contains(AverageNum)){
                    System.out.println(response);
                    response.split(",");
                    String[] details = response.split(",");
                    if(response.contains("1234abcd")){
                        System.out.printf("Your ID is >> %s\n");
                    }
                    if(response.contains("email")){
                        System.out.printf("Your email is >> %s\n");
                    }
                    if(response.contains("NameAsOfNRIC")){
                        System.out.printf("Your Name is >> %s\n");
                    }
                    if(response.contains(AverageNum)){
                        System.out.printf("The average list of numbers is >> %s\n", AverageNum);
                    }
                }
            }

            if(input.equals("End"))
                stop = true;
            oos.writeUTF(input);
            oos.flush();
            is.close();
            os.close();
            clSoc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      
        
    
}
