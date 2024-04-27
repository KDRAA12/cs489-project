package edu.miu.eprescribtionsystem;

import edu.miu.eprescribtionsystem.helpers.DataGenerator;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@AllArgsConstructor
public class EPrescribtionSystrmApplication {
    private final DataGenerator dataGenerator;

    public static void main(String[] args) {
        SpringApplication.run(EPrescribtionSystrmApplication.class, args);
    }


//    @Bean
//    public CommandLineRunner init(){
//        return args -> dataGenerator.initializeDatabase();
//    }

}
