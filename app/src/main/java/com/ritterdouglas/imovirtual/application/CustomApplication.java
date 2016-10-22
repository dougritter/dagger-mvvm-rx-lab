package com.ritterdouglas.imovirtual.application;

import android.app.Application;

import com.ritterdouglas.imovirtual.di.AppModule;
import com.ritterdouglas.imovirtual.di.DaggerNetComponent;
import com.ritterdouglas.imovirtual.di.NetComponent;
import com.ritterdouglas.imovirtual.di.NetModule;
import com.ritterdouglas.imovirtual.networking.NetworkingConstants;

import io.realm.Realm;

public class CustomApplication extends Application {

    private NetComponent mNetComponent;

    @Override public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(this, NetworkingConstants.BASE_URL))
                .build();

        Realm.init(this);

    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
