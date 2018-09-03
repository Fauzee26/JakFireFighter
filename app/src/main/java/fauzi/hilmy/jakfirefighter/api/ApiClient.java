package fauzi.hilmy.jakfirefighter.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL = "http://api.jakarta.go.id/";
    private static final String auth = "Authorization";
    private static final String value = "5h30dB4K4Uwuhj4KkmHmFhyeCAZ51i6PqHyQmjKfflQREW/JzPaPlYM22trruzC5";

    private static OkHttpClient client() {
        return new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request()
                        .newBuilder()
                        .addHeader(auth, value)
                        .build();
                return chain.proceed(request);
            }
        }).build();
    }

    private static Retrofit setInit() {
        return new Retrofit.Builder()
                .client(client())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiInterface getInstance() {
        return setInit().create(ApiInterface.class);
    }

}
