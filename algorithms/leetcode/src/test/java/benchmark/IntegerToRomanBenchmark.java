package benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.*;

import java.util.concurrent.TimeUnit;

import static solution.IntegerToRoman.*;

public class IntegerToRomanBenchmark {
   public static void main(String[] args) throws Exception {
      Options opt = new OptionsBuilder()
          .include(IntegerToRomanBenchmark.IntegerToRomanBenchmarkTest.class.getSimpleName())
          .timeUnit(TimeUnit.NANOSECONDS)
          .threads(Threads.MAX)
          .mode(Mode.AverageTime)
          .forks(1)
          .warmupIterations(3)
          .measurementIterations(3)
          .build();
      new Runner(opt).run();
   }

   public static class IntegerToRomanBenchmarkTest {

      @State(Scope.Benchmark)
      public static class StateVariables {
         int nums1 = 10;
         int nums2 = 2000;
         int nums3 = 40000;
      }

      @Benchmark
      public String test1(StateVariables state) {
         return intToRoman1(state.nums1);
      }

      @Benchmark
      public String test2(StateVariables state) {
         return intToRoman1(state.nums2);
      }

      @Benchmark
      public String test3(StateVariables state) {
         return intToRoman1(state.nums3);
      }

      @Benchmark
      public String test4(StateVariables state) {
         return intToRoman2(state.nums1);
      }

      @Benchmark
      public String test5(StateVariables state) {
         return intToRoman2(state.nums2);
      }

      @Benchmark
      public String test6(StateVariables state) {
         return intToRoman2(state.nums3);
      }
   }
}
