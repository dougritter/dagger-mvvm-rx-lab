package com.ritterdouglas.imovirtual.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ritterdouglas.imovirtual.R;
import com.ritterdouglas.imovirtual.application.CustomApplication;
import com.ritterdouglas.imovirtual.networking.RegisterDeviceManager;
import com.ritterdouglas.imovirtual.networking.SearchManager;
import com.ritterdouglas.imovirtual.networking.register_device.RegisterDeviceResponse;
import com.ritterdouglas.imovirtual.networking.search.SearchResponse;
import com.ritterdouglas.imovirtual.view_model.MainActivityViewModel;

import javax.inject.Inject;

import retrofit2.Response;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends BaseActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    private MainActivityViewModel mViewModel;

    @Inject RegisterDeviceManager mRegisterDeviceManager;
    @Inject SearchManager mSearchManager;

    private Subscription mRegisterDeviceSubscription;
    private Subscription mSearchSubscription;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((CustomApplication) getApplication()).getNetComponent().inject(this);

        mViewModel = new MainActivityViewModel(mRegisterDeviceManager, mSearchManager);
        mViewModel.registerDevice();

        makeSearchTest();

    }

    public void makeSearchTest() {

        String location = "Lisboa/Lisboa/Alcântara";
        String search_page = "1";
        String type = "2";
        String cat = "13";
        String size_to = "2";
        String price_from = "300";
        String price_to = "700";
        String width = "1080";
        String height = "1776";
        String lang = "en";
        String c = "";

        mViewModel.search(location, search_page, type, cat, size_to, price_from, price_to, width, height, lang, c);

    }

    @Override protected void subscribeForNetworkRequests() {
        mRegisterDeviceSubscription = mViewModel.getRegisterDeviceSubject()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RegisterDeviceSubscriber());

        mSearchSubscription = mViewModel.getSearchSubject()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SearchSubscriber());

    }

    @Override protected void unsubscribeFromNetworkRequests() {
        if (mRegisterDeviceSubscription != null) {
            mRegisterDeviceSubscription.unsubscribe();
            mSearchSubscription.unsubscribe();
        }
    }

    @Override protected void reconnectWithNetworkRequests() {
        mRegisterDeviceSubscription = mViewModel.createRegisterDeviceSubject()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RegisterDeviceSubscriber());

        mSearchSubscription = mViewModel.createSearchSubject()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SearchSubscriber());
    }

    private class RegisterDeviceSubscriber extends Subscriber<Response<RegisterDeviceResponse>> {
        @Override public void onCompleted() {
            // hide progress
//            Log.e(FragmentActivity.TAG, "onCompleted - show next activity");
            Toast.makeText(getApplicationContext(), "onCompleted", Toast.LENGTH_SHORT).show();
//            openHomeActivity();
        }

        @Override public void onError(Throwable e) {
            // hide progress
            reconnectWithNetworkRequests();
            // test if errors are instanceof exceptions of our API
        }

        @Override public void onNext(Response<RegisterDeviceResponse> searchResponse) {
            Log.e(TAG, "onNext");

        }

    }

    private class SearchSubscriber extends Subscriber<Response<SearchResponse>> {
        @Override public void onCompleted() {
            // hide progress
//            Log.e(FragmentActivity.TAG, "onCompleted - show next activity");
            Toast.makeText(getApplicationContext(), "onCompleted", Toast.LENGTH_SHORT).show();
//            openHomeActivity();
        }

        @Override public void onError(Throwable e) {
            // hide progress
            reconnectWithNetworkRequests();
            // test if errors are instanceof exceptions of our API
        }

        @Override public void onNext(Response<SearchResponse> searchResponse) {
            Log.e(TAG, "onNext");

        }

    }


}
