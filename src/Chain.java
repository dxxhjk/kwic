import java.util.ArrayList;
import java.util.List;

public class Chain {

    private ChainContext context;

    private List<ChainApi> handles = new ArrayList();

    public Chain(ChainContext context) {
        this.context = context;
    }

    @SuppressWarnings("unchecked")
    public void doHandle() {
        try {
            handles.forEach(handle -> handle.deal(context));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void setHandles(List<ChainApi> handles) {
        this.handles = handles;
    }
}
