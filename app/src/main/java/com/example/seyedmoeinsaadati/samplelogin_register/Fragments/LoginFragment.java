package com.example.seyedmoeinsaadati.samplelogin_register.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.seyedmoeinsaadati.samplelogin_register.Activities.Home;
import com.example.seyedmoeinsaadati.samplelogin_register.Interactors.LoginInteractor;
import com.example.seyedmoeinsaadati.samplelogin_register.Presenters.LoginPresenter;
import com.example.seyedmoeinsaadati.samplelogin_register.R;
import com.example.seyedmoeinsaadati.samplelogin_register.Views.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LoginFragment extends Fragment implements LoginView {

    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_forget_pwd)
    Button btnForgetPwd;
    @BindView(R.id.imgbtn_sign_with_google)
    ImageButton imgbtnSignWithGoogle;
    @BindView(R.id.imgbtn_sign_with_facebook)
    ImageButton imgbtnSignWithFacebook;
    @BindView(R.id.btn_go_to_sign_up)
    Button btnGoToSignUp;
    Unbinder unbinder;


    LoginPresenter loginPresenter;

    public LoginFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_login, container, false);

        unbinder = ButterKnife.bind(this, rootview);

        loginPresenter = new LoginPresenter(this, new LoginInteractor());
        return rootview;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        loginPresenter.OnDestroy();
    }

    @OnClick(R.id.btn_login)
    public void onBtnLoginClicked() {
        loginPresenter.ValidFields(etEmail.getText().toString(), etPassword.getText().toString());
    }

    @OnClick(R.id.btn_forget_pwd)
    public void onBtnForgetPwdClicked() {
        loginPresenter.OnForgetPassword();
    }

    @OnClick(R.id.imgbtn_sign_with_google)
    public void onImgbtnSignWithGoogleClicked() {
        loginPresenter.OnLoginWithGoogle();
    }

    @OnClick(R.id.imgbtn_sign_with_facebook)
    public void onImgbtnSignWithFacebookClicked() {
        loginPresenter.OnLoginWithFaceBook();
    }

    @OnClick(R.id.btn_go_to_sign_up)
    public void onBtnGoToSignUpClicked() {
        loginPresenter.OnNavigateToSignUp();
    }

    @Override
    public void SetEmailError() {
        etEmail.setError(getString(R.string.error_msg_et_email));
    }

    @Override
    public void SetPasswordError() {
        etPassword.setError(getString(R.string.error_msg_et_password));
    }

    @Override
    public void NavigateToHome() {
        Intent navigaateToHome = new Intent(getContext(), Home.class);
        startActivity(navigaateToHome);
        getActivity().finish();
    }

    @Override
    public void NavigateToSignUp() {
        getFragmentManager().beginTransaction().replace(R.id.container, new RegisterFragment()).commit();

    }

    @Override
    public void ForgetPassword() {
        // Show Dialog
        Toast.makeText(getContext(), "Forget Password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoginWithGoogle() {
        Toast.makeText(getContext(), "Login With Google", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoginWithFacebook() {
        Toast.makeText(getContext(), "Login With Facebook", Toast.LENGTH_SHORT).show();
    }
}
