package propulsar.sinnix.presentationlayer.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import propulsar.sinnix.R;
import propulsar.sinnix.domainlayer.adapters.AdapterSpeakers;
import propulsar.sinnix.domainlayer.models.Speaker;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpeakersFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private android.support.v7.widget.LinearLayoutManager mLayoutManager;
    private AdapterSpeakers mAdapter;
    private ArrayList<Speaker> mDataset;

    public static SpeakersFragment newInstance(){
        return new SpeakersFragment();
    }
    public SpeakersFragment() {
        // Required empty public constructor
    }

    // -------------------------------------------- //
    // ---------------- LIFE CYCLE ---------------- //
    // -------------------------------------------- //

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_speakers, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.fragmentspeakers_recyclerview);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        mDataset = new ArrayList<Speaker>();

        mAdapter = new AdapterSpeakers(mDataset, getContext());
        mRecyclerView.setAdapter(mAdapter);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        descargarSpeakers();
        return view;

    }

    // --------------------------------------------- //
    // ---------------- OWN METHODS ---------------- //
    //---------------------------------------------- //

    private void descargarSpeakers()
    {
        Speaker speaker1 = new Speaker();
        Speaker speaker2 = new Speaker();
        Speaker speaker3 = new Speaker();
        Speaker speaker4 = new Speaker();
        speaker1.setNombre("Juan Fernandez");
        speaker2.setNombre("Lloyd Jensen");
        speaker3.setNombre("Aaron Gilbert");
        speaker4.setNombre("Florence Butler");
        speaker1.setLinkImg("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCHpjIZOeWuw4fTlWvKLGItzMMAw589Y9iQ2HjTNjo7-1k8ADfBw");
        speaker2.setLinkImg("https://www.rock.com/assets/products/311835/large/star-wars-wicket-ewok-close-up-button-bsw0025.jpg");
        speaker3.setLinkImg("https://s3.amazonaws.com/tjn-blog-images/wp-content/uploads/2015/12/19235907/star-wars-810x540.jpg");
        speaker4.setLinkImg("https://i.pinimg.com/originals/81/5c/dd/815cddf07e5c21e260478d7ca591cab5.jpg");
        speaker1.setKeynotes(" 1234 "+ " 567 " + " 89 ");
        speaker2.setKeynotes(" 2334 "+ " 234 " + " 54 ");
        speaker3.setKeynotes(" 5675 "+ " 657 " + " 34 ");
        speaker4.setKeynotes(" 8796 "+ " 484 " + " 56 ");
        speaker1.setInfo1("UI for better Startups");
        speaker2.setInfo1("UI for better Startups");
        speaker3.setInfo1("UI for better Startups");
        speaker4.setInfo1("UI for better Startups");
        speaker1.setInfo2("User center data science");
        speaker2.setInfo2("User center data science");
        speaker3.setInfo2("User center data science");
        speaker4.setInfo2("User center data science");

        mDataset.add(speaker1); mDataset.add(speaker2); mDataset.add(speaker3); mDataset.add(speaker4);
        mAdapter.notifyDataSetChanged();
    }
}
