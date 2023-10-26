import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
 
    @Bean(name="helloworld")
    //@Scope("singleton")
    public HelloWorld getHelloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setMessage("Hello World!");
        return helloWorld;
    }
    @Bean
    @Scope("prototype")
    public Cat catBean(){
        return new Cat();
    }
}

/* Метод getHelloWorld() - создает и инициализирует объект HelloWorld внутри метода, который используется при каждом
                           запросе к бину с именем "helloworld". Область видимости "singleton" означает, что Spring
                           создает и инициализирует бин только один раз при старте контейнера, и затем этот один и тот
                           же бин используется при каждом запросе.

Метод catBean() - также создает объект Cat, но с областью видимости "prototype", что приводит к созданию нового объекта
                  при каждом запросе к бину с именем "catBean", без дополнительной инициализации. */