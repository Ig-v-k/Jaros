package com.iw.jarosandroid.facet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.appbar.MaterialToolbar;
import com.iw.jarosandroid.*;
import com.iw.jarosandroid.adapter.ProductsListAdapter;
import com.iw.jarosandroid.sqlite.SQLiteHelper;
import com.iw.jarosandroid.products.ConstProducts;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class ProductsFacet extends Fragment implements Facet {

    private Context context;
    private View vMain;
    private final Route route;
    private final String category;

    public ProductsFacet(Route route) {
        this(route, ""  );
    }

    public ProductsFacet(Route route, String category) {
        this.route = route;
        this.category = category;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        vMain = inflater.inflate(R.layout.f_products, container, false);
        return vMain;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view,
                              @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        final Products productsLocal = new ConstProducts(new SQLiteHelper(context));
        final List<Product> products = productsLocal.list();
        if (!category.isEmpty()) {
            products.removeIf(product -> !product.category().equals(category));
        }

        final MaterialToolbar vToolbar = vMain.findViewById(R.id.v_toolbar);
        vToolbar.setNavigationOnClickListener(v -> route.back());

        final ListView vList = vMain.findViewById(R.id.v_list);
        vList.setAdapter(new ProductsListAdapter(context, products));
        vList.setOnItemClickListener((parent, view1, position, id) -> {
            final Product product = products.get(position);
            route.forward(new ProductFacet(product, route));
        });
    }

    @Override
    public String tag() {
        return "ProductsFacet";
    }

    @Override
    public String name() {
        return "ProductsFacet";
    }

    @Override
    public Fragment fragment() {
        return this;
    }

    @Override
    public Facet self() {
        return new ProductsFacet(route, category);
    }
}
