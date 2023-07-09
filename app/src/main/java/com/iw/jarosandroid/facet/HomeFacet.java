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
import com.iw.jarosandroid.Facet;
import com.iw.jarosandroid.Product;
import com.iw.jarosandroid.R;
import com.iw.jarosandroid.Route;
import com.iw.jarosandroid.adapter.ProductHomeAdapter;
import com.iw.jarosandroid.product.SimpleProduct;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
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
        final List<Product> products = new ArrayList<Product>(){{
            add(new SimpleProduct(1, "Rolada schabowa", "", "Mieso", 14.0));
            add(new SimpleProduct(2, "Kotlet mielony", "", "Mieso", 14.0));
            add(new SimpleProduct(3, "Devolay", "", "Mieso", 14.0));
        }};

        final RecyclerView vProducts = vMain.findViewById(R.id.v_products);
        vProducts.setItemAnimator(new DefaultItemAnimator());
        vProducts.setAdapter(new ProductHomeAdapter(context, products, route));
        vProducts.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
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
