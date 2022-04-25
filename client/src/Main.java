import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8080;

        try(Socket socket = new Socket(host, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            while (true) {

                String resp = in.readLine();

                if (resp.equals("end")) {
                    String result = in.readLine();
                    System.out.println(result);
                    break;
                }
                System.out.println(resp);

                String answer= scanner.nextLine();

                out.println(answer);

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
