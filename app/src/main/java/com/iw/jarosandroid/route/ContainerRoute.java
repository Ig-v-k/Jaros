package com.iw.jarosandroid.route;

import androidx.fragment.app.FragmentManager;
import com.iw.jarosandroid.Facet;
import com.iw.jarosandroid.R;
import com.iw.jarosandroid.Route;

public final class ContainerRoute implements Route {
    private final FragmentManager manager;

    public ContainerRoute(FragmentManager manager) {
        this.manager = manager;
    }

    @Override
    public void forward(Facet facet) {
        manager.beginTransaction()
                .setReorderingAllowed(true)
                .addToBackStack(facet.tag())
                .add(R.id.v_main_container, facet.fragment(), facet.tag())
                .commit();
    }

    @Override
    public void back() {
        manager.popBackStack();
    }

    @Override
    public void replace(Facet facet) {
        manager.popBackStack();
        manager.beginTransaction()
                .setReorderingAllowed(false)
                .replace(R.id.v_main_container, facet.fragment(), facet.tag())
                .commit();
    }
}
