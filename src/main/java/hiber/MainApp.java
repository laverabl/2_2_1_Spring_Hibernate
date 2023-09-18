package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.model.Car;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("Kia", 2005);
      Car car2 = new Car("Reno", 2000);
      Car car3 = new Car("Mercedes", 2001);

      User user1 = new User("User1", "Lastname1", "user1@");
      User user2 = new User("User2", "Lastname2", "user2@");
      User user3 = new User("User3", "Lastname3", "user3@");

      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);
      car1.setUser(user1);
      car2.setUser(user2);
      car3.setUser(user3);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);

      System.out.println("User's list:");
      userService.listUsers().forEach(System.out::println);

      System.out.println();

      System.out.println("User with according parameters");
      User user11 = userService.getUserByModel("Kia", 2005);
      System.out.println(user11);


      context.close();
   }
}