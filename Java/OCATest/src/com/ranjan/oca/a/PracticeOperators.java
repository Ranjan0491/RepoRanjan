package com.ranjan.oca.a;

/**
 * Operator Precedence rules:
 * 1. expr++, expr--
 * 2. ++expr, --expr, !, +expr, -expr
 * 3. *, /, %
 * 4. +, -
 * 5. >>, <<, >>>
 * 6. <, >, <=, >=, instanceof
 * 7. ==, !=
 * 8. &
 * 9. ^
 * 10. |
 * 11. &&
 * 12. ||
 * 13. ? :
 * 14. =, +=, -=, *=, /=, %=, &=, ^=, |=, <<=, >>=, >>>=
 */
public class PracticeOperators {
    public static void main(String[] args) {
        char c = 7;
        char c1 ='7';
        System.out.println("c= "+c);
        System.out.println("c1= "+c1);
        int i=c;
        int i1=c1;
        System.out.println("i= "+i);
        System.out.println("i1= "+i1);
        byte b= (byte) c;
        byte b1=(byte) c1;
        System.out.println("b= "+b);
        System.out.println("b1= "+b1);

        byte byte1=100;
        short short1=byte1;
        int int1=byte1;
        int int2=short1;
        long long1=int1;
        long long2=short1;
        long long3=byte1;
        float float1=int1;
        float float2=long1;
        double double1=int1;
        double double2=float1;
        double double3=long1;
        System.out.println(float2);
        System.out.println(double2);

        int int3= (int) long1;
        float float3 = (float) double1;
        int int4 = (int) float1;
        int int5= (int) double1;

        Integer integer1 = 127;
        Integer integer2 = 127;
        Integer integer3 = 128;
        Integer integer4 = 128;
        System.out.println(integer1==integer2);
        System.out.println(integer3==integer4);
        Object object1=200.0;
        System.out.println(object1 instanceof Double);
        overload(10, 10);
        overload(Integer.valueOf(10), Integer.valueOf(10));
        overload(10.0, 10.0);
    }

    public static void overload(int a, int b) {
        System.out.println("int");
    }
//    public static void overload(double a, double b) {
//        System.out.println("double");
//    }
//    public static void overload(Integer a, Integer b) {
//        System.out.println("Integer");
//    }
    public static void overload(Object a, Object b) {
        System.out.println("Object");
    }
}
