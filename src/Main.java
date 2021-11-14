import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        if (args.length < 4) {
            System.out.println("Usage: \nargs[0]: inputDir \nargs[1]: inputFile " +
                    "\nargs[2]: outputDir \nargs[3]: outputFile " +
                    "\nargs[4]: [optional]type \"socket\" to input from socket, server address \"127.0.0.1:4000\"");
            System.exit(-1);
        }

        ChainContext context;
        if (args.length > 4 && Objects.equals(args[4], "socket")) {
            context = new ChainContext(true, args);
            Client client = new Client();
            client.start();
            Chain chain = initChain(context);
            chain.doHandle();
        } else {
            context = new ChainContext(false, args);
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
