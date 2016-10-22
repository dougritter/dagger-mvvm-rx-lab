package com.ritterdouglas.imovirtual.view_model;

import com.ritterdouglas.imovirtual.networking.SearchManager;
import com.ritterdouglas.imovirtual.networking.register_device.RegisterDeviceResponse;

import retrofit2.Response;
import rx.subjects.AsyncSubject;

public class MainActivityViewModel {

    private AsyncSubject<Response<RegisterDeviceResponse>> registerDeviceSubject;
    private SearchManager searchManager;

    public MainActivityViewModel(SearchManager searchManager) {
        this.searchManager = searchManager;
        registerDeviceSubject = AsyncSubject.create();
    }

    public void registerDevice() {
        searchManager.registerDevice()
                .subscribe(registerDeviceSubject);

    }

    public AsyncSubject<Response<RegisterDeviceResponse>> getRegisterDeviceSubject() {
        return this.registerDeviceSubject;
    }

    public AsyncSubject<Response<RegisterDeviceResponse>> createRegisterDeviceSubject() {
        this.registerDeviceSubject = AsyncSubject.create();
        return this.registerDeviceSubject;
    }

}
