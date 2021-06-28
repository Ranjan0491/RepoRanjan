package com.ranjan.oca.a;

import java.io.FileNotFoundException;
import java.io.IOException;

interface I1 {
    default void testCheckedException() throws Exception {
        throw new Exception("throwing Exception from I1");
    }

    void abstractTestCheckedException() throws IOException;
}

interface I2 extends I1 {
//    void testCheckedException() throws Exception;
    void abstractTestCheckedException() throws FileNotFoundException;
}

class C1 {
    C1() throws IOException {
        System.out.println("C1 constructor");
        throw new IOException("IOException from C1 constructor");
    }

    void testM() {
        System.out.println("C1 testM()");
    }
}

class C2 extends C1 implements I2{
    C2() throws IOException {
        super();
        System.out.println("C2 constructor");
        throw new IOException("IOException from C2 constructor");
    }

    @Override
    public void testCheckedException() throws Exception {

    }

    @Override
    public void abstractTestCheckedException() throws FileNotFoundException {

    }

    void testM() throws RuntimeException{
        System.out.println("C2 testM()");
    }
}

class C3 {
    void testException() throws Exception {
        try {
            new C2();
        } catch (Exception e) {
//            e = new IOException("IOException caught as Exception and creating a new IOexception in C3 testException()");
//            e = new Exception("IOException caught as Exception and creating a new Exception in C3 testException()");
            e = new FileNotFoundException("IOException caught as Exception and creating a new FileNotFoundException in C3 testException()");
//            e=null;
            throw e;
        } finally {
            System.out.println("Inside C3 testException() finally");
        }
    }
}

public class PracticeExceptions {
    public static void main(String[] args) {
        try {
//            C2 objC2 = new C2();
//            objC2.testCheckedException();  // Compilation error as the method throws Exception
//            objC2.abstractTestCheckedException();
            new C3().testException();
        } catch (IOException e) {
            System.out.println("IOException block: "+e.getClass().getName()+" - "+e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception block: "+e.getClass().getName()+" - "+e.getMessage());
        }

        try {
            new C1();
        } catch (IOException e) {
            System.out.println("IOException block: "+e.getClass().getName()+" - "+e.getMessage());
        }

    }
}
