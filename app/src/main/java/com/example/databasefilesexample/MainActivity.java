package com.example.databasefilesexample;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databasefilesexample.adapter.EmployeeAdapter;
import com.example.databasefilesexample.viewmodel.MyViewModel;
import com.example.databasefilesexample.viewmodel.MyViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @BindView(R.id.recycler_view) RecyclerView mRecyclerView;

    @Inject MyViewModelFactory mViewModelFactory;

    private EmployeeAdapter mAdapter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        AndroidInjection.inject(this);
    }

    @Override protected void onStart() {
        super.onStart();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter = new EmployeeAdapter(this));

        MyViewModel viewModel = new ViewModelProvider(this, mViewModelFactory)
                .get(MyViewModel.class);

        viewModel.employees().observe(this, mAdapter::setEmployees);

        viewModel.getEmployees();
    }
}
