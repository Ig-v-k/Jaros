package com.iw.jarosandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.iw.jarosandroid.Product;
import com.iw.jarosandroid.R;
import com.iw.jarosandroid.Route;
import com.iw.jarosandroid.facet.ProductFacet;
import com.iw.jarosandroid.route.ContainerRoute;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Locale;

public final class ProductHomeAdapter extends RecyclerView.Adapter<ProductHomeAdapter.Holder> {
    private final Context context;
    private final List<Product> products;
    private final Route route;

    public ProductHomeAdapter(Context context, List<Product> products, Route route) {
        this.context = context;
        this.products = products;
        this.route = route;
    }

    class Holder extends RecyclerView.ViewHolder {
        private TextView title, subtitle, pln, taste;
        private ShapeableImageView image;
        Holder(View view) {
            super(view);
            title = view.findViewById(R.id.v_title);
            subtitle = view.findViewById(R.id.v_subtitle);
            pln = view.findViewById(R.id.v_amount);
            taste = view.findViewById(R.id.v_taste);
            image = view.findViewById(R.id.v_image);
        }
    }

    @NonNull
    @NotNull
    @Override
    public Holder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.c_product_home_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull Holder holder, int position) {
        final Product product = products.get(position);
        holder.title.setText(product.name());
        holder.subtitle.setText(product.category());
        holder.pln.setText(String.valueOf(product.pln()));
        holder.taste.setText("🍗");
        holder.image.setImageResource(
                context.getResources().getIdentifier(
                        product.name().toLowerCase().trim().replace(" ", ""), "drawable", context.getPackageName()));
        holder.itemView.setOnClickListener(v -> route.forward(new ProductFacet(product, route)));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
