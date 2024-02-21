package academy.prog;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter your login: ");
            String loginFrom = scanner.nextLine();
            Login.set(loginFrom);

            Thread th = new Thread(new GetThread());
            th.setDaemon(true);
            th.start();

            System.out.println("View active users: /getUsers");
            System.out.println("Send message to user: @login:");
            System.out.println();
            System.out.println("Enter your message: ");
            while (true) {
                String text = scanner.nextLine();
                if (text.isEmpty()) break;

                String loginTo = null;
                if (text.startsWith("@")) {
                    loginTo = text.substring(1, text.indexOf(":"));
                    text = String.valueOf(new StringBuilder(text)
                            .delete(text.indexOf("@"), text.indexOf(":") + 1));
                }
                Message m = new Message(loginFrom, loginTo, text);
                int code = m.sendLogin(Utils.getURL() + "/login", loginFrom);
                int res = m.send(Utils.getURL() + "/add");

                if (res != 200 || code != 200) { // 200 OK
                    System.out.println("HTTP error occurred: " + res);
                    return;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
