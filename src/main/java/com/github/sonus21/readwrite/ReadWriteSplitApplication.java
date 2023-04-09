package com.github.sonus21.readwrite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.github.sonus21.readwrite"
})
public class ReadWriteSplitApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadWriteSplitApplication.class, args);
    }

}
