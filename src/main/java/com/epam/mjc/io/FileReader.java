package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file){
        String str[] = new String[4];
        try(BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))){
            String line = bufferedReader.readLine();
            int i = 0;
            while (line!=null){
                str[i] = line;
                line = bufferedReader.readLine();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String name = str[0].substring(str[0].indexOf(" ")+1);
        int age = Integer.parseInt(str[1].substring(str[1].indexOf(" ")+1));
        String email = str[2].substring(str[2].indexOf(" ")+1);
        Long phone = Long.parseLong(str[3].substring(str[3].indexOf(" ")+1));

        return new Profile(name,age,email,phone);
    }
}
