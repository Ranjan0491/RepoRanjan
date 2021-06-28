package com.ranjan.oca.a;

//class M {
//    public void main(String[] args) {
//        System.out.println("M");
//    }
//}
//
//class N extends M {
//    public static void main(String[] args){
//        new M().main(args);
//    }
//}

class Super {
    int a = 1;
    static int c = 10;
    void Super() {
        System.out.println("Keep_");
    }
}

class Base extends Super {
    int a = 2;
    static int c = 20;
    static {
        System.out.println("Base static block 1");
    }
    {
        System.out.println("Base Instance block 1");
    }
    {
        System.out.println("Base Instance block 2");
    }
    static {
        System.out.println("Base static block 2");
    }

    Base() {
        Super();
        System.out.println("Going_");
        Base();
    }

    void Base() {
        System.out.println("OCA");
    }
}

public class PracticeInheritance2 {
    public static void main(String[] args){
      Super s = new Base();
      System.out.println(s.a);
      System.out.println(s.c);
      System.out.println();
      Base b = new Base();
      System.out.println(b.a);
      System.out.println(b.c);
    }
}
