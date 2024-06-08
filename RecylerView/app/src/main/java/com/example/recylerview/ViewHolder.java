package com.example.recylerview;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView productName;
    public TextView quantity, price;
    public Button detail_button;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image1);
        Picasso.get().load("https://i1-dulich.vnecdn.net/2021/07/16/1-1626437591.jpg?w=1200&h=0&q=100&dpr=1&fit=crop&s=BWzFqMmUWVFC1OfpPSUqMA")
                .into(imageView);
        productName = itemView.findViewById(R.id.viewRecycleProductName);
        quantity = itemView.findViewById(R.id.viewRecycleProductQuantity);
        price = itemView.findViewById(R.id.viewRecycleProductPrice);
        detail_button = itemView.findViewById(R.id.btnRecycleDetail);
        detail_button.setId(getAdapterPosition());
        detail_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(itemView.getContext(), "vi tri" + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
