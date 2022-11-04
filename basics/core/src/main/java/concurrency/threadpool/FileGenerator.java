package concurrency.threadpool;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class FileGenerator implements Callable {

   @Override
   public Object call() throws Exception {
      String threadName = Thread.currentThread().getName();
      List<String> fileList = new LinkedList<>();

      for (int i = 0; i < 10; i++) {
         String fileName = "/Users/Shved/Desktop/test" + threadName + "_" + i + ".txt";
         fileList.add(fileName);

         try (OutputStream ou = new FileOutputStream(fileName);
              BufferedOutputStream bos = new BufferedOutputStream(ou)) {
            bos.write(("Java " + i).getBytes());
            bos.flush();
            System.out.println(threadName + " record file " + fileName);
         }
      }
      Thread.sleep(1000);
      return fileList;
   }

   public static void main(String[] args) throws ExecutionException, InterruptedException {
      ExecutorService pool = Executors.newFixedThreadPool(3);
      Set<Future<List<String>>> futures = new HashSet<>();

      for (int i = 0; i < 10; i++) {
         Callable<List<String>> fileGenerator = new FileGenerator();
         Future<List<String>> future = pool.submit(fileGenerator);
         futures.add(future);
      }

      List<String> resultList = new ArrayList<>();
      for (Future<List<String>> future : futures) {
         resultList.addAll(future.get());
      }

      pool.shutdown();
   }
}
