package com.example.squareservice;

import com.example.squareservice.client.Service1Client;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.square.retrofit.EnableRetrofitClients;
import org.springframework.context.annotation.Bean;
import retrofit2.Call;

@SpringBootApplication
@EnableDiscoveryClient
public class SquareServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SquareServiceApplication.class, args);
    }

    @Bean
    ApplicationRunner runner(Service1Client sc){
        return event -> {
            for (int i = 0; i < 3; i++) {

                Call<String> call = sc.greet("Square Service");
                String response = call.execute().body();
                System.out.println(response);
            }
        };
    }
}
