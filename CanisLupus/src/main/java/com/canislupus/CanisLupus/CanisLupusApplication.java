package com.canislupus.CanisLupus;
import java.util.Properties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class CanisLupusApplication {
    public static void main(String[] args) {
		
		//SpringApplication.run(CanisLupusApplication.class, args);
		Properties props = new Properties();
    // This property is used to allow the circular dependencies between the beans/classes.
    props.put("spring.main.allow-circular-references", "true");

    new SpringApplicationBuilder(CanisLupusApplication.class).properties(props).build().run(args);
	System.out.println("========================================================================\n========================EJECUTANDOSE CANNISLUPUS========================\n========================================================================");
	}
}