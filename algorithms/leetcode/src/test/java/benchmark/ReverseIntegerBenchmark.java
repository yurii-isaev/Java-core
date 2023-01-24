package benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.*;

import java.util.concurrent.TimeUnit;

import static solution.ReverseInteger.*;

public class ReverseIntegerBenchmark {
   public static void main(String[] args) throws Exception {
      Options opt = new OptionsBuilder()
          .include(ReverseIntegerBenchmark.ReverseIntegerBenchmarkTest.class.getSimpleName())
          .timeUnit(TimeUnit.NANOSECONDS)
          .threads(Threads.MAX)
          .mode(Mode.AverageTime)
          .forks(1)
          .warmupIterations(3)
          .measurementIterations(3)
          .build();
      new Runner(opt).run();
   }

   public static class ReverseIntegerBenchmarkTest {

      @State(Scope.Benchmark)
      public static class StateVariables {
         int nums1 = 12321;
         int nums2 = 1147483611;
      }

      @Benchmark
      public int solution1(StateVariables state) {
         return reverse1(state.nums1);
      }

      @Benchmark
      public int solution2(StateVariables state) {
         return reverse1(state.nums2);
      }

      @Benchmark
      public int solution3(StateVariables state) {
         return reverse2(state.nums1);
      }

      @Benchmark
      public int solution4(StateVariables state) {
         return reverse2(state.nums2);
      }
   }
}
