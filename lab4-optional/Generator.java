import com.github.javafaker.Faker;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class Generator {
    int nrElements;
    int nrPartitions;

    private Set<Element> elementSet = new TreeSet<>();
    private Set<Partition> partitionSet = new TreeSet<>();

    private Map<Element, List<Partition>> elementPrefMap = new TreeMap<>();
    private Map<Partition, List<Element>> partitionPrefMap = new TreeMap<>();

    public void generateInstances() {
        Faker faker = new Faker();
        nrElements = (int) (Math.random() * 50) + 1;
        nrPartitions = (int) (Math.random() * 10) + 1;
        Element[] e = IntStream.rangeClosed(0, nrElements).mapToObj(i -> new Element(faker.name().lastName())).toArray(Element[]::new);
        Partition[] p = IntStream.rangeClosed(0, nrPartitions).mapToObj(i -> new Partition(faker.medical().hospitalName())).toArray(Partition[]::new);

        elementSet.addAll(Arrays.asList(e));
        partitionSet.addAll(Arrays.asList(p));

        for (int i = 0; i < nrPartitions; i++) {
            int capacity = (int) (Math.random() * 10) + 1;
            p[i].setCapacity(capacity);
        }

        //generate random preferences of hospitals for each resident
        for (int i = 0; i < nrElements; i++) {
            int nrPrefPartitions = (int) (Math.random() * 10) + 1;
            for (int j = 0; j < nrPrefPartitions; j++) {
                int partition = (int) (Math.random() * nrPartitions);
                elementPrefMap.put(e[i], Collections.singletonList(p[partition]));
            }
        }

        //generate random preferences of resident for each hospital
        for (int i = 0; i < nrPartitions; i++) {
            int nrPrefElements = (int) (Math.random() * 50) + 1;
            for (int j = 0; j < nrPrefElements; j++) {
                int element = (int) (Math.random() * nrElements);
                partitionPrefMap.put(p[i], Arrays.asList(e[element]));
            }
        }
    }

    public void matchInstances() {
        Matching m = new Matching();
        m.createMatchings(elementSet,partitionSet);
        System.out.println(m);
    }

    @Override
    public String toString() {
        return "Generator{" +
                "nrElements=" + nrElements +
                "\n,nrPartitions=" + nrPartitions +
                "\n,elementSet=" + elementSet +
                "\n, partitionSet=" + partitionSet +
                "\n, elementPrefMap=" + elementPrefMap +
                "\n, partitionPrefMap=" + partitionPrefMap +
                '}';
    }
}
