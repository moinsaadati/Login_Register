package com.example.seyedmoeinsaadati.samplelogin_register.Interactors;

public class LoginInteractor {

    public interface OnLoginFinisherListener {

        void OnEmailNameError();

        void OnPasswordError();

        void OnLoginSuccess();

        void OnLoginFailure();

        void OnNavigateToSignUp();

        void OnLoginWithGoogle();

        void OnLoginWithFaceBook();

        void OnForgetPassword();
    }

    public void Login(String Email, String Password, OnLoginFinisherListener listener) {
        if (Email.isEmpty()) {
            listener.OnEmailNameError();
            listener.OnLoginFailure();
        } else if (Password.isEmpty()) {
            listener.OnPasswordError();
            listener.OnLoginFailure();
        } else {
            // Login Proccess is Started and Response then
            listener.OnLoginSuccess();// or listener.OnLoginFailure();
        }
    }


}
