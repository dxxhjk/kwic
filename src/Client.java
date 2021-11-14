import java.io.*;
import java.net.*;
import java.util.Objects;
import java.util.Scanner;

public class Client extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(300L);
            String readLine = null;
            Socket socket = new Socket("127.0.0.1", 4000);
            FileReader fileReader = new FileReader("input.txt");
            PrintWriter socketOut = new PrintWriter(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.ready()){
                readLine = bufferedReader.readLine();
                System.out.println("client input: " + readLine);
                socketOut.println(readLine);
            }
            socketOut.println("##");
            System.out.println("client finished");
            bufferedReader.close();
            socketOut.close();
            fileReader.close();
            socket.close();
        } catch (UnknownHostException e) {
            System.out.println("UnknownHostException: " + e);
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
