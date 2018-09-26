package com.example.seyedmoeinsaadati.samplelogin_register.Interactors;

public class RegisterInteractor {

    public interface OnSignUpFinisherListener {

        void OnEmailError();

        void OnUsernameError();

        void OnPasswordError();

        void OnSignUpSuccess();

        void OnSignUpFailure();

        void OnNavigateToLogin();

    }

    public void SignUp(String email, String username, String password, OnSignUpFinisherListener listener) {

        if (email.isEmpty() || username.isEmpty() || password.isEmpty()) {

            if (email.isEmpty()) listener.OnEmailError();
            if (username.isEmpty()) listener.OnUsernameError();
            if (password.isEmpty()) listener.OnPasswordError();

            listener.OnSignUpFailure();
        } else {
            listener.OnSignUpSuccess();
        }

    }

}
