package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jackson.autoconfigure.JacksonAutoConfiguration;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.type.AnnotatedTypeMetadata;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}


class LinuxConditional implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		return System.getProperty("os.name").toLowerCase().contains("linux");
	}
}

@Configuration
class AppConfig {
	@Bean
	@Conditional(LinuxConditional.class)
	public String linuxBean() {
		return "This bean is only created on Linux";
	}
}



@AutoConfiguration
@AutoConfigureAfter(JacksonAutoConfiguration.class)
class custom001 {

}

@AutoConfiguration
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
class custom002 {

}


@AutoConfiguration
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
class custom003 {

}

@AutoConfigureOrder(50)
class custom004 {

}



