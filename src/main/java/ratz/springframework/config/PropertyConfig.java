package ratz.springframework.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import ratz.springframework.examplebeans.FakeDataSource;
import ratz.springframework.examplebeans.FakeJmsBroker;

//we can use both PropertySource/s


@Configuration

//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
/*@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")

})   WE STOPED USING THIS; REFACTOR TO APPLICATION.PROPERTIES*/


public class PropertyConfig {

    /*@Autowired
    Environment env;    WAS JUST FOR EXAMPLE*/

    @Value("${ratz.username}")
    String user;

    @Value("${ratz.password}")
    String password;

    @Value("${ratz.dburl}")
    String url;

    @Value("${ratz.jms.username}")
    String jsmUsername;

    @Value("${ratz.jms.password}")
    String jsmPassword;

    @Value("${ratz.jms.url}")
    String jsmUrl;

    @Bean
    public FakeDataSource fakeDataSource(){

        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUser(user);
        fakeDataSource.setPassword(password);
        fakeDataSource.setUrl(url);

        return fakeDataSource;
    }
    @Bean
    public FakeJmsBroker fakeJmsBroker(){

        FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
        fakeJmsBroker.setPassword(jsmPassword);
        fakeJmsBroker.setUrl(jsmUrl);
        fakeJmsBroker.setUser(jsmUsername);

        return fakeJmsBroker;
    }


    //o que vai ler o file por nós
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){

        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();

        return propertySourcesPlaceholderConfigurer;
    }

}
