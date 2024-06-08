package com.example.bindingviewdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//        if(getIntent() != null){
//            Bundle extra = getIntent().getExtras();
//            String username = extra.getString("username");
//            String password = extra.getString("password");
//            List<Integer> test = extra.getIntegerArrayList("listAge");
//            Uri uri = getIntent().getData();
//            Log.d("TAG", username);
//            Log.d("TAG1", password);
//            Log.d("ListAge", test.get(2).toString());
//            Log.d("data", uri.toString());
//        }
        Button backButton = findViewById(R.id.button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("username", "usernametest");
                setResult(NewActivity.RESULT_OK, intent);
                finish();
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.d("Log State", "Lưu trạng thái Start");
    }
}