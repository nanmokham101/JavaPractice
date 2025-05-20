package com.mk.javase.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
    File read -> Input Stream
    File write -> Output Stream
    java run in target file
 */
public class ReadFile {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C:/momo/learning/test/src/main/resources/iotest.txt");
            int ch = 0;
            while ((ch = fis.read()) != -1){ // end of file / go while until file end
                char c = (char) ch; // file read one by one impact performance block thread
                System.out.print(c); // output : This is I/O Stream testing.
            }
            try {
                fis.close(); // close file -> if not close out of memory
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
