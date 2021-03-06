package com.example.databasefilesexample.api;

import com.google.gson.JsonElement;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface EmployeeApi {

    @GET("/api/v1/employees")
    Observable<JsonElement> getEmployees();
}
