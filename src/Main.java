import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        ChainContext context;
        if (Objects.equals(args[0], "socket")) {
            Object lock = new Object();
            context = new ChainContext(true);
            Client client = new Client();
            client.start();
            Chain chain = initChain(context);
            chain.doHandle();
        } else {
            context = new ChainContext(false);
            Chain chain = initChain(context);
            chain.doHandle();
        }
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
