package com.example.databasefilesexample.network;

import android.text.TextUtils;

import com.example.databasefilesexample.api.EmployeeApi;
import com.example.databasefilesexample.model.Employee;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class EmployeeRepositoryImpl extends BaseRepository<EmployeeApi> implements EmployeeRepository {

    @Override public Observable<List<Employee>> getEmployees() {
        return createApi(EmployeeApi.class)
                .getEmployees()
                .map(json -> {
                    List<Employee> employees = new ArrayList<>();

                    JsonObject jsonObject = json.getAsJsonObject();
                    JsonArray data = jsonObject.get("data").getAsJsonArray();

                    for (int i = 0; i < data.size(); i++) {
                        JsonObject object = data.get(i).getAsJsonObject();
                        Employee employee = new Employee();

                        employee.setId(object.get("id").getAsInt());
                        employee.setName(object.get("employee_name").getAsString());
                        employee.setAge(object.get("employee_age").getAsInt());
                        employee.setSalary(object.get("employee_salary").getAsInt());
                        employee.setPicture(object.get("profile_image").getAsString());
                        if (TextUtils.isEmpty(employee.getPicture())) {
                            employee.setPicture("https://img.freepik.com/free-photo/portrait-white-man-isolated_53876-40306.jpg");
                        }

                        employees.add(employee);
                    }

                    return employees;
                })
                .compose(applySchedulers());
    }
}
