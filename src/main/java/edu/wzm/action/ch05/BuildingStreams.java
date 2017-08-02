package edu.wzm.action.ch05;

import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by gatsbynewton on 2017/7/30.
 */
public class BuildingStreams {

    public static void main(String[] args)throws Exception{
        /* Stream.of() */
        Stream<String> stringStream = Stream.of("Java", "Python", "C++", "Scala");
        stringStream.forEach(System.out::println);

        /* empty Stream */
        Stream<String> emptyStream = Stream.empty();

        /* Stream.iterate() */
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        /* Fibonnaci with iterate */
        Stream.iterate(new int[]{0, 1}, ints -> new int[]{ints[1], ints[0] + ints[1]})
                .limit(10)
                .map(ints -> ints[0])
                .forEach(System.out::println);

        /* Stream.generate() */
        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

        /* IntStream generate five 1 */
        IntStream.generate(() -> 1)
                .limit(5)
                .forEach(System.out::println);

        /* Read File line by line */
        URL url = BuildingStreams.class.getClassLoader().getResource("data.txt");
        List<String> lines = Files.lines(Paths.get(url.toURI()), Charset.defaultCharset())
                .map(line -> Arrays.asList(line.split("\\s+")))
                .map(line -> String.join("", line))
//                .distinct()
                .collect(Collectors.toList());
        System.out.println(lines);
    }
}
