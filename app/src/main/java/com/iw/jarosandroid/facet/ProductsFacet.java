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
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.iw.jarosandroid.*;
import com.iw.jarosandroid.adapter.ProductHomeAdapter;
import com.iw.jarosandroid.adapter.ProductsListAdapter;
import com.iw.jarosandroid.database.SQLiteHelper;
import com.iw.jarosandroid.products.ConstProducts;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class ProductsFacet extends Fragment implements Facet {

    private Context context;
    private View vMain;
    private final Route route;

    public ProductsFacet(List<Product> products, Route route) {
        this.products = products;
        this.route = route;
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
        final ListView vList = vMain.findViewById(R.id.v_list);
        vList.setAdapter(new ProductsListAdapter(context, products));
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
        return ;
    }
}
