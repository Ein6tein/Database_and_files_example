package com.example.databasefilesexample.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.databasefilesexample.model.Employee;
import com.example.databasefilesexample.network.EmployeeRepository;

import java.util.List;

public class MyViewModel extends ViewModel {

    private EmployeeRepository mRepository;
    private MutableLiveData<List<Employee>> mEmployeesLiveData = new MutableLiveData<>();

    public MyViewModel(EmployeeRepository repository) {
        mRepository = repository;
    }

    public LiveData<List<Employee>> employees() {
        return mEmployeesLiveData;
    }

    public void getEmployees() {
        mRepository.getEmployees().subscribe(employees -> mEmployeesLiveData.postValue(employees));
    }
}
