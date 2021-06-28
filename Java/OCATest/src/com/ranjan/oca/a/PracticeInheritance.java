package com.ranjan.oca.a;

interface A {
    int a = 10;

    static int getA() {
        return a;
    }

    static String onlyInA() { return "This static method is in interface A"; }

    default int fetchA() {
        return a;
    }
}

interface B extends A {
    int a = 5;

    static int getA() {
        return a;
    }

    int fetchA();
}

abstract class AbsA {
    static double d = 123.456;
    final int c = 25;
    int b = 100;

    static String getStaticTextFromAbsA() {
        return "Static from AbsA";
    }

    int getB() {
        return b;
    }
}

class AImpl extends AbsA implements A {
    static int a = 20;
    int b = 200;
    String c = "Test";

    static int getA() {
        return a;
    }

    @Override
    public int fetchA() {
        return a;
    }

    @Override
    int getB() {
        return b;
    }
}

class BImpl implements B, A {
    static int a = 15;

    @Override
    public int fetchA() {
        return 0;
    }
}

public class PracticeInheritance {
    public static void main(String[] args) {
        System.out.println("A a = new AImpl(); =======================================");
        A a = new AImpl();
        System.out.println("a.fetchA(): " + a.fetchA());
        System.out.println("A.getA(): " + A.getA());
        System.out.println("a.a: " + a.a);

        System.out.println("AImpl objAImpl = new AImpl(); =======================================");
        AImpl objAImpl = new AImpl();
        System.out.println("objAImpl.a: " + AImpl.a);
        System.out.println("objAImpl.getA(): " + AImpl.getA());
        System.out.println("objAImpl.c: " + objAImpl.c);
        System.out.println("objAImpl.b: "+objAImpl.b);
        System.out.println("objAImpl.getB(): "+objAImpl.getB());
        System.out.println("objAImpl.d: "+ AbsA.d);
        System.out.println("objAImpl.getStaticTextFromAbsA(): "+ AbsA.getStaticTextFromAbsA());

        System.out.println("AbsA objAbsA = new AImpl(); =======================================");
        AbsA objAbsA = new AImpl();
        System.out.println("objAbsA.b: " + objAbsA.b);
        System.out.println("objAbsA.getB(): " + objAbsA.getB());
        System.out.println("objAbsA.c: " + objAbsA.c);

        System.out.println("A objA = new BImpl(); =======================================");
        A objA = new BImpl();
        System.out.println("objA.fetchA(): " + objA.fetchA());
        System.out.println("((B)objA).fetchA(): " + (objA.fetchA()));
        System.out.println("objA.a: " + objA.a);
        System.out.println("((B)objA).a: " + (((B) objA).a));
        System.out.println("B.a: " + B.a);
        System.out.println("B.getA(): "+B.getA());
        System.out.println("=======================================");
        System.out.println("BImpl.a: " + BImpl.a);

        A.onlyInA();

        AImpl.getStaticTextFromAbsA();
    }
}
