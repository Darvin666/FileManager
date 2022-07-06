package darvin.file_manager;

import java.util.Scanner;

public class InputOfUser {

    public void input() {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        while (!input.equals(Commands.EXIT)) {
            input = scanner.nextLine();
            System.out.println(input);
        }
        
        scanner.close();
    }

}
