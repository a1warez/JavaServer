package ru.test.HW.dz1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ModifiedClient {

    private static final int PORT = 54321;
    private static final String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        try (SocketChannel client = SocketChannel.open(new InetSocketAddress(HOST, PORT))) {
            System.out.print("Выберите действие (mul, div, add, sub): ");
            String operation = scanner.nextLine();


            if (operation == null || operation.trim().isEmpty()) {
                System.out.println("Действие не выбрано. Завершение.");
                return;
            }

            ByteBuffer buffer = ByteBuffer.wrap(operation.getBytes(StandardCharsets.UTF_8));
            client.write(buffer);

            ByteBuffer responseBuffer = ByteBuffer.allocate(1024);
            int bytesRead = client.read(responseBuffer);

            if (bytesRead > 0) {
                responseBuffer.flip();
                String response = StandardCharsets.UTF_8.decode(responseBuffer).toString().trim();
                System.out.println("Результат: " + response);
            } else {
                System.out.println("Сервер не вернул ответ.");
            }

        } catch (IOException e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
