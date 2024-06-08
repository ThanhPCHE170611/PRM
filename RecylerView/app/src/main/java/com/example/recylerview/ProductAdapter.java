package com.example.recylerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<ProductRecycle> mProducts;
    private Context mContext;

    public ProductAdapter(List<ProductRecycle> mProducts, Context mContext) {
        this.mProducts = mProducts;
        this.mContext = mContext;
    }
//Instantiate ViewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View productView = inflater.inflate(R.layout.product_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(productView);
        return viewHolder;
    }
// action on viewHolder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductRecycle product = mProducts.get(position);
        holder.productName.setText(product.getmName());
        holder.quantity.setText(String.valueOf(product.getQuantity()));
        holder.price.setText(String.valueOf(product.getPrice()));
    }
// return number of viewHolder
    @Override
    public int getItemCount() {
        return mProducts.size();
    }
}
