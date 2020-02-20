package com.example.databasefilesexample.di.module;

import com.example.databasefilesexample.network.EmployeeRepository;
import com.example.databasefilesexample.network.EmployeeRepositoryImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Provides public EmployeeRepository providesEmployeeRepository() {
        return new EmployeeRepositoryImpl();
    }
}
