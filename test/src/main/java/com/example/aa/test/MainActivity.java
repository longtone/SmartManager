package com.example.aa.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    UserData userData;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userData=new UserData();
        Button save,read,set,get;
        save=(Button) findViewById(R.id.btn_save);
        read=(Button) findViewById(R.id.button_readuser);
        set=(Button) findViewById(R.id.button_settingtoken);
        get=(Button) findViewById(R.id.button_gettoken);
        name=(EditText)findViewById(R.id.editText_username);
        final DataManager dataManager= new DataManager(this);
        assert save != null;
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserData userData=new UserData();

                userData.setUsername(name.getText().toString());
                userData.setPwd(name.getText().toString());
                dataManager.addUserData(userData);
            }
        });

        assert read != null;
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserData userData=dataManager.getUserData(name.getText().toString());
                if(userData==null)
                    return;
                EditText msg=(EditText)findViewById(R.id.editText_user_msg);
                assert name != null;
                msg.setText(userData.getUsername()+userData.getPwd());
            }
        });

        assert set != null;
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText token=(EditText)findViewById(R.id.editText_token);
                dataManager.updateToken(name.getText().toString(),token.getText().toString());
            }
        });

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText token= (EditText) findViewById(R.id.editText_gettoken);
                token.setText(dataManager.getToken(name.getText().toString()));
            }
        });

    }
}
