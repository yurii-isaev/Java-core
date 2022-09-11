package benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

import static solution.TwoSum.twoSum1;
import static solution.TwoSum.twoSum2;

public class TwoSumBenchmark {
   public static void main(String... args) throws Exception {
      Options opt = new OptionsBuilder()
          .include(TwoSumBenchmarkTest.class.getSimpleName())
          .timeUnit(TimeUnit.NANOSECONDS) // единицы измерения времени
          .threads(Threads.MAX)           // количество задействованных потоков процессора
          .mode(Mode.AverageTime)         // режим вычисления среднего времени выполнения
          .forks(1)                       // количество проходов с прогревом и замерами
          .jvmArgs("-Xms2G", "-Xmx2G")    // параметры виртуальной машины
          .warmupIterations(3)            // количество итераций прогрева
          .measurementIterations(3)       // количество итераций замера показателей
          // .output("E:/Benchmark.log")
          .build();
      new Runner(opt).run();
   }

   public static class TwoSumBenchmarkTest {

      @State(Scope.Benchmark)
      public static class StateVariables {
         int[] nums1 = {8,4,30,2,5};
         int[] nums2 = {8,4,8,2,30,7,8,18,3,5};
         int[] nums4 = {8,4,8,2,6,7,8,18,3,30,3,9,8,9,6,7,8,12,14,5};
         int target = 35;
      }

      @Benchmark
      public int[] solution1(StateVariables state) {
         return twoSum1(state.nums1, state.target);
      }

      @Benchmark
      public int[] solution2(StateVariables state) {
         return twoSum1(state.nums2, state.target);
      }

      @Benchmark
      public int[] solution3(StateVariables state) {
         return twoSum1(state.nums4, state.target);
      }

      @Benchmark
      public int[] solution4(StateVariables state) {
         return twoSum2(state.nums1, state.target);
      }

      @Benchmark
      public int[] solution5(StateVariables state) {
         return twoSum2(state.nums2, state.target);
      }

      @Benchmark
      public int[] solution6(StateVariables state) {
         return twoSum2(state.nums4, state.target);
      }
   }
}
