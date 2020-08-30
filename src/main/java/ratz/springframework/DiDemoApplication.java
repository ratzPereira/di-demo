package ratz.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ratz.springframework.controllers.MyController;


@SpringBootApplication
public class DiDemoApplication {

    public static void main(String[] args) {

        ApplicationContext ctg = SpringApplication.run(DiDemoApplication.class, args);

        MyController controller = (MyController) ctg.getBean("myController");

        controller.hello();
    }

}
