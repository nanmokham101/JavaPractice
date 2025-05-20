package com.mk.javase.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*
    jdk 7+
    file read
    try{
    }catch{
    }
    finally{
        file close // if operation done not to close file . don't close can't reclaim the usage of this file in memory
        network close // not close memory leak
    }
    In modern java use TryWithResource
    I/O -> contain file and network . sout -> output , scanner -> input
    more advance -> NI/O -> new input output -> Stream -> do in order
    2 Type in file
        Readable(human)             Non-readable(machine)
        text file                   binary file(byte code) -> read with ByteStream
                                    java file, txt -> read with CharacterStream
    have predefined Stream -> System.out.println -> out
    Auto close file
    1 Thread use / why thread block
        CUP
        I/O
    if Thread 1 use I/O -> not use CPU -> slow -> not OK read 1 by 1 Character // Thread 1 block
        turn CPU to thread 2
    Transient -> not persistence / Volatile -> wine pee change , opposite with Synchronized => not use in real world
    instanceof -> check object present in Hierarchy / check runtime what type of instance/ pattern not good / when type cast in runtime can occur error
    Native Method -> in JVM there is no read file code for read thread / System Call (call os read file thread) -> OS system has C++
    JVM byte code call Native code(C or C++ implement)
 */
public class TryWithResourceDemo {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("C:/momo/learning/test/src/main/resources/iotest.txt")) {
            int ch = 0;
            while ((ch = fis.read()) != -1){ // end of file / go while until file end (EOF)
                char c = (char) ch; // file read one by one impact performance block thread
                System.out.print(c); // output : This is I/O Stream testing.
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
