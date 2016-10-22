package com.ritterdouglas.imovirtual.di;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ritterdouglas.imovirtual.networking.SearchManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

    public static final String USER_AGENT = "User-Agent";
    public static final String USER_AGENT_VALUE = "Imovirtual/1.23.1 (motorola/XT1097; Android/6.0) android-agent";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String APPLICATION_JSON = "application/json";
    Application mApplication;
    String mBaseUrl;

    public NetModule(Application application, String baseUrl) {
        mApplication = application;
        mBaseUrl = baseUrl;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().create();

    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        builder.addInterceptor(chain -> {
            Request request = chain.request().newBuilder()
                    .addHeader(USER_AGENT, USER_AGENT_VALUE)
                    .addHeader(CONTENT_TYPE, APPLICATION_JSON).build();
            return chain.proceed(request);
        });

        return builder.addInterceptor(interceptor).build();

    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build();

    }

    @Provides
    @Singleton
    SearchManager provideSearchManager(Context context, Retrofit retrofit) {
        return SearchManager.getInstance(context, retrofit);

    }

}
