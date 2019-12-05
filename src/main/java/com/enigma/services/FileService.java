package com.enigma.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public static List<String> fileReadCommandService(String path, String fileName) {
        List<String> record = new ArrayList<>();
        File file = new File(path + "/" + fileName);
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                record.add(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return record;
    }
    public static void fileWriteCommandService(String path,String fileName,String command) {
        try {
            FileWriter fileWriter = new FileWriter(path +"/"+ fileName);
            fileWriter.write(command);
            fileWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}




