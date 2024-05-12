package com.example.msreservationcommand;

import com.example.coreapi.AxonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({AxonConfig.class})
public class MsReservationCommandApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsReservationCommandApplication.class, args);
    }

}
