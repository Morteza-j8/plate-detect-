package ir.jalambadani.openalpr.alpr;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

//import okhttp3.logging.HttpLoggingInterceptor;

/**
 * created by: Morteza
 * company: Mobin Tabaran
 * project name:  Plate Detect
 * 03 Feb 2019
 **/

public class AlprRetrofitFactory {
    private static final AlprRetrofitFactory INSTANCE = new AlprRetrofitFactory();
    private Retrofit retrofit;

    private AlprRetrofitFactory(){

    }

    public static AlprRetrofitFactory getInstance() {
        return INSTANCE;
    }

    public AlprEndPoint getAlprEndPoint(){
        if (retrofit == null) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
            OkHttpClient client = new OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .build();;
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.openalpr.com/v2/")
                    .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                    .client(client)
                    .build();
        }

        return retrofit.create(AlprEndPoint.class);
    }
}
