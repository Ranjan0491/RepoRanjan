package com.ranjan.oca.a;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class NotSure {
  @Override
  public String toString() {
    return null;
  }
}

public class PracticeSpecialClasses {

  public static void main(String[] args) {
    LocalDate date1 = LocalDate.parse("2021-01-29");
    System.out.println(date1);
    LocalDate date2 = date1.plusMonths(1);
    System.out.println(date2);
    LocalDate date3 = date1.minusDays(-10);
    System.out.println(date3);

    List<String> list = new ArrayList<>();
    list.add("P");
    list.add("T");
    list.add(1, "O");
    System.out.println(list);

    List<String> subList = list.subList(1, 2);
    subList.set(0, "E");
    System.out.println(subList);
    System.out.println(list);

    String text = null;
    text = text + new NotSure();
    System.out.println(text + " - " + text.length());

    boolean flag1 = "Java" == "Java".replace('J', 'J');
    boolean flag2 = "Java" == "Java".replace("J", "J");
    System.out.println(flag1 + "  " + flag2);

    byte b = 10;
    List<Integer> list1 = new ArrayList<>();
    //        list1.add(b);

    String dateStr = LocalDate.parse("2021-03-11").format(DateTimeFormatter.ISO_LOCAL_DATE);
    System.out.println(dateStr);
    String dateTimeStr = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
    System.out.println(dateTimeStr);
    String timeStr = LocalTime.now().format(DateTimeFormatter.ISO_TIME);
    System.out.println(timeStr);

    String[] names = {"Arnold", "Tom", "Jack", "Lewis", "Aron", "John", "Margaret"};
    Predicate<String> predicate = n -> {return n.startsWith("A");};
    filterStrings(names, predicate);
  }

  public static void filterStrings(String[] names, Predicate<String> predicate) {
    for(String n: names) {
      if(predicate.test(n))
        System.out.print(n+" ");
    }
  }
}
