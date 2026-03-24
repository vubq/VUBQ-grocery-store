package com.vubq.grocerystore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GroceryStoreApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(GroceryStoreApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GroceryStoreApplication.class);
    }
}
