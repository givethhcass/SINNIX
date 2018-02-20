package propulsar.sinnix.domainlayer.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.ArrayList;

import propulsar.sinnix.R;
import propulsar.sinnix.domainlayer.models.Agenda;

/**
 * Created by givet on 16/01/2018.
 */

public class AdapterAgenda extends RecyclerView.Adapter<AdapterAgenda.ViewHolder> {

    private ArrayList<Agenda> mDataset;
    Context mContext;

    public AdapterAgenda(ArrayList<Agenda> myDataset, Context mContext) {
        mDataset = myDataset;
        this.mContext = mContext;

    }

    // ------------------------------------------------------------- //
    // ---------------- VIEW HOLDER IMPLEMENTATION ---------------- //
    //-------------------------------------------------------------- //


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mi_agenda, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        holder.textViewSpeak.setText(mDataset.get(position).getSpeak());
        holder.textViewHorario.setText(mDataset.get(position).getHorario());
        holder.textViewFecha.setText(mDataset.get(position).getFecha());
        holder.textViewLocacion.setText(mDataset.get(position).getLocacion());
        holder.textViewInfo.setText(mDataset.get(position).getInfo());
        holder.textViewNombre.setText(mDataset.get(position).getNombre());
        Picasso.with(mContext).load(Uri.parse((mDataset.get(position)).getLinkimg())).into(holder.imageViewIcon);

    }

    @Override
    public int getItemCount()
    {
        return mDataset.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
        {
            private View fullView;
            private ImageView imageViewIcon;
            private TextView textViewSpeak;
            private TextView textViewNombre;
            private TextView textViewInfo;
            private TextView textViewLocacion;
            private TextView textViewFecha;
            private TextView textViewHorario;
            private Button btn;

        public ViewHolder(View itemView)

        {
            super(itemView);

            textViewSpeak = itemView.findViewById(R.id.item_mi_agenda_textview_speak);
            imageViewIcon = itemView.findViewById(R.id.item_mi_agenda_imageview_icon);
            textViewNombre = itemView.findViewById(R.id.item_mi_agenda_textview_nombrespeaker);
            textViewInfo = itemView.findViewById(R.id.item_mi_agenda_textview_informacion);
            textViewLocacion = itemView.findViewById(R.id.item_mi_agenda_textview_locacion);
            textViewFecha = itemView.findViewById(R.id.item_mi_agenda_textview_fecha);
            textViewHorario = itemView.findViewById(R.id.item_mi_agenda_textview_horario);

        }


    }
}

