package com.example.seyedmoeinsaadati.samplelogin_register.Presenters;

import com.example.seyedmoeinsaadati.samplelogin_register.Interactors.LoginInteractor;
import com.example.seyedmoeinsaadati.samplelogin_register.Views.LoginView;

public class LoginPresenter implements LoginInteractor.OnLoginFinisherListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenter(LoginView loginView, LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    public void ValidFields(String username, String password) {

        loginInteractor.Login(username, password, this);
    }

    @Override
    public void OnEmailNameError() {
        if (loginView != null)
            loginView.SetEmailError();
    }

    @Override
    public void OnPasswordError() {
        if (loginView != null)
            loginView.SetPasswordError();
    }

    @Override
    public void OnLoginSuccess() {
        if (loginView != null)
            loginView.NavigateToHome();
    }

    @Override
    public void OnLoginFailure() {
        //...
    }

    @Override
    public void OnNavigateToSignUp() {
        if (loginView != null) {
            loginView.NavigateToSignUp();
        }
    }

    @Override
    public void OnLoginWithGoogle() {
        if (loginView != null) {
            loginView.LoginWithGoogle();
        }
    }

    @Override
    public void OnLoginWithFaceBook() {
        if (loginView != null) {
            loginView.LoginWithFacebook();
        }
    }

    @Override
    public void OnForgetPassword() {
        if (loginView != null) {
            loginView.ForgetPassword();
        }
    }

    public void OnDestroy() {
        loginView = null;
    }
}
