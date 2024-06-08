package com.example.recylerview;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    ArrayList<ProductRecycle> productRecycles;
    RecyclerView recyclerView;
    ProductAdapter productAdapter;
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
        Button mbutton = findViewById(R.id.addButton);
        recyclerView = findViewById(R.id.viewRecycleProductList);
        productRecycles = new ArrayList<ProductRecycle>();
        mbutton.setOnClickListener( v -> {
            try{
                EditText mName = findViewById(R.id.name);
                EditText mQuantity = findViewById(R.id.quantity);
                EditText mPrice = findViewById(R.id.price);
                ProductRecycle newProduct = new ProductRecycle(mName.getText().toString(), Double.parseDouble(mPrice.getText().toString()), Integer.parseInt(mQuantity.getText().toString()));
                productRecycles.add(newProduct);
                productAdapter.notifyDataSetChanged();
                // Clear data
                mName.setText("");
                mQuantity.setText("");
                mPrice.setText("");
            } catch (Exception ex){
                Toast.makeText(this, ex.toString(), Toast.LENGTH_SHORT).show();
            }

        });

        productAdapter = new ProductAdapter(productRecycles, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.option_setting){
            //showSettings();
            return true;
        }
        if(item.getItemId() == R.id.option_favorites){
            //showFavorites();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}