package com.tuna.anhtu.assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tuna.anhtu.assignment.model.Accounts;

public class MainActivity extends AppCompatActivity {
//    private FloatingActionButton fab_fb,fab_map,fab_student,fab_news;
//    boolean showhide = false;


    private Button btnStudent;
    private Button btnFacebook;
    private Button btnNews;
    private Button btnMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Facebook.class));
            }
        });

        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Accounts.class));
            }
        });

        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MapsActivity.class));
            }
        });

        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,WebView_News.class));
            }
        });

//        fab_student = (FloatingActionButton) findViewById(R.id.student);
//        fab_fb = (FloatingActionButton) findViewById(R.id.facebook);
//        fab_map = (FloatingActionButton) findViewById(R.id.maps);
//        fab_news = (FloatingActionButton) findViewById(R.id.news);


        

    }

    public void initView(){

        btnStudent = (Button) findViewById(R.id.btnStudent);
        btnFacebook = (Button) findViewById(R.id.btnFacebook);
        btnNews = (Button) findViewById(R.id.btnNews);
        btnMaps = (Button) findViewById(R.id.btnMaps);

    }

//    private void showFloating(){
//        fab_fb.show();
//        fab_map.show();
//        fab_student.show();
//        fab_news.show();
//    }
//
//    private void HideFloating(){
//        fab_fb.hide();
//        fab_map.hide();
//        fab_student.hide();
//        fab_news.hide();
//    }
}
