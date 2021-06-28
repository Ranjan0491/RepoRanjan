package com.ranjan.ocp.testa;

/**
 *      1. Inner classes cannot have static declarations
 *      2. Private inner classes are not visible outside
 *      3. Static inner classes can have static members
 *      4. Static inner classes can access static members of outer class
 *      5. Static inner classes do not need instances of outer class to get instantiated
 *          X.Y y = new X.Y();
 *      6. Inner class need instances of outer class to get instantiated
 *          A.B b = new A().new B();
 */
class A{
    int a1=1;
    private int a2=2;
    static int a3=100;
    A() {
        System.out.println("A's default constructor");
    }

    class B {
        int a1=4;
        int b1=12;
//        static int b2=20;

        B() {
            System.out.println("B's default constructor");
        }

//        static void printMessage() {
//            System.out.println("B's static method");
//        }

        void print() {
            System.out.println("B's instance method");
            System.out.println("B's a1= "+a1);
            System.out.println("A's a1= "+A.this.a1);
            System.out.println("A's a2= "+a2);
            System.out.println("A's static a3= "+a3++);
            System.out.println("From B's instance method: "+printStatic());
        }
    }

    void print() {
        System.out.println("A's instance method");
    }

    static String printStatic() {
        System.out.println("A's static method");
        return "printStatic() in class A";
    }
}


public class Test {
    public static void main(String[] args) {
        System.out.println("========================= Inner class =========================");
        System.out.println();
        A a = new A();
        a.print();

        A.B b = new A().new B();
        b.print();

        System.out.println(A.a3);

        System.out.println();
        System.out.println("========================= Static Inner class =========================");
        System.out.println();

        X x = new X();
        x.print();
        X.printStatic();

        X.Y y = new X.Y();
        y.print();
        X.Y.printMessage();
        System.out.println(X.x3);

        System.out.println();
        System.out.println("========================= Enum =========================");
        System.out.println();

        Days d1 = Days.SUNDAY;
        System.out.println(d1.type);
        System.out.println(d1.dayNum);
        System.out.println(d1);

        System.out.println(d1 instanceof Days);
        System.out.println(d1 instanceof Object);
        System.out.println(d1 instanceof Enum);
    }
}


class X{
    int x1=1;
    private int x2=2;
    static int x3=100;
    X() {
        System.out.println("X's default constructor");
    }

    static class Y {
        int x1=4;
        int y1=12;
        static int y2=20;

        Y() {
            System.out.println("Y's default constructor");
        }

        static void printMessage() {
            System.out.println("Y's static method");
        }

        void print() {
            System.out.println("Y's instance method");
            System.out.println("Y's x1= "+x1);
//            System.out.println("X's x1= "+X.this.x1);
//            System.out.println("X's x2= "+x2);
            System.out.println("X's static x3= "+x3++);
            System.out.println("From Y's instance method: "+printStatic());
        }
    }

    void print() {
        System.out.println("X's instance method");
    }

    static String printStatic() {
        System.out.println("X's static method");
        return "printStatic() in class X";
    }
}

enum Days {
    MONDAY(1, "WeekDay"), TUESDAY(2, "WeekDay"), WEDNESDAY(3, "WeekDay"), THURSDAY(4, "WeekDay"), FRIDAY(5, "WeekDay"), SATURDAY(6, "WeekEnd"), SUNDAY(7, "WeekEnd");
    int dayNum;
    String type;
    Days(int dayNum, String type) {
        this.dayNum = dayNum;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Days{" +
                "dayNum=" + dayNum +
                ", type='" + type + '\'' +
                '}';
    }
}