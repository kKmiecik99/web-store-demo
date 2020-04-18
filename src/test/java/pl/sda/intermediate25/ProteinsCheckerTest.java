package pl.sda.intermediate25;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.IntStream.iterate;

public class ProteinsCheckerTest {
    private String lines = "BDDFPQPPRRAGGHPOPDKJKPEQAAER\n" +
            "BDDFPQPFRRAGGHPOPDKJKPEQAAER\n" +
            "BDDFPQPFRRAGCHPOPDKJKPEQAAER\n" +
            "BDDFPQPFRRAGGHPOPDKJKPEQAAER\n" +
            "BDDFPOPFRRAGCHPOPDKJKPEQAAER\n" +
            "BDDFPOPFRRAGCHPOPDKJKPEQAAER\n" +
            "AABBCC\n" +
            "ACBBCA\n" +
            "BCBACA\n" +
            "ACBBCA\n" +
            "AABBCC\n" +
            "BCBACA\n" +
            "BCBACA\n" +
            "AABBCCC\n" +
            "AABBCC\n" +
            "AABBCC\n" +
            "ABBBCC\n" +
            "AABCCC\n" +
            "ABCAC\n" +
            "CACBA\n" +
            "AAAAAAAAAAAAAAAAAAAAB\n" +
            "AAAAAAAAAAAAAAAAAAAAA\n" +
            "QOOOOOOOOOOOOOOOOOOOO\n" +
            "OOOOOOOOOOOOOOOOOOOOQ";


    @Test
    void proteinsChecker() {
        String[] split = lines.split("\n");
        List<char[]> list = Arrays.stream(split)
                .map(e -> e.toCharArray())
                .peek(a -> Arrays.sort(a))
                .collect(Collectors.toList());

        iterate(1, e -> e + 2)
                .limit(list.size() / 2)
                .forEach(number -> System.out.println(Arrays.equals(list.get(number), list.get(number - 1))));
    }

    @Test
    void iteratorChecker() {
        List<Integer> listOfInts = IntStream.rangeClosed(1, 100)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> collect = iterate(1, i -> i + 10)
                .limit(listOfInts.size() / 10)
                .boxed()
                .collect(Collectors.toList());


        collect.forEach(System.out::println);
    }
}
