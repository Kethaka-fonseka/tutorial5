package com.example.datahandling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.datahandling.Database.DBHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText etUserName,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUserName=findViewById(R.id.etUserName);
        etPassword=findViewById(R.id.etPassword);


    }

    public void addInfo(View view){
        DBHelper dbHelper=new DBHelper(this);
        long val=dbHelper.addInfo(etUserName.getText().toString(),etPassword.getText().toString());
    if(val>0){
        Toast.makeText(this,"Data successfully added",Toast.LENGTH_SHORT).show();
    }
    else{
        Toast.makeText(this,"Data Insertion Unsuccessfull",Toast.LENGTH_SHORT).show();
    }
    }


    public void readAll(View view){
        DBHelper dbHelper=new DBHelper(this);
        List unames=dbHelper.readAllInfo("user");

        Toast.makeText(this,unames.toString(),Toast.LENGTH_SHORT).show();
    }

    public void deleteInfo(View view){
        DBHelper dbHelper=new DBHelper(this);
        dbHelper.deleteInfo(etUserName.getText().toString());
    }
    public void updateInfo(View view){
        DBHelper dbHelper=new DBHelper(this);
        dbHelper.updateInfo(etUserName.getText().toString(),etPassword.getText().toString());
    }

    public void signIn(View view){
        DBHelper dbHelper=new DBHelper(this);
        List usernames=dbHelper.readAllInfo("user");
        List passwords=dbHelper.readAllInfo("password");
        String user=etUserName.getText().toString();
        String password=etPassword.getText().toString();

        if(usernames.indexOf(user)>=0){
if(passwords.get(usernames.indexOf(user)).equals(password)){
    Toast.makeText(this,"login success",Toast.LENGTH_SHORT).show();
}
else{
    Toast.makeText(this,"login unsuccess",Toast.LENGTH_SHORT).show();
}
        }


    }
}