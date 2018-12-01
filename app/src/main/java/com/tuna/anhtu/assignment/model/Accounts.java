package com.tuna.anhtu.assignment.model;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.tuna.anhtu.assignment.DAO.User_DAO;
import com.tuna.anhtu.assignment.adapter.UserAdapter;
import com.tuna.anhtu.assignment.model.User;
import com.tuna.anhtu.assignment.R;

import java.util.List;

public class Accounts extends AppCompatActivity {
    private ListView listView;
    private EditText edDate, edHome, edName, edPhone;
    private User_DAO userDAO;
    UserAdapter adapter;
    private List<User> list;
    private FloatingActionButton floatingActionButton;
    private Toolbar toolbar;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);
        listView = findViewById(R.id.lv);
        userDAO = new User_DAO(Accounts.this);
        list = userDAO.getAllUser();
        adapter = new UserAdapter(this, list);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imageView=findViewById(R.id.outuser);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        listView.setAdapter(adapter);
        floatingActionButton = findViewById(R.id.floatAdd);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Accounts.this, EditUser.class);
                Bundle b = new Bundle();
                b.putString("NAME", list.get(position).getmName());
                b.putString("DATE", list.get(position).getmDate());
                b.putString("HOME", list.get(position).getmHome());
                b.putString("PHONE", list.get(position).getmPhone());
                intent.putExtras(b);
                startActivity(intent);
                return false;
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Accounts.this);
                builder.setTitle("Add User");
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.dialog, null);
                builder.setView(viewDialog);
                edName = viewDialog.findViewById(R.id.Name);
                edDate = viewDialog.findViewById(R.id.Birthday);
                edPhone = viewDialog.findViewById(R.id.Phone);
                edHome = viewDialog.findViewById(R.id.Home);
                builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        userDAO = new User_DAO(Accounts.this);
                        User user = new User(edName.getText().toString(), edDate.getText().toString(), edHome.getText().toString(), edPhone.getText().toString());
                        try {
                            if (validateForm() > 0) {
                                if (userDAO.inserUser(user) > 0) {
                                    Toast.makeText(Accounts.this, "Add successfully", Toast.LENGTH_SHORT).show();
                                    list.clear();
                                    list = userDAO.getAllUser();
                                    adapter.changeDataset(userDAO.getAllUser());
                                } else {
                                    Toast.makeText(Accounts.this, "Add error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        } catch (Exception ex) {
                            Log.e("Error", ex.toString());
                        }
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
            }

            private int validateForm() {
                int check = 1;
                if (edName.getText().length() == 0 || edDate.getText().length() == 0 || edHome.getText().length() == 0 || edPhone.getText().length() == 0) {
                    Toast.makeText(getApplicationContext(), "You must enter full information ", Toast.LENGTH_SHORT).show();
                    check = -1;
                }
                return check;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        list.clear();
        list=  userDAO.getAllUser();
        adapter.changeDataset(userDAO.getAllUser());
    }
}
