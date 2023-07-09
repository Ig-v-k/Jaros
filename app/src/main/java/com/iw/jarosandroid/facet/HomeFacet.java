package com.iw.jarosandroid.facet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.iw.jarosandroid.*;
import com.iw.jarosandroid.adapter.ProductHomeAdapter;
import com.iw.jarosandroid.database.SQLiteHelper;
import com.iw.jarosandroid.products.ConstProducts;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public final class HomeFacet extends Fragment implements Facet {

    private Context context;
    private View vMain;
    private final Route route;

    public HomeFacet(Route route) {
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
        vMain = inflater.inflate(R.layout.f_home, container, false);
        return vMain;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view,
                              @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        final Products productsLocal = new ConstProducts(new SQLiteHelper(context));
        final List<Product> productList = productsLocal.list();
        final List<Product> products = productList.subList(0, 4);

        final RecyclerView vProducts = vMain.findViewById(R.id.v_products);
        vProducts.setItemAnimator(new DefaultItemAnimator());
        vProducts.setAdapter(new ProductHomeAdapter(context, products, route));
        vProducts.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        final MaterialButton vAll = vMain.findViewById(R.id.v_see_all);
        vAll.setOnClickListener(v -> route.forward(new ProductsFacet(route)));

        final MaterialButton vMeals = vMain.findViewById(R.id.v_meals);
        vMeals.setOnClickListener(v -> route.forward(new ProductsFacet(route, "Mieso")));

        final MaterialButton vSoups = vMain.findViewById(R.id.v_soups);
        vSoups.setOnClickListener(v -> route.forward(new ProductsFacet(route, "Zupa")));
    }

    @Override
    public String tag() {
        return "HomeFacet";
    }

    @Override
    public String name() {
        return "";
    }

    @Override
    public Fragment fragment() {
        return this;
    }

    @Override
    public Facet self() {
        return new HomeFacet(route);
    }
}
