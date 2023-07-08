package com.iw.jarosandroid.facet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.card.MaterialCardView;
import com.iw.jarosandroid.Facet;
import com.iw.jarosandroid.MainActivity;
import com.iw.jarosandroid.Product;
import com.iw.jarosandroid.R;
import com.iw.jarosandroid.product.SimpleProduct;
import com.iw.jarosandroid.route.ContainerRoute;
import org.jetbrains.annotations.NotNull;

public final class HomeFacet extends Fragment implements Facet {

    private Context context;
    private View vMain;

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
        final MaterialCardView materialCardView = vMain.findViewById(R.id.v_productTest);
        materialCardView.setOnClickListener(v -> {
            final Product product = new SimpleProduct(1, "Kotlet mielony", "", "", "", "");
            final ContainerRoute containerRoute = new ContainerRoute(((MainActivity)context).getSupportFragmentManager());
            containerRoute.forward(new ProductFacet(product, containerRoute));
        });
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
        return new HomeFacet();
    }
}
