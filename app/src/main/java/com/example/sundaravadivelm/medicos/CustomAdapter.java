package com.example.sundaravadivelm.medicos;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SUNDARAVADIVEL.M on 16-07-2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
    private ArrayList<DictObjectModel> dataSet;
    Boolean check=false;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView word,meaning;
        RelativeLayout expandable;
        public MyViewHolder(View itemView){
            super(itemView);
            this.expandable=(RelativeLayout)itemView.findViewById(R.id.expandableLayout);
            this.word=(TextView)itemView.findViewById(R.id.wordtext);
            this.meaning=(TextView)itemView.findViewById(R.id.meaningtext);

        }

    }

    public CustomAdapter(ArrayList<DictObjectModel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_row, parent, false);

        final MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!check)
                {
                    myViewHolder.expandable.animate()
                            .alpha(0.0f)
                            .setDuration(1000);


                    myViewHolder.expandable.setVisibility(View.GONE);
                    check=true;
                    //  myViewHolder.schedule.setVisibility(View.VISIBLE);

                }
                else {
                    myViewHolder.expandable.setVisibility(View.VISIBLE);
                    myViewHolder.expandable.animate()
                            .alpha(1.0f)
                            .setDuration(1000);

                    check=false;

                }
            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView word1= holder.word;
        TextView meaning1 = holder.meaning;
        String text="\nDESCRIPTION: \n"+dataSet.get(listPosition).description+
                "\n \nSYMPTOMS \n:"+dataSet.get(listPosition).symptoms+
                "\n \nCAUSES: \n"+dataSet.get(listPosition).causes+
                "\n \n DIAGNOSIS: \n"+dataSet.get(listPosition).diagnosis+
                "\n \nTREATMENT: \n"+dataSet.get(listPosition).treatment;

        word1.setText(dataSet.get(listPosition).disease);
        meaning1.setText(text);



    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }




}