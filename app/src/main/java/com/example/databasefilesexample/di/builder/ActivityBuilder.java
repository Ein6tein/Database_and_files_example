package com.example.databasefilesexample.di.builder;

import com.example.databasefilesexample.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector abstract MainActivity bindMainActivity();
}
