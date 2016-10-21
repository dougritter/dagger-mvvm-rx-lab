package com.ritterdouglas.imovirtual.di;

import com.ritterdouglas.imovirtual.view.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

    void inject(MainActivity mainActivity);


}
