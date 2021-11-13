import java.util.List;
import java.util.stream.Collectors;

public class Alphabetizer implements ChainApi {

    @Override
    public void deal(ChainContext context) {
        System.out.println("Alphabetizer working...");
        List<String> stringList = context.getStringList();
        context.setStringList(stringList
                .stream()
                .sorted()
                .collect(Collectors.toList())
        );
        System.out.println("Alphabetizer work finished");
    }
}
