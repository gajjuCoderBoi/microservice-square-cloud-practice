package com.example.squareservice.client;

import org.springframework.cloud.square.retrofit.core.RetrofitClient;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

@RetrofitClient(
        "service-1"
)
public interface Service1Client {

    @GET("/greetings/{square-service}")
    Call<String> greet(@Path("square-service") String message);

}
