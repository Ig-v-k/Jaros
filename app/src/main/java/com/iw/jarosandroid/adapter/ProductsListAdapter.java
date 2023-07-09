package com.iw.jarosandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.imageview.ShapeableImageView;
import com.iw.jarosandroid.Product;
import com.iw.jarosandroid.R;

import java.util.List;

public final class ProductsListAdapter extends ArrayAdapter<Product> {
    private final Context context;
    private final List<Product> products;

    public ProductsListAdapter(Context context, List<Product> products) {
        super(context, R.layout.c_products_item, products);
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View vMain = convertView;
        if (vMain == null) {
            vMain = LayoutInflater.from(context).inflate(R.layout.c_products_item, parent, false);
        }

        final ShapeableImageView vImage = vMain.findViewById(R.id.v_image);

        final TextView vTitle = vMain.findViewById(R.id.v_title);

        final TextView vSubtitle = vMain.findViewById(R.id.v_subtitle);

        final TextView vAmount = vMain.findViewById(R.id.v_amount);

        return vMain;
    }
}
