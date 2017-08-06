package edu.wzm.action.ch07;

import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by gatsbynewton on 2017/8/5.
 */
public class ParallelStreams {

    public static void main(String[] args){
        System.out.println(sequentialSum(10000));

        System.out.println(parallelSum(10000));

        System.out.println(rangedSum(10000));

        System.out.println(parallelRangedSum(10000));

        System.out.println(onlySequentialSum(10000));

        System.out.println(parallelAndSequentialSum(10000));

        System.out.println(sideEffectSum(10000));

        System.out.println(sideEffectParallelSum(10000));
    }

    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long sequentialSum(long N){
        long sum = Stream.iterate(1, n -> n + 1)
                .limit(N)
                .reduce(Integer::sum)
                .get();

        return sum;
    }

    public static long parallelSum(long N){
        long sum = Stream.iterate(1, n -> n + 1)
                .limit(N)
                .parallel()
                .reduce(Integer::sum)
                .get();

        return sum;
    }

    public static long rangedSum(long n){
        return LongStream.rangeClosed(1, n).sum();
    }

    public static long parallelRangedSum(long n){
        return LongStream.rangeClosed(1, n).parallel().sum();
    }

    public static long onlySequentialSum(long N){
        long sum = Stream.iterate(1, n -> n + 1)
                .limit(N)
                .filter(i -> i % 2 != 0)
                .map(i -> i - 2)
                .reduce((a, b) -> a + b)
                .get();

        return sum;
    }

    /* Using parallel() and sequential) at the same time */
    public static long parallelAndSequentialSum(long N){
        long sum = Stream.iterate(1, n -> n + 1)
                .limit(N)
                .parallel()
                .filter(i -> i % 2 != 0)
                .sequential()
                .map(i -> i - 2)
                .parallel()
                .reduce((a, b) -> a + b)
                .get();

        return sum;
    }

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);

        return accumulator.total;
    }

    /* probably get wrong sum */
    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);

        return accumulator.total;
    }

    public static class Accumulator {
        public long total = 0;

        public void add(long value){
            total += value;
        }
    }
}
