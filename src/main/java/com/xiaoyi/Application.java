package com.xiaoyi;

import com.xiaoyi.controllers.AnimalPurchaseController;
import com.xiaoyi.controllers.AnimalQueryController;
import com.xiaoyi.controllers.LoginController;
import com.xiaoyi.controllers.RegisterController;
import com.xiaoyi.models.Animal;
import com.xiaoyi.models.Location;
import com.xiaoyi.models.User;
import com.xiaoyi.models.animals.Cat;
import com.xiaoyi.models.animals.Dog;
import com.xiaoyi.models.enums.AnimalType;
import com.xiaoyi.models.enums.CatType;
import com.xiaoyi.models.enums.DogType;
import com.xiaoyi.models.payments.Paypal;
import com.xiaoyi.services.AnimalService;
import com.xiaoyi.services.UserService;
import com.xiaoyi.storages.AnimalStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Application {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }




//    private static void localConsole() {
//        AnimalStorage animalStorage = new AnimalStorage();
//
//        UserService userService = new UserService();
//
//        AnimalService animalService = new AnimalService(animalStorage);
//
//        LoginController loginController = new LoginController(userService);
//
//        RegisterController registerController = new RegisterController(userService);
//
//        AnimalQueryController animalQueryController = new AnimalQueryController(animalService);
//
//        AnimalPurchaseController animalPurchaseController = new AnimalPurchaseController(userService, animalService);
//
//        registerController.register(User.builder()
//                .username("xiaoyi")
//                .password("123")
//                .mobile("123")
//                .email("xiaoyichen@gmail.com")
//                .location(Location.builder()
//                        .country("US")
//                        .state("IL")
//                        .city("Chicago")
//                        .zipcode("60616")
//                        .build())
//                .payment(Paypal.builder()
//                        .balance(BigDecimal.TEN)
//                        .build())
//                .build());
//
//        loginController.login("xiaoyi", "123");
//
//        animalStorage.insertOrUpdate(Dog.builder()
//                .animalType(AnimalType.DOG)
//                .price(BigDecimal.valueOf(3.0))
//                .dogType(DogType.Akita)
//                .build());
//
//        animalStorage.insertOrUpdate(Cat.builder()
//                .animalType(AnimalType.CAT)
//                .price(BigDecimal.valueOf(8.0))
//                .catType(CatType.Bombay)
//                .build());
//
//        while (true) {
//            System.out.println("please choose function. Type 1 to get all animal, " +
//                    "type 2 to query animal, " +
//                    "type 3 to buy animal");
//            if (SCANNER.hasNextInt()) {
//                int function = SCANNER.nextInt();
//                if (function == 1) {
//                    System.out.println("****Animal List page****");
//                    List<Animal> animals = animalQueryController.getAllAnimal();
//                    animals.forEach(animal -> System.out.println(animal.toString()));
//
//                } else if (function == 2) {
//                    System.out.println("****Query page****");
//                    System.out.println("Enter the animalType : ");
//                    String animalType = SCANNER.next();
//
//                    System.out.println("Enter the subType : ");
//                    String subtype = SCANNER.next();
//
//                    System.out.println("Enter the highest price : ");
//                    double highest = SCANNER.nextDouble();
//
//                    System.out.println("Enter the lowest price : ");
//                    double lowest = SCANNER.nextDouble();
//
//                    List<Animal> animals = animalQueryController.queryAnimal(AnimalType.valueOf(animalType),
//                            BigDecimal.valueOf(lowest), BigDecimal.valueOf(highest), subtype);
//
//                    animals.forEach(animal -> System.out.println(animal.toString()));
//
//                } else if (function == 3) {
//                    System.out.println("****Purchase page****");
//                    System.out.println("Current animals : ");
//                    List<Animal> animals = animalQueryController.getAllAnimal();
//                    animals.forEach(animal -> System.out.println(animal.toString()));
//                    System.out.println("Enter the id to purchase : ");
//                    long id = SCANNER.nextLong();
//                    animalPurchaseController.purchaseAnimal(animalQueryController.getAnimalInfo(id));
//
//                } else {
//                    System.out.println("please input again");
//                }
//            }
//            User user = loginController.getCurrentUser();
//            System.out.println("Current user: " + ((user == null) ?
//                    "null" :
//                    user.toString()));
//        }
//    }
}
