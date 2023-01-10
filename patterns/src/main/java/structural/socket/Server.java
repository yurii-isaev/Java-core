package structural.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Сокеты  — название программного интерфейса для обеспечения обмена данными между процессами.
 * Процессы при таком обмене могут исполняться как на одной ЭВМ,
 * так и на различных ЭВМ, связанных между собой сетью.
 * Сокет — абстрактный объект, представляющий конечную точку соединения.
 */

public class Server {
   public static void main(String[] args) {
      try {
         // Создание серверного сокета, привязка к порту 12345
         ServerSocket serverSocket = new ServerSocket(12345);
         System.out.println("The server is running. Waiting for client connection...");

         // Ожидание подключения клиента
         Socket clientSocket = serverSocket.accept();
         System.out.println("The client connection is established.");

         // Получение потоков ввода и вывода для обмена данными
         BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
         PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

         // Чтение сообщения от клиента
         String clientMessage = reader.readLine();
         System.out.println("Message from the client: " + clientMessage);

         // Отправка ответа клиенту
         writer.println("Hello, client !");

         // Закрытие сокетов
         clientSocket.close();
         serverSocket.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
