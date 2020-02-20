package com.example.databasefilesexample.network;

import com.example.databasefilesexample.model.Employee;

import java.util.List;

import io.reactivex.Observable;

public interface EmployeeRepository {

    Observable<List<Employee>> getEmployees();
}
