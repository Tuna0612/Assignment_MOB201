package com.tuna.anhtu.assignment.model;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tuna.anhtu.assignment.DAO.User_DAO;
import com.tuna.anhtu.assignment.R;

public class    EditUser extends AppCompatActivity {
    EditText editName, editPhone,editHome,editDate;
    User_DAO userDAO;
    String  editname, editphone,editdate,edithome,editUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        editName = findViewById(R.id.edFullName);
        editDate = findViewById(R.id.edDate);
        editHome = findViewById(R.id.edHome);
        editPhone = findViewById(R.id.edPhone);
        userDAO = new User_DAO(this);
        Intent in = getIntent();
        Bundle b = in.getExtras();
        editname = b.getString("NAME");
        editphone = b.getString("PHONE");
        editdate = b.getString("BIRTHDAY");
        edithome = b.getString("HOME");
        editName.setText(editname);
        editDate.setText(editdate);
        editHome.setText(edithome);
        editPhone.setText(editphone);

    }

    public void outedit(View view) {
        finish();
    }

    public void updateUser(View view) {
        if (userDAO.updateUser(editUsername,editName.getText().toString(), editPhone.getText().toString(),editDate.getText().toString(),editHome.getText().toString()) > 0) {
            Toast.makeText(getApplicationContext(), "Save successfully", Toast.LENGTH_SHORT).show();
            finish();
        }

    }
    public void Huy(View view) {
        finish();
    }
}
