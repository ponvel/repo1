package hello;

import java.time.Period;

public class HelloWorld {
  public static void main(String[] args) {
    Period currentTime = Period.ZERO;
    System.out.println("The current local time is: " + currentTime.minusMonths(2));

    Greeter greeter = new Greeter();
    System.out.println(greeter.sayHello());
  }
}