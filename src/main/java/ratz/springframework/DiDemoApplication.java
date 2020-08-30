package ratz.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ratz.springframework.controllers.ConstructorInjectedController;
import ratz.springframework.controllers.GetterInjectedController;
import ratz.springframework.controllers.MyController;
import ratz.springframework.controllers.PropertyInjectedController;


@SpringBootApplication
public class DiDemoApplication {

    public static void main(String[] args) {

        ApplicationContext ctg = SpringApplication.run(DiDemoApplication.class, args);

        MyController controller = (MyController) ctg.getBean("myController");

        controller.hello();
        System.out.println(controller.hello());
        System.out.println(ctg.getBean(PropertyInjectedController.class).sayHello());
        System.out.println(ctg.getBean(GetterInjectedController.class).sayHello());
        System.out.println(ctg.getBean(ConstructorInjectedController.class).sayHello());
    }

}
