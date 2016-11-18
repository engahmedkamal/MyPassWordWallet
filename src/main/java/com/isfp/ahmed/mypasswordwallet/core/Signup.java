package com.isfp.ahmed.mypasswordwallet.core;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.isfp.ahmed.mypasswordwallet.R;
import com.isfp.ahmed.mypasswordwallet.database.UsersDBhelper;
import com.isfp.ahmed.mypasswordwallet.model.User;

public class Signup extends AppCompatActivity {
    private UsersDBhelper dBhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dBhelper=new UsersDBhelper(this);
        Button signup=(Button)findViewById(R.id.regist);
        EditText firstname=(EditText)findViewById(R.id.firstname);
        EditText password=(EditText)findViewById(R.id.newpassword);
        EditText repeatpassword=(EditText)findViewById(R.id.repeatnewpassword);
        EditText lastname=(EditText)findViewById(R.id.lastname);
        EditText username=(EditText)findViewById(R.id.newusername);
        signup.setOnClickListener(v->{
            if (!password.getText().toString().equals(repeatpassword.getText().toString())){
                Toast.makeText(this,"this password isnot the same",Toast.LENGTH_LONG).show();
            }else {
                User user=new User();
                user.setFirstname(firstname.getText().toString());
                user.setLastname(lastname.getText().toString());
                user.setPassWord(password.getText().toString());
                user.setUsername(username.getText().toString());
                dBhelper.insertUser(user);
                Toast.makeText(this,"registration done no of users:"+dBhelper.numberOfRows(),Toast.LENGTH_LONG).show();
            }
        });
    }



}
