package com.iw.jarosandroid;

import androidx.fragment.app.Fragment;

public interface Facet {
    String tag();
    String name();
    Fragment fragment();
    Facet self();
}
