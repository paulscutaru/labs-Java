import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Generator g = new Generator();
        g.generateInstances();
        System.out.println(g + "\n");
        g.matchInstances();

    }
}
