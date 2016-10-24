package com.ritterdouglas.imovirtual.view_model;

import com.ritterdouglas.imovirtual.networking.RegisterDeviceManager;
import com.ritterdouglas.imovirtual.networking.SearchManager;
import com.ritterdouglas.imovirtual.networking.register_device.RegisterDeviceResponse;
import com.ritterdouglas.imovirtual.networking.search.SearchResponse;

import retrofit2.Response;
import rx.subjects.AsyncSubject;

public class MainActivityViewModel {

    private AsyncSubject<Response<RegisterDeviceResponse>> registerDeviceSubject;
    private RegisterDeviceManager registerDeviceManager;

    private AsyncSubject<Response<SearchResponse>> searchSubject;
    private SearchManager searchManager;

    public MainActivityViewModel(RegisterDeviceManager registerDeviceManager, SearchManager searchManager) {
        this.registerDeviceManager = registerDeviceManager;
        createRegisterDeviceSubject();

        this.searchManager = searchManager;
        createSearchSubject();

    }

    public void registerDevice() {
        registerDeviceManager.registerDevice()
                .subscribe(registerDeviceSubject);
    }

    public AsyncSubject<Response<RegisterDeviceResponse>> getRegisterDeviceSubject() {
        return this.registerDeviceSubject;
    }

    public AsyncSubject<Response<RegisterDeviceResponse>> createRegisterDeviceSubject() {
        this.registerDeviceSubject = AsyncSubject.create();
        return this.registerDeviceSubject;
    }

    public void search(String location, String searchPage,
                       String type, String cat, String sizeTo,
                       String priceFrom, String priceTo,
                       String width, String height,
                       String lang, String c) {

        this.searchManager.search(location, searchPage, type, cat, sizeTo,
                priceFrom, priceTo, width, height, lang, c)
                .subscribe(searchSubject);
    }

    public AsyncSubject<Response<SearchResponse>> getSearchSubject() {
        return this.searchSubject;
    }

    public AsyncSubject<Response<SearchResponse>> createSearchSubject() {
        this.searchSubject = AsyncSubject.create();
        return this.searchSubject;
    }



}
