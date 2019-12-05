package com.enigma;

import com.enigma.services.CommandService;
import com.enigma.services.FileService;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        CommandService commandService = new CommandService();
        String path = System.getProperty("user.dir");
        String filename = args[0];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your choice [ 1 ] or [ 2 ] : ");
        System.out.println("1. Type command  ");
        System.out.println("2. Run command  ");
        System.out.println("==============");
        System.out.print("To : ");
        String selected = reader.readLine();
        switch (selected) {
            case "1":
                System.out.print("how many orders command: ");
                Integer orders = Integer.parseInt(reader.readLine());
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 1; i <= orders; i++) {
                    System.out.print("command ke "+ i +": ");
                    stringBuilder.append(reader.readLine() + "\n");
                }
                FileService.fileWriteCommandService(path, filename, stringBuilder.toString());
                System.out.println("output : ");
                System.out.println("=========");
                commandService.commandParse(FileService.fileReadCommandService(path, filename));
                break;
            case "2":
                commandService.commandParse(FileService.fileReadCommandService(path, filename));
                break;
            default:
                return;
        }

    }
}
