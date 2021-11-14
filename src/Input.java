import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Input implements ChainApi {

    @Override
    public void deal(ChainContext context) {

        String readLine = null;
        List<String> stringList = new ArrayList<>();

        if (context.isInputFromSocket()) {

            try {
                ServerSocket serverSocket = new ServerSocket(context.getPort());
                Socket socket = serverSocket.accept();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (!Objects.equals(readLine, "##")) {
                    while (!bufferedReader.ready()) {}
                    readLine = bufferedReader.readLine();
                    System.out.println("input: " + readLine);
                    if (!Objects.equals(readLine, "##")) {
                        stringList.add(readLine);
                    }
                }
                bufferedReader.close();
                socket.close();
            } catch (UnknownHostException e) {
                System.out.println("UnknownHostException: " + e);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            try {
                FileReader fileReader = new FileReader(context.getInputFile());
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while (bufferedReader.ready()){
                    readLine = bufferedReader.readLine();
                    System.out.println("input: " + readLine);
                    stringList.add(readLine);
                }
                bufferedReader.close();
                fileReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("FileNotFoundException: " + e);
            } catch (IOException e) {
                System.out.println("IOException: " + e);
            }
        }
        context.setStringList(stringList);
    }
}
