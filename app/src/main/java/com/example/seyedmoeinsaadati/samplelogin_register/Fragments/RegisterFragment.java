package com.example.seyedmoeinsaadati.samplelogin_register.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.seyedmoeinsaadati.samplelogin_register.Activities.Home;
import com.example.seyedmoeinsaadati.samplelogin_register.Interactors.RegisterInteractor;
import com.example.seyedmoeinsaadati.samplelogin_register.Presenters.RegisterPresenter;
import com.example.seyedmoeinsaadati.samplelogin_register.R;
import com.example.seyedmoeinsaadati.samplelogin_register.Views.RegisterView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class RegisterFragment extends Fragment implements RegisterView {

    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_sign_up)
    Button btnSignUp;
    @BindView(R.id.btn_go_to_login)
    Button btnGoToLogin;
    Unbinder unbinder;

    RegisterPresenter registerPresenter;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_register, container, false);

        unbinder = ButterKnife.bind(this, rootview);
        registerPresenter = new RegisterPresenter(this, new RegisterInteractor());
        return rootview;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        registerPresenter.OnDestroy();
    }

    @OnClick(R.id.btn_sign_up)
    public void onBtnSignUpClicked() {
        registerPresenter.ValidFields(etEmail.getText().toString(), etUsername.getText().toString(), etPassword.getText().toString());
    }

    @OnClick(R.id.btn_go_to_login)
    public void onBtnGoToLoginClicked() {
        registerPresenter.OnNavigateToLogin();
    }

    @Override
    public void SetUsernameError() {
        etUsername.setError(getString(R.string.error_msg_et_username));

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
        Intent navigateToHome = new Intent(getContext(), Home.class);
        startActivity(navigateToHome);
        getActivity().finish();
    }

    @Override
    public void NavigateToLogin() {
        getFragmentManager().beginTransaction().replace(R.id.container, new LoginFragment()).commit();
    }
}
