package com.iw.jarosandroid.facet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.iw.jarosandroid.Facet;
import com.iw.jarosandroid.R;
import com.iw.jarosandroid.Route;
import org.jetbrains.annotations.NotNull;

public final class DinnerFacet extends Fragment implements Facet {

    private Route route;
    private Context context;
    private View vMain;

    public DinnerFacet(Route route) {
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
        vMain = inflater.inflate(R.layout.f_dinner, container, false);
        return vMain;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view,
                              @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

    }

    @Override
    public String tag() {
        return "DinnerFacet";
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
        return new DinnerFacet(route);
    }
}
