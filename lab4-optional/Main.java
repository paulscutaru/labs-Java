import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Problem pb = new Problem();
        pb=pb.generateInstances();
        System.out.println(pb);
        pb.matchInstances();
    }
}
