import java.util.*;

public class Matching {
    Map<Element, Partition> matching = new TreeMap<>();

    public void createMatchings(Set<Element> elements, Set<Partition> partitions) {
        for (Element e : elements) {
            boolean stop = false;

            for (Partition p : partitions)
                if (p.getCapacity() > 0 && !stop) {
                    matching.put(e, p);
                    p.setCapacity(p.getCapacity() - 1);
                    stop = true;
                }

        }
    }
    @Override
    public String toString() {
        return "Matching{" +
                "matching=" + matching +
                '}';
    }
}
