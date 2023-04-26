package com.example.examendispmoviles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.examendispmoviles.Modelo.Datos;
import com.example.examendispmoviles.databinding.ActivityEstadoMcBinding;

public class EstadoMC extends AppCompatActivity {

    private ActivityEstadoMcBinding binding;
    private EstadoMCViewModel ViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEstadoMcBinding.inflate(getLayoutInflater());
        ViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(EstadoMCViewModel.class);

        Bundle bndl = getIntent().getBundleExtra("data");
        //llenar los campos con los valores
        ViewModel.cargaDatos((Datos) bndl.getSerializable("datos"),bndl.getString("mc"));

        //listener para los cambios en los parametros
        ViewModel.getMutableDatos().observe(this, new Observer<Datos>() {
            @Override
            public void onChanged(Datos datos) {
                binding.tvAltura.setText(datos.getAltura());
                binding.tvEdad.setText(datos.getEdad());
                binding.tvNombre.setText(datos.getNombre());
                binding.tvPeso.setText(datos.getPeso());
                binding.tvSexo.setText(datos.getSexo());
            }
        });

        ViewModel.getMutableMC().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String mc) {
                binding.tvMC.setText(mc);
            }
        });
        setContentView(binding.getRoot());
    }
}