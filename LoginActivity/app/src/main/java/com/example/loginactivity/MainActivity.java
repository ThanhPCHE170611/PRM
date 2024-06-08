package com.example.loginactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText loginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        loginText= findViewById(R.id.text_username);
        Button loginButton = findViewById(R.id.button);
        loginButton.setOnClickListener(v ->{
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            intent.putExtra("name", loginText.getText().toString());
            startActivity(intent);
            finish();
        });
    }
    @Override
    public void onPause(){
        super.onPause();
        loginText.setText("");
    }
}