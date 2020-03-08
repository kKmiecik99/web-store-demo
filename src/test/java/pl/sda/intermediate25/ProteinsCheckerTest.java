package pl.sda.intermediate25;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        IntStream.iterate(1,e->e+2)
                .limit(list.size()/2)
                .forEach(number-> System.out.println(Arrays.equals(list.get(number), list.get(number - 1))));
    }
}
