package async.completableFuture.supplyAsyn.data;

import async.completableFuture.supplyAsyn.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.List;

public class EmployeeDatabase {

   public static List<Employee> fetchEmployees() {
      ObjectMapper mapper = new ObjectMapper();

      try {
         return mapper.readValue(
             new File(RunAsyncDemo.FILE_SRC),
             new TypeReference<List<Employee>>() {}
         );
      } catch (IOException e) {
         e.printStackTrace();
      }

      return null;
   }
}
