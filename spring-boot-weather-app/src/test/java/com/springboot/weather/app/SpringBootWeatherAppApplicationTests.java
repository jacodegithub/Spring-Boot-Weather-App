package com.springboot.weather.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.springboot.weather.app.dto.WeatherResponse;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@SpringBootTest
class SpringBootWeatherAppApplicationTests {

	@Test
	void contextLoads() {
		String APIurl = "https://api.openweathermap.org/data/2.5/weather?q=";
        String url = APIurl+"koppal"+"&units="+"metric"+"&appid="+"3b7a61b69fcba80c3efdeb434adb36d6";

        // logger.info("url : {}", url);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try(Response response = client.newCall(request).execute()) {
            String jsonResponse = response.body().string();
            Gson gson = new Gson();
            WeatherResponse wResponse = gson.fromJson(jsonResponse, WeatherResponse.class);
            // logger.info("converted file : {}", wResponse);
            // logger.info("jsonResponse: {}", jsonResponse);
            System.out.println("response ->"+wResponse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

}
