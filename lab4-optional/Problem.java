import java.util.*;

public class Problem {
    int nrElements;
    int nrPartitions;

    private Set<Element> elementSet = new TreeSet<>();
    private Set<Partition> partitionSet = new TreeSet<>();

    private Map<Element, List<Partition>> elementPrefMap = new TreeMap<>();
    private Map<Partition, List<Element>> partitionPrefMap = new TreeMap<>();

    private Map<Element, Partition> matching = new TreeMap<>();

    public int getNrElements() {
        return nrElements;
    }

    public void setNrElements(int nrElements) {
        this.nrElements = nrElements;
    }

    public int getNrPartitions() {
        return nrPartitions;
    }

    public void setNrPartitions(int nrPartitions) {
        this.nrPartitions = nrPartitions;
    }

    public Set<Element> getElementSet() {
        return elementSet;
    }

    public void setElementSet(Set<Element> elementSet) {
        this.elementSet = elementSet;
    }

    public Set<Partition> getPartitionSet() {
        return partitionSet;
    }

    public void setPartitionSet(Set<Partition> partitionSet) {
        this.partitionSet = partitionSet;
    }

    public Map<Element, List<Partition>> getElementPrefMap() {
        return elementPrefMap;
    }

    public void setElementPrefMap(Map<Element, List<Partition>> elementPrefMap) {
        this.elementPrefMap = elementPrefMap;
    }

    public Map<Partition, List<Element>> getPartitionPrefMap() {
        return partitionPrefMap;
    }

    public void setPartitionPrefMap(Map<Partition, List<Element>> partitionPrefMap) {
        this.partitionPrefMap = partitionPrefMap;
    }

    public Map<Element, Partition> getMatching() {
        return matching;
    }

    public void setMatching(Map<Element, Partition> matching) {
        this.matching = matching;
    }

    public Problem generateInstances(){
        Generator g = new Generator();
        Problem pb = new Problem();
        pb = g.generate(nrElements,nrPartitions,elementSet,partitionSet,elementPrefMap,partitionPrefMap);
        return pb;
    }

    public void matchInstances() {
        Matching m = new Matching();
        m.createMatchings(elementSet, partitionSet);
        System.out.println(m);
    }

    @Override
    public String toString() {
        return "Problem{" +
                "nrElements=" + nrElements +
                "\n, nrPartitions=" + nrPartitions +
                "\n, elementSet=" + elementSet +
                "\n, partitionSet=" + partitionSet +
                "\n, elementPrefMap=" + elementPrefMap +
                "\n, partitionPrefMap=" + partitionPrefMap +
                '}';
    }
}
