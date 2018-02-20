package propulsar.sinnix.presentationlayer.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import propulsar.sinnix.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VipFragment extends Fragment {


    public VipFragment() {
        // Required empty public constructor
    }

    // -------------------------------------------- //
    // ---------------- LIFE CYCLE ---------------- //
    // -------------------------------------------- //

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vip, container, false);
    }

    public static VipFragment newInstance() {
        VipFragment fragment = new VipFragment();
        return fragment;
    }
}
