package ratz.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ratz.springframework.controllers.ConstructorInjectedController;
import ratz.springframework.controllers.GetterInjectedController;
import ratz.springframework.controllers.MyController;
import ratz.springframework.controllers.PropertyInjectedController;
import ratz.springframework.examplebeans.FakeDataSource;


@SpringBootApplication
public class DiDemoApplication {

    public static void main(String[] args) {

        ApplicationContext ctg = SpringApplication.run(DiDemoApplication.class, args);

        MyController controller = (MyController) ctg.getBean("myController");

        FakeDataSource fakeDataSource = (FakeDataSource) ctg.getBean(FakeDataSource.class);

        System.out.println(fakeDataSource.getUser() + " " + fakeDataSource.getPassword()
        + " " + fakeDataSource.getUrl());
    }

}
