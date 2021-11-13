import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Output implements ChainApi{

    @Override
    public void deal(ChainContext context) {
        System.out.println("Output: ");
        System.out.println(context.getStringList());

        try {
            FileWriter fileWriter = new FileWriter(context.getOutputFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            context.getStringList().forEach(string -> {
                try {
                    bufferedWriter.write(string);
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    System.out.println("IOException: " + e);
                }
            });
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }

    }
}
