package com.mk.javase.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CopyFile {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("C:/momo/learning/test/src/main/resources/iotest.txt")) {
            FileOutputStream fout = new FileOutputStream("C:/momo/learning/test/src/main/resources/iotestcopy.txt");
            int ch = 0;
            while ((ch = fis.read()) != -1){ // end of file / go while until file end (EOF)
                char c = (char) ch; // file read one by one impact performance block thread
                fout.write(ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
