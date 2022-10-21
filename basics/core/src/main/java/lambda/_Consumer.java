package lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Consumer (с англ. — “потребитель”) — функциональный интерфейс,
 * который принимает в качестве входного аргумента объект типа T,
 * совершает некоторые действия, но при этом ничего не возвращает:
 */

public class _Consumer {
   public static void main(String[] args) {
      Customer maria = new Customer("Maria", "12345");

      // Execution by normal java function
      greetCustomer(maria);

      // Execution by consumer functional interface
      greetCustomerByConsumer.accept(maria);

      // Execution by bi consumer functional interface
      greetCustomerByConsumerBi.accept(maria, true);
   }

   static class Customer {
      private final String name;
      private final String number;

      public Customer(String name, String number) {
         this.name = name;
         this.number = number;
      }
   }

   static void greetCustomer (Customer customer) {
      System.out.printf("Hello %s, thanks for registration: %s \n", customer.name, customer.number);
   }

   static Consumer<Customer> greetCustomerByConsumer = c ->
       System.out.printf("Hello %s, thanks for registration: %s \n", c.name, c.number);

   static BiConsumer<Customer, Boolean> greetCustomerByConsumerBi = (t, u) ->
       System.out.printf("Hello %s, thanks for registration: %s \n",
           t.name, (u ? t.number : "*****"));
}
