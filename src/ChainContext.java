import java.util.ArrayList;
import java.util.List;

public class ChainContext {

    private List<String> stringList;

    private boolean inputFromSocket;
    private int port = 4000;

    private String inputFile = "input.txt";
    private String outputFile = "output.txt";

    public ChainContext(boolean inputFromSocket) {
        this.inputFromSocket = inputFromSocket;
    }

    public int getPort() {
        return port;
    }

    public boolean isInputFromSocket() {
        return inputFromSocket;
    }

    public String getInputFile() {
        return inputFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public List<String> getStringList() {
        return this.stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }
}
