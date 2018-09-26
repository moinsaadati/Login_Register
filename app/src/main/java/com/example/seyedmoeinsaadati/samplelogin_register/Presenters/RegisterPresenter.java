package com.example.seyedmoeinsaadati.samplelogin_register.Presenters;

import android.support.annotation.NonNull;

import com.example.seyedmoeinsaadati.samplelogin_register.Interactors.RegisterInteractor;
import com.example.seyedmoeinsaadati.samplelogin_register.Views.RegisterView;

public class RegisterPresenter implements RegisterInteractor.OnSignUpFinisherListener {

    RegisterView registerView;
    RegisterInteractor registerInteractor;

    public RegisterPresenter(RegisterView registerView, RegisterInteractor registerInteractor) {
        this.registerView = registerView;
        this.registerInteractor = registerInteractor;
    }

    public void ValidFields(String email, String username, String password) {
        registerInteractor.SignUp(email, username, password, this);
    }


    @Override

    public void OnEmailError() {
        if (registerView != null)
            registerView.SetEmailError();

    }

    @Override
    public void OnUsernameError() {
        if (registerView != null)
            registerView.SetUsernameError();
    }

    @Override
    public void OnPasswordError() {
        if (registerView != null)
            registerView.SetPasswordError();
    }

    @Override
    public void OnSignUpSuccess() {
        if (registerView != null)
            registerView.NavigateToHome();
    }

    @Override
    public void OnSignUpFailure() {
        // ...
    }

    @Override
    public void OnNavigateToLogin() {
        if (registerView != null)
            registerView.NavigateToLogin();
    }

    public void OnDestroy() {
        registerView = null;
    }
}
