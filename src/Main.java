import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ChainContext context = new ChainContext(false);
        Chain chain = initChain(context);
        chain.doHandle();
    }

    private static Chain initChain(ChainContext context) {

        Chain chain = new Chain(context);
        List<ChainApi> chainApiList = new ArrayList<>();
        chainApiList.add(new Input());
        chainApiList.add(new CircularShifter());
        chainApiList.add(new Alphabetizer());
        chainApiList.add(new Output());
        chain.setHandles(chainApiList);

        return chain;
    }
}
