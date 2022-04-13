package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user;

      user = new User("User1", "Lastname1", "user1@mail.ru");
      user.setCar(new Car("BMW", 2011));
      userService.add(user);

      user = new User("User2", "Lastname2", "user2@mail.ru");
      user.setCar(new Car("Audi", 2012));
      userService.add(user);

      user = new User("User3", "Lastname3", "user3@mail.ru");
      user.setCar(new Car("Honda", 2013));
      userService.add(user);

      user = new User("User4", "Lastname4", "user4@mail.ru");
      user.setCar(new Car("Cadillac", 2014));
      userService.add(user);

      List<User> users = userService.listUsers();
      for (User u : users) {
         System.out.println("Id = " + u.getId());
         System.out.println("First Name = " + u.getFirstName());
         System.out.println("Last Name = " + u.getLastName());
         System.out.println("Email = " + u.getEmail());
         System.out.println("Car = " + u.getCar().toString());
         System.out.println();
      }

      System.out.println(userService.userOfCar("Cadillac", 2011));

      context.close();
   }
}