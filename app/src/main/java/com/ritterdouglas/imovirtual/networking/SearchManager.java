package com.ritterdouglas.imovirtual.networking;

import android.content.Context;

import com.ritterdouglas.imovirtual.networking.register_device.RegisterDeviceResponse;

import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;

public class SearchManager {
    private static SearchManager instance;
    private SearchAPIService searchAPIService;

    private SearchManager(Context context, Retrofit retrofit) {
        this.searchAPIService = new SearchAPIService(retrofit, context);

    }

    public static SearchManager getInstance(Context context, Retrofit retrofit) {
        synchronized (SearchManager.class) {
            if (instance == null) {
                instance = new SearchManager(context, retrofit);
            }

            return instance;
        }
    }

    public Observable<Response<RegisterDeviceResponse>> registerDevice() {
        return searchAPIService.registerDevice();
    }

}