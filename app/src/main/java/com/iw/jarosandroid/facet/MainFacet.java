package com.iw.jarosandroid.facet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.iw.jarosandroid.Facet;
import com.iw.jarosandroid.R;
import com.iw.jarosandroid.Route;
import org.jetbrains.annotations.NotNull;

public final class MainFacet extends Fragment implements Facet {
    private final int id;
    private final Route route;

    public MainFacet(final int id, final Route route) {
        this.id = id;
        this.route = route;
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        final View vMain = inflater.inflate(R.layout.f_main, container, false);

        final TextView vForward = vMain.findViewById(R.id.v_forward);
        vForward.setOnClickListener(v -> route.forward(self()));

        final TextView vBack = vMain.findViewById(R.id.v_back);
        vBack.setOnClickListener(v -> route.back());

        final TextView vReplace = vMain.findViewById(R.id.v_replace);
        vReplace.setOnClickListener(v -> route.replace(self()));

        return vMain;
    }

    @Override
    public String tag() {
        return String.format("Facet(%s)", id);
    }

    @Override
    public String name() {
        return String.format("[%s]", id);
    }

    @Override
    public Fragment fragment() {
        return this;
    }

    @Override
    public Facet self() {
        return new MainFacet(id + 1, route);
    }
}