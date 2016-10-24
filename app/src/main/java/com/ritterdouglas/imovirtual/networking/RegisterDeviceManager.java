package com.ritterdouglas.imovirtual.networking;

import android.content.Context;

import com.ritterdouglas.imovirtual.networking.register_device.RegisterDeviceResponse;

import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;

public class RegisterDeviceManager {
    private static RegisterDeviceManager instance;
    private RegisterDeviceAPIService registerDeviceAPIService;

    private RegisterDeviceManager(Context context, Retrofit retrofit) {
        this.registerDeviceAPIService = new RegisterDeviceAPIService(retrofit, context);

    }

    public static RegisterDeviceManager getInstance(Context context, Retrofit retrofit) {
        synchronized (RegisterDeviceManager.class) {
            if (instance == null) {
                instance = new RegisterDeviceManager(context, retrofit);
            }

            return instance;
        }
    }

    public Observable<Response<RegisterDeviceResponse>> registerDevice() {
        return registerDeviceAPIService.registerDevice();
    }

}