package propulsar.sinnix.domainlayer.adapters;

import android.app.Activity;
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

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import propulsar.sinnix.R;
import propulsar.sinnix.domainlayer.models.Speaker;

/**
 * Created by givet on 16/01/2018.
 */

public class AdapterSpeakers extends RecyclerView.Adapter<AdapterSpeakers.ViewHolder>{

    private ArrayList<Speaker> mDataset;
    Context mContext;

    public AdapterSpeakers(ArrayList<Speaker> myDataset, Context mContext)
    {
        mDataset = myDataset;
        this.mContext = mContext;

    }


    // ------------------------------------------------------------- //
    // ---------------- VIEW HOLDER IMPLEMENTATION ---------------- //
    //-------------------------------------------------------------- //

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_speakers, parent, false);
        return new ViewHolder(v);
    }

    //Asignacion de modelos de datos a las instancias de las vistas por cada vista//

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textViewNombre.setText(mDataset.get(position).getNombre());
        holder.textViewKeynotes.setText(mDataset.get(position).getKeynotes());
        holder.textViewInfo.setText(mDataset.get(position).getInfo1());
        holder.textViewInfo2.setText(mDataset.get(position).getInfo2());
        Picasso.with(mContext).load(Uri.parse((mDataset.get(position)).getLinkImg())).into(holder.imageViewIcon);
    }

    @Override
    public int getItemCount() {

        return mDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View fullView;
        private ImageView imageViewIcon;
        private TextView textViewNombre;
        private TextView textViewInfo;
        private TextView textViewInfo2;
        private TextView textViewKeynotes;
        private Button buttonNetworkingAdd;


        public ViewHolder(View itemView) {

            super(itemView);
            fullView = itemView.findViewById(R.id.itemspeakers_cardview_fullview);
            imageViewIcon = itemView.findViewById(R.id.itemspeakers_imageview_icon);
            textViewNombre = itemView.findViewById(R.id.itemspeakers_textview_nombre);
            textViewKeynotes = itemView.findViewById(R.id.itemspeakers_textview_keynotes);
            textViewInfo = itemView.findViewById(R.id.itemspeakers_textview_info);
            textViewInfo2 = itemView.findViewById(R.id.itemspeakers_textview_info2);
            buttonNetworkingAdd = itemView.findViewById(R.id.itemspeakers_button_networkingadd);

        }
    }
}
