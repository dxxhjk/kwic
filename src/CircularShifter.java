import java.util.*;
import java.util.stream.Collectors;

public class CircularShifter implements ChainApi {

    @Override
    public void deal(ChainContext context) {

        System.out.println("Circular shifter working...");
        List<String> stringList = context.getStringList()
                .stream()
                .map(this::getCircularShift)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
        context.setStringList(stringList);
        System.out.println("Circular shifter work finished");
    }

    private List<String> getCircularShift(String s) {

        String[] wordList = s.split(" ");
        if (wordList.length == 1) {
            return Collections.singletonList(wordList[0]);
        }
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < wordList.length; i++) {
            StringBuilder sb = new StringBuilder(wordList[i]);
            if (i == wordList.length - 1){
                for (int j = 0; j < (wordList.length - 1); j++) {
                    sb.append(" ").append(wordList[j]);
                }
            }
            else {
                for (int j = i + 1; j < wordList.length; j++) {
                    sb.append(" ").append(wordList[j]);
                }
                for (int j = 0; j < i; j++) {
                    sb.append(" ").append(wordList[j]);
                }
            }
            stringList.add(sb.toString());
        }
        return stringList;
    }
}
