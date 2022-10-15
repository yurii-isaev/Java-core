package annotation;

import java.lang.reflect.Method;

public class Executor {

   public void execute(Object obj) {
      for (Method method : obj.getClass().getMethods()) {
         if (method.getAnnotation(Callable.class) != null) {
            try {
               method.invoke(obj);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      }
   }
}
