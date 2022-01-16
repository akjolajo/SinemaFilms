package com.example.sinemafilms.ui.films;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sinemafilms.data.Films;
import com.example.sinemafilms.databinding.ItemListFilmBinding;

import java.util.ArrayList;
import java.util.List;

public class AdapterFilms extends RecyclerView.Adapter<AdapterFilms.FilmsViewHolder> {
    private List<Films> films = new ArrayList<>();
    private OnClick onClick;

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    public void setFilms(List<Films> films) {
        this.films = films;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public FilmsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListFilmBinding binding = ItemListFilmBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false
        );
        return new FilmsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmsViewHolder holder, int position) {
        holder.onBind(films.get(position));
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    public class FilmsViewHolder extends RecyclerView.ViewHolder {
        private ItemListFilmBinding binding;

        public FilmsViewHolder(@NonNull ItemListFilmBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Films films) {
            binding.title.setText(films.getTitle());
            binding.description.setText(films.getDescription());
            Glide.with(binding.imageFilm).load(films.getImage()).into(binding.imageFilm);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClick.onClik(films);
                }
            });
        }
    }

    interface OnClick {
        void onClik(Films films);
    }
}
