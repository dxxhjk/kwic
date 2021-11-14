import java.util.ArrayList;
import java.util.List;

public class ChainContext {

    private List<String> stringList;

    private boolean inputFromSocket;
    private int port = 4000;

    private String inputFile;
    private String outputFile;

    public ChainContext(boolean inputFromSocket, String[] args) {
        this.inputFromSocket = inputFromSocket;
        this.inputFile = args[0] + "/" + args[1];
        this.outputFile = args[2] + "/" + args[3];
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
