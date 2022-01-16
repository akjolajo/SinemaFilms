package com.example.sinemafilms.ui.film_detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.sinemafilms.App;
import com.example.sinemafilms.data.Films;
import com.example.sinemafilms.databinding.FragmentFilmdetileBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmDetailFragment extends Fragment {
    private FragmentFilmdetileBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFilmdetileBinding.inflate(inflater, container , false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gatherinfo();

        String id = requireArguments().getString("keyofid");
        App.api.grtfilmbyId(id).enqueue(new Callback<Films>() {
            @Override
            public void onResponse(Call<Films> call, Response<Films> response) {
                if (response.isSuccessful() && response.body() != null){
                    Films films = response.body();
                    binding.id.setText(films.getId());
                    binding.titleInfo.setText(films.getTitle());
                    Glide.with(requireActivity()).load(films.getImage()).into(binding.imageSinema);
                }
            }
            @Override
            public void onFailure(Call<Films> call, Throwable t) {

            }
        });
    }

    private void gatherinfo() {



    }
}
