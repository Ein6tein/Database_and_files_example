package com.example.databasefilesexample.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.databasefilesexample.network.EmployeeRepository;

public class MyViewModelFactory implements ViewModelProvider.Factory {

    private final EmployeeRepository mRepository;

    public MyViewModelFactory(EmployeeRepository repository) {
        mRepository = repository;
    }

    @NonNull @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MyViewModel.class)) {
            return (T) new MyViewModel(mRepository);
        }
        throw new IllegalArgumentException("Unknown class name");
    }
}
