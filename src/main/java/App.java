import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        HelloWorld bean =
                (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean.getMessage());
        HelloWorld bean1 =
                applicationContext.getBean("helloworld", HelloWorld.class);

        Cat cat = applicationContext.getBean("catBean", Cat.class);
        cat.setName("Барсик");
        Cat cat1 = applicationContext.getBean("catBean", Cat.class);
        cat1.setName("Тимка");

        System.out.println("Одинаковые ли ссыки cat и cat1? " + (cat==cat1));
        System.out.println("Одинаковые ли объекты bean и bean1? " + (bean.equals(bean1)));
        System.out.println("Имя объекта cat: " + cat.getName());
        System.out.println("Имя объекта cat1: " + cat1.getName());

    }
}


/*
У меня есть три класса:

1. class App
2. class HelloWorld
3. class AppConfig
 которые вкубе мне дают результат "Hello World!".

Правильно ли я понимаю взаимосвязь и работу этих классов?
Итак:
В class App создаётся объект  "applicationContext " типа " ApplicationContext", конструктор которого у себя в параметрах
принимает настройки конфигурационного класса "class AppConfig", который помечен аннотацией "@Configuration", которая
означает, что данный класс является конфигурационным, настраиваемым для работы фреймворка Spring.  В этом классе есть
метод "public HelloWorld getHelloWorld()", который возвращает строку "Hello World!" при следующих условиях:
1. В "class App" получаем объект bean типа HelloWorld, который будет содержать в себе идинтификатор "helloWorld",
   указывающий на ту часть кода с которым будет работать Spring.
2. Указываем в  классе "AppConfig" над методом "public HelloWorld getHelloWorld()" аннотацию " @Bean(name="helloworld")",
   в которой проводим инициализацию бина, который с помощью метода "setMessage("Hello World!")" из класса "Hello World!"
   инициализирует переменную "message" значением "Hello World!"
3. На объекте bean вызываем из класса "HelloWorld" метод getMessage(), который возвращает значение "Hello World!"
   переменной "message" в консоль
*/