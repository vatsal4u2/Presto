package com.presto.vatsalpatel.presto.Ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.presto.vatsalpatel.presto.R;


import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context mContext;
    List<ListData> mDataSet;

    public Adapter(Context context){
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view =  layoutInflater.inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(mDataSet.get(position).title);
        holder.size.setText(mDataSet.get(position).size);
        holder.dimension.setText(mDataSet.get(position).dimension);

        RequestOptions requestOptions = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);

        Glide.with(mContext)
                .load(mDataSet.get(position).imageUrl)
                .apply(requestOptions)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mDataSet != null && mDataSet.size()> 0 ? mDataSet.size():0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        final View mView;
        ImageView imageView;
        TextView title,size,dimension;

        ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            imageView = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            size = itemView.findViewById(R.id.size);
            dimension = itemView.findViewById(R.id.dimention);

        }
    }

    public void setListData(List<ListData> listData){
        this.mDataSet = listData;
        notifyDataSetChanged();
    }
}
