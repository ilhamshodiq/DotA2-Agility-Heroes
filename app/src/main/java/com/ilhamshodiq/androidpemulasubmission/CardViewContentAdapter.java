package com.ilhamshodiq.androidpemulasubmission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.*;

public class CardViewContentAdapter extends RecyclerView.Adapter<CardViewContentAdapter.CardViewViewHolder>{
    private ArrayList<Content> listContent;
    public CardViewContentAdapter(ArrayList<Content> list) {
        this.listContent = list;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_content, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {

        Content content = listContent.get(position);
        Glide.with(holder.itemView.getContext())
                .load(content.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.tvName.setText(content.getName());
        holder.tvType.setText(content.getType());
        holder.tvComplexity.setText(content.getComplexity());
        holder.tvDetail.setText(content.getDetail());


        final String name = content.getName();
        final String type = content.getType();
        final String complexity = content.getComplexity();
        final String detail = content.getDetail();
        final int photo = content.getPhoto();

        holder.btnbacadetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveIntent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                moveIntent.putExtra(DetailActivity.EXTRA_NAME, name);
                moveIntent.putExtra(DetailActivity.EXTRA_TYPE, type);
                moveIntent.putExtra(DetailActivity.EXTRA_COMPLEXITY, complexity);
                moveIntent.putExtra(DetailActivity.EXTRA_DETAIL, detail);
                moveIntent.putExtra("int", photo);
                holder.itemView.getContext().startActivity(moveIntent);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "Kamu memilih " + listContent.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listContent.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvType, tvComplexity, tvDetail;

        Button btnbacadetail;
        public CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvType = itemView.findViewById(R.id.tv_item_type);
            tvComplexity = itemView.findViewById(R.id.tv_item_complexity);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            btnbacadetail = itemView.findViewById(R.id.btn_baca_detail);
        }
    }
}