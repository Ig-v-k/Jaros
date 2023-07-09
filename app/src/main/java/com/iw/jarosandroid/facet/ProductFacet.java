package com.iw.jarosandroid.facet;

import android.content.Context;
import android.os.Bundle;
import android.view.*;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import com.google.android.material.appbar.MaterialToolbar;
import com.iw.jarosandroid.*;
import com.iw.jarosandroid.product.SimpleProduct;
import com.iw.jarosandroid.route.ContainerRoute;
import org.jetbrains.annotations.NotNull;

public final class ProductFacet extends Fragment implements Facet {

    private Context context;
    private View vMain;
    private final Product product;
    private final Route route;

    public ProductFacet() {
        this.product = new SimpleProduct(1, "Kotlet mielony", "", "Mieso", 14.0, false);
        this.route = null;
    }

    public ProductFacet(Product product, Route route) {
        this.product = product;
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
        return vMain = inflater.inflate(R.layout.f_product, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view,
                              @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        // toolbar
        final MaterialToolbar vToolbar = vMain.findViewById(R.id.v_toolbar);
        vToolbar.setNavigationOnClickListener(v -> route.back());
        vToolbar.setTitle(product.name());
        vToolbar.setSubtitle(product.category());
    }

    @Override
    public String tag() {
        return "ProductFacet:" + (product == null ? 1 : product.id());
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
        return new ProductFacet(product, route);
    }
}
