import java.util.List;

public interface KBest<T> {

    public void count(T x);
    public List<T> kbest();

}
