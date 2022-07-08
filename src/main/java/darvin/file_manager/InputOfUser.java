package darvin.file_manager;

import java.util.Scanner;

public class InputOfUser {
    FileManager fileManager = new FileManager("C:\\Users\\adm07\\Documents\\TestFolder");

    public void input() {
        Scanner scanner = new Scanner(System.in);

        String input = "";

        while (!input.equals(Commands.EXIT)) {
            System.out.print(fileManager.getCurrentFolder() + ": ");
            input = scanner.nextLine();
            String tokens[] = input.split(" ");
            String command = tokens[0];
            if(command.equals(Commands.LIST_OF_FILES)) {
                fileManager.listOfFiles(false);
            }else if (command.equals(Commands.LIST_OF_FILES_WITH_SIZE)) {
                fileManager.listOfFiles(true);
            }else if (command.equals(Commands.COPY_FILE)) {
                String sourceFileName = tokens[1];
                String destFileName = tokens[2];
                fileManager.copyFile(sourceFileName, destFileName);
            }else if (command.equals(Commands.CREATE_FILE)) {
                String fileName = tokens[1];
                fileManager.createFile(fileName);
            }else if (command.equals(Commands.FILE_CONTENT)) {
                String fileName = tokens[1];
                fileManager.content(fileName);
            }else if (command.equals(Commands.CHANGE_DIRECTORY)) {
                String newDirectory = tokens[1];
                fileManager.changeDirectory(newDirectory);
            }
        }
        
        scanner.close();
    }

}
