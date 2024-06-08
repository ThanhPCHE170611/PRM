package com.example.bindingviewdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Account> accounts = new ArrayList<>();
    private Boolean checkState;
    private String usernameReturn;
    SeekBar mSeekBar;
    TextView mTextViewSeekBar;
    private String username, password;
    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult o) {
                    if(o.getResultCode() == MainActivity.RESULT_OK){
                        //Here no request code
                        Intent data = o.getData();
                        usernameReturn = data.getExtras().getString("username");
                        Log.d("username", usernameReturn);
                        //do some Operation()
                    }
                }
            }
    );
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
        addForAccount();
        mSeekBar = findViewById(R.id.seekbar);
        mTextViewSeekBar = findViewById(R.id.txtSeekBarViewBinding);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                this.progress = progress;
                Toast.makeText(MainActivity.this, String.valueOf(progress), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mTextViewSeekBar.setText("Covered" + progress+"/"+mSeekBar.getMax());
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        Button button = findViewById(R.id.button_login);
        button.setOnClickListener(v -> onLogin());
        CheckBox mJava = findViewById(R.id.checkboxViewBindingJava);
        mJava.setOnClickListener(view -> {
            Toast.makeText(this, "Java", Toast.LENGTH_SHORT).show();
        });
        CheckBox mPython = findViewById(R.id.checkboxViewBindingPython);
        mPython.setOnClickListener(view ->{
            Toast.makeText(this, "Python", Toast.LENGTH_SHORT).show();
        });
        CheckBox mAndroid = findViewById(R.id.checkboxViewBindingAndroid);
        mAndroid.setOnClickListener(view -> {
            Toast.makeText(this, "Android", Toast.LENGTH_SHORT).show();
        });
        RadioGroup radioGroup = findViewById(R.id.radioGroupViewBinding);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(MainActivity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        Spinner mSpinner = findViewById(R.id.planets_spinner);
        List<String> categories = new ArrayList<String>();
        categories.add("Item1");
        categories.add("Item2");
        categories.add("Item3");
        categories.add("Item4");
        categories.add("Item5");
        categories.add("Item6");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(arrayAdapter);
        ToggleButton mToggleButton = findViewById(R.id.ToggleState);
        mToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkState =((ToggleButton)v).isChecked();
                if(checkState){
                    mToggleButton.setText("Play On");
                } else {
                    mToggleButton.setText("Play Off");
                }
            }
        });
    }

    private void addForAccount() {
        Account newAccount = new Account("user1", "pass1");
        Account newAccount1 = new Account("user2", "pass2");
        Account newAccount2 = new Account("user3", "pass3");
        accounts.add(newAccount);
        accounts.add(newAccount1);
        accounts.add(newAccount2);
    }

    private void onLogin(){
        EditText editUsername = findViewById(R.id.text_username);
        EditText editPassword = findViewById(R.id.text_password);
        username = editUsername.getText().toString();
        password = editPassword.getText().toString();
        boolean canLogin = false;
        for(Account account : accounts){
            if(account.getUsername().equalsIgnoreCase(username)){
                if(account.getPassword().equalsIgnoreCase(password)){
                    canLogin = true;
                    break;
                }
            }
        }
        if(canLogin){
//            Intent i = new Intent(MainActivity.this, NewActivity.class);
//            startActivity(i);
            // show contracts
//            Intent read1 = new Intent();
//            read1.setAction(Intent.ACTION_VIEW);
//            read1.setData(ContactsContract.Contacts.CONTENT_URI);
//            startActivity(read1);
//            Uri uri = Uri.parse("http://wwww.google.com");
//            Intent it = new Intent(Intent.ACTION_VIEW, uri);
//            startActivity(it);
            // pass data:
//            Intent intent = new Intent(MainActivity.this, NewActivity.class);
//            intent.putExtra("Key", editPassword.getText().toString());
//            startActivity(intent);
//            Intent intent = new Intent(this, NewActivity.class);
//            List<Integer> test = new ArrayList<Integer>();
//            test.add(1);
//            test.add(2);
//            test.add(3);
//            intent.setData(Uri.parse("http://www.google.com"));
//            intent.putExtra("username", editUsername.getText().toString());
//            intent.putExtra("password", editPassword.getText().toString());
//            intent.putIntegerArrayListExtra("listAge", (ArrayList<Integer>) test);
//            startActivity(intent);
            Intent intent = new Intent(getApplicationContext(), NewActivity.class);
            someActivityResultLauncher.launch(intent);
        }
        else {
            Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
        }
    }

}