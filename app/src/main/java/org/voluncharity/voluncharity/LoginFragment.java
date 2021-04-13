package org.voluncharity.voluncharity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment# newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {
    View view;
    Button login;
    EditText emailEdit, passEdit;
    private FirebaseAuth mAuth;
    FirebaseUser currentUser;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            navigateHomePage();
        }
    }


    private void login(String mail, final String password) {
        mAuth.signInWithEmailAndPassword(mail, password).addOnCompleteListener((Activity) getContext(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Log.v("DEBUGVOLUN", "login success");
                } else {
                    Log.v("DEBUGVOLUN", "login error");
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login, container, false);
        login = view.findViewById(R.id.btn_login);
        emailEdit = view.findViewById(R.id.et_email);
        passEdit = view.findViewById(R.id.et_password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(emailEdit.getText().toString(), passEdit.getText().toString());
                android.os.SystemClock.sleep(1000);
                currentUser = mAuth.getCurrentUser();
                if(currentUser != null){
                    navigateHomePage();
                }
            }
        });

        return view;
    }

    public void navigateHomePage(){
        Intent intent = new Intent(getActivity(), HomePageActivity.class);
        startActivity(intent);
    }

}