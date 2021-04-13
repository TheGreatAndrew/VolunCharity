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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment# newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {
    View view;
    Button register;
    EditText emailEdit, passEdit, rePassEdit;
    private FirebaseAuth mAuth;
    FirebaseUser currentUser;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();

    }

    private void signup(String mail, final String password) {
        mAuth.createUserWithEmailAndPassword(mail, password).addOnCompleteListener((Activity) getContext(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Log.v("DEBUGVOLUN", "signup success");
                } else {
                    Log.v("DEBUGVOLUN", "signup error");
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_register, container, false);
        register = view.findViewById(R.id.btn_register);
        emailEdit = view.findViewById(R.id.et_email_register);
        passEdit = view.findViewById(R.id.et_password_register);
        rePassEdit = view.findViewById(R.id.et_repassword_register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(passEdit.getText().toString().equals(rePassEdit.getText().toString())){
                    signup(emailEdit.getText().toString(), passEdit.getText().toString());
                    android.os.SystemClock.sleep(1000);
                    currentUser = mAuth.getCurrentUser();
                    if(currentUser != null){
                        navigateHomePage();
                    }
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