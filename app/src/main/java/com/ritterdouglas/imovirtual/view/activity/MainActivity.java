package com.ritterdouglas.imovirtual.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ritterdouglas.imovirtual.R;
import com.ritterdouglas.imovirtual.application.CustomApplication;
import com.ritterdouglas.imovirtual.networking.SearchManager;
import com.ritterdouglas.imovirtual.networking.register_device.RegisterDeviceResponse;
import com.ritterdouglas.imovirtual.view_model.MainActivityViewModel;

import javax.inject.Inject;

import retrofit2.Response;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends BaseActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    private MainActivityViewModel mViewModel;
    private Subscription mRegisterDeviceSubscription;
    @Inject SearchManager mSearchManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((CustomApplication) getApplication()).getNetComponent().inject(this);

        mViewModel = new MainActivityViewModel(mSearchManager);
        mViewModel.registerDevice();

    }

    @Override protected void subscribeForNetworkRequests() {
        mRegisterDeviceSubscription = mViewModel.getRegisterDeviceSubject()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MainActivity.SearchSubscriber());
    }

    @Override protected void unsubscribeFromNetworkRequests() {
        if (mRegisterDeviceSubscription != null) {
            mRegisterDeviceSubscription.unsubscribe();
        }
    }

    @Override protected void reconnectWithNetworkRequests() {
        mRegisterDeviceSubscription = mViewModel.createRegisterDeviceSubject()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MainActivity.SearchSubscriber());
    }

    private class SearchSubscriber extends Subscriber<Response<RegisterDeviceResponse>> {
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
//            adsList = searchResponse.body().getAds();
//            addMarkersOnTheMap(searchResponse.body().getAds());

            /*SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager(), searchResponse.body());
            mBinding.viewPager.setAdapter(adapter);*/
//            mBinding.tabLayout.setupWithViewPager(mBinding.viewPager);

        }

    }

}
