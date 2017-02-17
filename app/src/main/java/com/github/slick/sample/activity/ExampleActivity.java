package com.github.slick.sample.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.github.slick.Presenter;
import com.github.slick.sample.R;
import com.github.slick.sample.Slick;

public class ExampleActivity extends AppCompatActivity implements ExampleActivityView {

    @Presenter
    ExampleActivityPresenter presenter;
    private static final String TAG = ExampleActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Slick.bind(this, R.id.textView3, "foo");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        Log.e(TAG, presenter.toString());
    }
}