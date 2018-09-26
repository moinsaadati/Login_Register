package com.example.seyedmoeinsaadati.samplelogin_register.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.seyedmoeinsaadati.samplelogin_register.Fragments.LoginFragment;
import com.example.seyedmoeinsaadati.samplelogin_register.R;
import com.example.seyedmoeinsaadati.samplelogin_register.Views.LoginView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideStatusBar();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new LoginFragment()).commit();
    }

    private void hideStatusBar() {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        getSupportActionBar().hide();
    }
}