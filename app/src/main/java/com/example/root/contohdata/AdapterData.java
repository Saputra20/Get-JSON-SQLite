package com.example.root.contohdata;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AdapterData extends RecyclerView.Adapter<AdapterData.DattaMainHolder>{

    private Context context ;
    private ArrayList<ModelData> list ;

    public AdapterData(Context context, ArrayList<ModelData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public DattaMainHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list , viewGroup , false);
        return new DattaMainHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DattaMainHolder dattaMainHolder, int i) {
        ModelData modelData = list.get(i);

        String str_id = modelData.getIdTeam();
        String str_name = modelData.getStrTeam();
        String str_alter = modelData.getStrAlternate();
        String str_stadium = modelData.getStrStadium();
        String str_manager = modelData.getStrManager();
        String str_keyword = modelData.getStrKeywords();

        dattaMainHolder.idteam.setText(str_id);
        dattaMainHolder.teamName.setText(str_name);
        dattaMainHolder.altername.setText(str_alter);
        dattaMainHolder.stadium.setText(str_stadium);
        dattaMainHolder.Tmanager.setText(str_manager);
        dattaMainHolder.keyword.setText(str_keyword);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DattaMainHolder extends RecyclerView.ViewHolder{

        public TextView idteam ;
        public TextView teamName;
        public TextView altername ;
        public TextView Tmanager ;
        public TextView stadium;
        public TextView keyword;
        public DattaMainHolder(@NonNull View itemView) {
            super(itemView);

            idteam = itemView.findViewById(R.id.idteam);
            teamName = itemView.findViewById(R.id.teamname);
            altername = itemView.findViewById(R.id.alternateName);
            Tmanager = itemView.findViewById(R.id.managerteam);
            stadium = itemView.findViewById(R.id.stadiumName);
            keyword = itemView.findViewById(R.id.keyword);

        }
    }

}
