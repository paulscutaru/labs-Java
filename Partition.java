import java.util.*;

public class Partition implements Comparable<Partition>{
    private String name;
    private int capacity;
    private List<Element> elements = new ArrayList<Element>();
    Map<Partition, List<Element>> partitionPrefMap = new TreeMap<>();

    public Partition(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void addElements(Element... elements)
    {
        this.elements.addAll(Arrays.asList(elements));
    }

    public int compareTo(Partition p) {
        return this.name.compareTo(p.getName());
    }

    @Override
    public String toString() {
        return "Partition{" +
                 name + '\'' +
                ", capacity=" + capacity +
                '}' + "\n";
    }
}
