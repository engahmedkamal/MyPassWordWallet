package com.isfp.ahmed.mypasswordwallet.core;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.isfp.ahmed.mypasswordwallet.R;
import com.isfp.ahmed.mypasswordwallet.database.UsersContract;
import com.isfp.ahmed.mypasswordwallet.database.UsersDBhelper;
import com.isfp.ahmed.mypasswordwallet.model.User;

public class Login extends AppCompatActivity {
    private UsersDBhelper dBhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dBhelper=new UsersDBhelper(this);
        Button login=(Button)findViewById(R.id.login);
        EditText username=(EditText)findViewById(R.id.username);
        EditText password=(EditText)findViewById(R.id.password);
        login.setOnClickListener(v->{
          Cursor res= dBhelper.getUser(username.getText().toString());
            if(res!=null&&res.getCount()>0){
                res.moveToFirst();
                User user=new User();
                user.setUsername(res.getString(res.getColumnIndex(UsersContract.USERS_TABLE.COLUMN_USERNAME)));
                user.setPassWord(res.getString(res.getColumnIndex(UsersContract.USERS_TABLE.COLUMN_PASSWORD)));
                user.setFirstname(res.getString(res.getColumnIndex(UsersContract.USERS_TABLE.COLUMN_FIRSTNAME)));
                user.setLastname(res.getString(res.getColumnIndex(UsersContract.USERS_TABLE.COLUMN_LASTNAME)));
                user.setId(res.getInt(res.getColumnIndex(UsersContract.USERS_TABLE._ID)));
                if(user.getPassWord().equals(password.getText().toString())){
                    Toast.makeText(this,"welcome",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this,"this password is Wrong",Toast.LENGTH_LONG).show();
                }
            }
            else {
                Toast.makeText(this,"Wrong Username",Toast.LENGTH_LONG).show();
            }
            if (!res.isClosed())  {
                res.close();
            }
        });
    }

}
