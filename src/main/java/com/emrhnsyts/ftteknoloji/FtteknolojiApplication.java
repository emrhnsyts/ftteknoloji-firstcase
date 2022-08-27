package com.emrhnsyts.ftteknoloji;

import com.emrhnsyts.ftteknoloji.repository.UrunYorumRepository;
import com.emrhnsyts.ftteknoloji.service.UrunYorumService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@RequiredArgsConstructor
public class FtteknolojiApplication {


    public static void main(String[] args) {
        SpringApplication.run(FtteknolojiApplication.class, args);
    }


}
