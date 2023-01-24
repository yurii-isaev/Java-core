package benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.*;

import java.util.concurrent.TimeUnit;

import static solution.PalindromeNumber.*;

public class PalindromeNumberBenchmark {

   public static void main(String[] args) throws Exception {
      Options opt = new OptionsBuilder()
          .include(PalindromeNumberBenchmarkTest.class.getSimpleName())
          .timeUnit(TimeUnit.NANOSECONDS)
          .threads(Threads.MAX)
          .mode(Mode.AverageTime)
          .forks(1)
          .warmupIterations(3)
          .measurementIterations(3)
          .build();
      new Runner(opt).run();
   }

   public static class PalindromeNumberBenchmarkTest {

      @State(Scope.Benchmark)
      public static class StateVariables {
         int nums1 = 12321;
         int nums2 = 1147483611;
      }

      @Benchmark
      public boolean solution1(StateVariables state) {
         return isPalindrome1(state.nums1);
      }

      @Benchmark
      public boolean solution2(StateVariables state) {
         return isPalindrome1(state.nums2);
      }

      @Benchmark
      public boolean solution3(StateVariables state) {
         return isPalindrome2(state.nums1);
      }

      @Benchmark
      public boolean solution4(StateVariables state) {
         return isPalindrome2(state.nums2);
      }
   }
}
