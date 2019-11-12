package com.FirstApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private EditText edtEmail,edtPassword;
    private Button btnLogin,btnExit;

    private String userEmail,userpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initView();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateData())
                {
                    Toast.makeText(Main2Activity.this,"Validated "+userEmail+"\n"+userpassword,Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean validateData() {
        userEmail= edtEmail.getText().toString().trim();
        userpassword = edtPassword.getText().toString().trim();
        if(userEmail.isEmpty())
        {
            edtEmail.setError("Enter email");
            Toast.makeText(Main2Activity.this,"Please enter email",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!isValidEmail(userEmail))
        {
            Toast.makeText(Main2Activity.this,"Please enter valid Email",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(userpassword.isEmpty())
        {
            Toast.makeText(Main2Activity.this,"Please enter password",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void initView() {
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        btnExit = findViewById(R.id.btn_exit);
    }

    public boolean isValidEmail(CharSequence target)
    {
        //return Patterns.EMAIL_ADDRESS.matcher(target).matches();
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}
