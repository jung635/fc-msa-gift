package dev.practice.gift.infrastructure.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.practice.gift.common.response.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class RetrofitUtils {
    private static final HttpLoggingInterceptor HTTP_LOGGING_INTERCEPTOR
            = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    private static final OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .addInterceptor(HTTP_LOGGING_INTERCEPTOR)
            .connectTimeout(3, TimeUnit.SECONDS)
            .readTimeout(3, TimeUnit.SECONDS);

    private static final Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    public static Retrofit initRetrofit(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public <T extends CommonResponse> Optional<T> responseSync(Call<T> call) {
        try {
            Response<T> response = call.execute();

            if(response.isSuccessful()) {
                return Optional.ofNullable(response.body());
            } else {
                log.error("requestSync errorBody = {}", response.errorBody());
                throw new RuntimeException("retrofit execute response error");
            }
        } catch (IOException e) {
            throw new RuntimeException("retrofit execute IOException");
        }
    }

    public void responseVoid(Call<Void> call) {
        try {
            if(!call.execute().isSuccessful()) throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
