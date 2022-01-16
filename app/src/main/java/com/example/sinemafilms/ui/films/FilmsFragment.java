package com.example.sinemafilms.ui.films;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.sinemafilms.App;
import com.example.sinemafilms.R;
import com.example.sinemafilms.data.Films;
import com.example.sinemafilms.databinding.FragmentFilmsBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FilmsFragment extends Fragment {
    private FragmentFilmsBinding binding;
    private AdapterFilms adapter;


    public FilmsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new AdapterFilms();
        adapter.setOnClick(new AdapterFilms.OnClick() {
            @Override
            public void onClik(Films films) {
                Bundle bundle = new Bundle();
                bundle.putString("keyofid",films.getId());
                NavController navController = Navigation.findNavController(requireActivity(),R.id.nav_host_fragment);
                navController.navigate(R.id.infoFragment,bundle);
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmsBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.reycycler.setAdapter(adapter);

        fethFilms();
    }

    private void fethFilms() {
        App.api.getFilms().enqueue(new Callback<List<Films>>() {
            @Override
            public void onResponse(Call<List<Films>> call, Response<List<Films>> response) {
                if (response.isSuccessful() && response.body() != null){
                    adapter.setFilms(response.body());
                }
                else {
                    Log.e("TAG", "onResponse: "+ response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Films>> call, Throwable t) {
                Log.e("TAG", "onFailure: " + t.getLocalizedMessage() );

            }
        });
    }
}