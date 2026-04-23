package com.example.starsgallery.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.starsgallery.R;
import com.example.starsgallery.beans.Star;

import java.util.ArrayList;
import java.util.List;

public class StarAdapter extends RecyclerView.Adapter<StarAdapter.StarViewHolder> implements Filterable {

    private List<Star> stars;
    private List<Star> starsFilter;
    private Context context;

    public StarAdapter(Context context, List<Star> stars) {
        this.context = context;
        this.stars = stars;
        this.starsFilter = new ArrayList<>(stars);
    }

    @NonNull
    @Override
    public StarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.star_item, parent, false);
        return new StarViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StarViewHolder holder, int position) {
        Star star = starsFilter.get(position);

        Glide.with(context)
                .asBitmap()
                .load(star.getImg())
                .apply(new RequestOptions().override(100, 100))
                .into(holder.img);

        holder.name.setText(star.getName());
        holder.stars.setRating(star.getStar());
        holder.idss.setText(String.valueOf(star.getId()));
    }

    @Override
    public int getItemCount() {
        return starsFilter.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                List<Star> filteredList = new ArrayList<>();

                if (constraint == null || constraint.length() == 0) {
                    filteredList.addAll(stars);
                } else {
                    String pattern = constraint.toString().toLowerCase().trim();

                    for (Star s : stars) {
                        if (s.getName().toLowerCase().contains(pattern)) {
                            filteredList.add(s);
                        }
                    }
                }

                FilterResults results = new FilterResults();
                results.values = filteredList;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                starsFilter.clear();
                starsFilter.addAll((List) results.values);
                notifyDataSetChanged();
            }
        };
    }

    public static class StarViewHolder extends RecyclerView.ViewHolder {

        TextView idss, name;
        ImageView img;
        RatingBar stars;

        public StarViewHolder(@NonNull View itemView) {
            super(itemView);

            // ⚠️ CES IDs DOIVENT EXISTER DANS star_item.xml
            idss = itemView.findViewById(R.id.ids);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            stars = itemView.findViewById(R.id.stars);
        }
    }
}