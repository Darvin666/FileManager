package darvin.file_manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class FileManager {

    private String currentFolder;
    private String startFolder;

    public FileManager(String currentFolder) {
        this.currentFolder = currentFolder;
        this.startFolder = currentFolder;

    }

    public String getCurrentFolder() {
        return this.currentFolder;
    }

    public void copyFile(String sourceFileName, String destFileName) {
        File source = new File(currentFolder + "\\" + sourceFileName);
        File dest = new File(currentFolder + "\\" + destFileName);
        try {
            FileUtils.copyFile(source, dest);
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    public void listOfFiles(boolean withSize) {
        File currentFolderAsFile = new File(startFolder);
        File files[] = currentFolderAsFile.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                if (withSize) {
                    System.out.println(file.getName() + "\\ " + FileUtils.sizeOfDirectory(file));

                } else {
                    System.out.println(file.getName() + "\\ ");
                }
            } else {
                if (withSize) {
                    System.out.println(file.getName() + " " + file.length());

                } else {
                    System.out.println(file.getName());
                }
                System.out.println();
            }
        }

    }

    public void createFile(String fileName) {
        File file = new File(currentFolder + "\\" + fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("error");
        }
    }

    public void content(String fileName) {
        File file = new File(currentFolder + "\\" + fileName);
        try {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();}
        reader.close();
        }catch (IOException e) {
            System.err.println("error");
        }
        }

    public void changeDirectory(String newDirectory) {
        // TODO Auto-generated method stub
        
    }
    }
