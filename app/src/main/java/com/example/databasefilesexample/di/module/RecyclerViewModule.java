package com.example.databasefilesexample.di.module;

import com.example.databasefilesexample.network.EmployeeRepository;
import com.example.databasefilesexample.viewmodel.MyViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class RecyclerViewModule {

    @Provides static MyViewModelFactory providesMyViewModelFactory(EmployeeRepository repository) {
        return new MyViewModelFactory(repository);
    }
}
