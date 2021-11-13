public interface ChainApi<C extends ChainContext> {

    void deal(C context);
}
