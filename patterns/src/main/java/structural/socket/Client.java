package structural.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
   public static void main(String[] args) {
      try {
         // Создание клиентского сокета и подключение к серверу
         Socket socket = new Socket("localhost", 12345);

         // Получение потоков ввода и вывода для обмена данными
         BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
         PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

         // Отправка сообщения серверу
         writer.println("Hello, server!");

         // Чтение ответа от сервера
         String serverResponse = reader.readLine();
         System.out.println("Server response: " + serverResponse);

         // Закрытие сокета
         socket.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
