import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Element implements Comparable<Element> {
    private String name;

    public Element(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Element{" +
                  name + '\'' +
                '}';
    }

    public int compareTo(Element e) {
        return this.name.compareTo(e.getName());
    }
}
