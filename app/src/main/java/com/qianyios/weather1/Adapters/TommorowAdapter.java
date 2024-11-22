package com.qianyios.weather1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.qianyios.weather1.Domains.Hourly;
import com.qianyios.weather1.Domains.TommorowDomain;
import com.qianyios.weather1.R;

import java.util.ArrayList;

public class TommorowAdapter extends RecyclerView.Adapter<TommorowAdapter.ViewHolder> {
    ArrayList<TommorowDomain> items;
    Context context;

    public TommorowAdapter(ArrayList<TommorowDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public TommorowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_tommorow, parent, false);
        context = parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull TommorowAdapter.ViewHolder holder, int position) {

        holder.datTxt.setText(items.get(position).getDay());
        holder.statusTxt.setText(items.get(position).getStatus());
        holder.highTxt.setText(items.get(position).getHighTemp()+"°");
        holder.lowTxt.setText(items.get(position).getLowTemp()+"°");



        int drawableResourceId=holder.itemView.getResources()
                .getIdentifier(items.get(position).getPicPath(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.pic);


    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView datTxt,statusTxt,lowTxt,highTxt;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            datTxt=itemView.findViewById(R.id.dayTxt);
            statusTxt=itemView.findViewById(R.id.statusTxt);
            lowTxt=itemView.findViewById(R.id.lowTxt);
            highTxt=itemView.findViewById(R.id.highTxt);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}
