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
import propulsar.sinnix.domainlayer.adapters.AdapterAgenda;
import propulsar.sinnix.domainlayer.adapters.AdapterSpeakers;
import propulsar.sinnix.domainlayer.models.Agenda;
import propulsar.sinnix.domainlayer.models.Speaker;

/**
 * A simple {@link Fragment} subclass.
 */
public class AgendaFragment extends Fragment {

    // OBJETOS //

    private RecyclerView mRecyclerView;
    private android.support.v7.widget.LinearLayoutManager mLayoutManager;
    private AdapterAgenda mAdapter;
    private ArrayList<Agenda> mDataset;

    public static AgendaFragment newInstance(){
        return new AgendaFragment();
    }
    public AgendaFragment() {
        // Required empty public constructor
    }

    // -------------------------------------------- //
    // ---------------- LIFE CYCLE ---------------- //
    // -------------------------------------------- //

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_agenda, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.fragmentmiagenda_recyclerview);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        mDataset = new ArrayList<Agenda>();

        mAdapter = new AdapterAgenda(mDataset, getContext());
        mRecyclerView.setAdapter(mAdapter);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        descargarAgenda();
        return view;
    }

    // --------------------------------------------- //
    // ---------------- OWN METHODS ---------------- //
    //---------------------------------------------- //

    private void descargarAgenda()
    {
        Agenda agenda1 = new Agenda();
        Agenda agenda2 = new Agenda();
        Agenda agenda3 = new Agenda();
        Agenda agenda4 = new Agenda();
        agenda1.setSpeak("Speak 1");
        agenda2.setSpeak("Speak 2");
        agenda3.setSpeak("Speak 3");
        agenda4.setSpeak("Speak 4");
        agenda1.setNombre("Juan Fernandez");
        agenda2.setNombre("Lloyd Jensen");
        agenda3.setNombre("Aaron Gilbert");
        agenda4.setNombre("Florence Butler");
        agenda1.setFecha("Febrero 20, 2018");
        agenda2.setFecha("Febrero 21, 2018");
        agenda3.setFecha("Febrero 22, 2018");
        agenda4.setFecha("Febrero 23, 2018");
        agenda1.setHorario("15:00");
        agenda2.setHorario("15:00");
        agenda3.setHorario("15:00");
        agenda4.setHorario("15:00");
        agenda1.setLocacion("Estela de Luz");
        agenda2.setLocacion("Estela de Luz");
        agenda3.setLocacion("Estela de Luz");
        agenda4.setLocacion("Estela de Luz");
        agenda1.setInfo("If you are looking for great ways to decorate your home or office, then you knows as well as i do that you have...");
        agenda2.setInfo("If you are looking for great ways to decorate your home or office, then you knows as well as i do that you have...");
        agenda3.setInfo("If you are looking for great ways to decorate your home or office, then you knows as well as i do that you have...");
        agenda4.setInfo("If you are looking for great ways to decorate your home or office, then you knows as well as i do that you have...");
        agenda1.setLinkimg("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCHpjIZOeWuw4fTlWvKLGItzMMAw589Y9iQ2HjTNjo7-1k8ADfBw");
        agenda2.setLinkimg("https://www.rock.com/assets/products/311835/large/star-wars-wicket-ewok-close-up-button-bsw0025.jpg");
        agenda3.setLinkimg("https://s3.amazonaws.com/tjn-blog-images/wp-content/uploads/2015/12/19235907/star-wars-810x540.jpg");
        agenda4.setLinkimg("https://i.pinimg.com/originals/81/5c/dd/815cddf07e5c21e260478d7ca591cab5.jpg");


        mDataset.add(agenda1); mDataset.add(agenda2); mDataset.add(agenda3); mDataset.add(agenda4);
        mAdapter.notifyDataSetChanged();
    }

}
