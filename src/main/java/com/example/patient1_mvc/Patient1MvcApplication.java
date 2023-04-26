package com.example.patient1_mvc;

import com.example.patient1_mvc.entities.Patient;
import com.example.patient1_mvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Patient1MvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(Patient1MvcApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"mohammed",new Date(),false,20));
            patientRepository.save(new Patient(null,"ahmed",new Date(),false,2044));
            patientRepository.save(new Patient(null,"nizar",new Date(),true,22));
            patientRepository.save(new Patient(null,"abdu",new Date(),false,250));

            List<Patient> p = patientRepository.findAll();
            for(Patient k : p) System.out.println(k);

        };
    }


}
