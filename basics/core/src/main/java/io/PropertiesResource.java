package io;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesResource {
   private final Properties props = new Properties();

   public void getProps() throws IOException {
      try (InputStream is = Thread.currentThread()
          .getContextClassLoader()
          .getResourceAsStream("app.yaml")) {

         this.props.load(is);
         final String name = props.getProperty("name");
         final String channel = props.getProperty("channel");
         System.out.println(name + " " + channel);
      }
   }

   public static void main(String[] args) throws IOException {
      new PropertiesResource().getProps();
   }
}
