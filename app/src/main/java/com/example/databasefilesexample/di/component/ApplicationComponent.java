package com.example.databasefilesexample.di.component;

import android.app.Application;

import com.example.databasefilesexample.application.MyApplication;
import com.example.databasefilesexample.di.builder.ActivityBuilder;
import com.example.databasefilesexample.di.module.NetworkModule;
import com.example.databasefilesexample.di.module.RecyclerViewModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuilder.class,
        RecyclerViewModule.class,
        NetworkModule.class
})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

    void inject(MyApplication application);

    @Component.Builder interface Builder {

        @BindsInstance Builder application(Application application);

        ApplicationComponent build();
    }
}
