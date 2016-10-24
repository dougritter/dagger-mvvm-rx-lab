package com.ritterdouglas.imovirtual.networking;

import android.content.Context;
import android.util.Log;

import com.ritterdouglas.imovirtual.networking.register_device.RegisterDeviceResponse;

import java.io.IOException;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RegisterDeviceAPIService {
    public static final String TAG = RegisterDeviceAPIService.class.getSimpleName();
    private RegisterDeviceAPI registerDeviceAPI;
    private boolean isSearching;
    private Context context;

    public RegisterDeviceAPIService(Retrofit retrofit, Context context) {
        this.registerDeviceAPI = retrofit.create(RegisterDeviceAPI.class);
        this.context = context;
    }

    public RegisterDeviceAPI getRegisterDeviceAPI() {
        return registerDeviceAPI;
    }

    public void setRegisterDeviceAPI(RegisterDeviceAPI registerDeviceAPI) {
        this.registerDeviceAPI = registerDeviceAPI;
    }

    public boolean isSearching() {
        return isSearching;
    }

    public void setSearching(boolean searching) {
        isSearching = searching;
    }

    public Observable<Response<RegisterDeviceResponse>> registerDevice() {
        return registerDeviceAPI.registerDevice()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(() -> isSearching = true)
                .doOnTerminate(() -> isSearching = false)
                .doOnError(this::onError)
                .doOnNext(registerResponse -> processSearchResponse(registerResponse));
    }

    public void onError(Throwable throwable) {
        Log.e(TAG, "onError");
        if (throwable instanceof HttpException) {
            // We had non-2XX http error
            Log.e(TAG, "HTTPException: "+((HttpException)throwable).code());
        }
        if (throwable instanceof IOException) {
            // A network or conversion error happened
            Log.e(TAG, "IOException: "+ throwable.getMessage());
        }
    }


    private void processSearchResponse(Response<RegisterDeviceResponse> searchResponse) {
        if (searchResponse.body() != null && searchResponse.body() != null) {

        }

        Log.d(TAG, "processSearchResponse");
        Log.d(TAG, "response code: " + searchResponse.code());


    }

}
