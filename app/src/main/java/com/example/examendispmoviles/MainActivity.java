package com.example.examendispmoviles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.example.examendispmoviles.Modelo.Datos;
import com.example.examendispmoviles.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel ViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        ViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);

        setContentView(binding.getRoot());

        //observer del boolean validacion
        ViewModel.getMutableValidacion().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                binding.tvValidacion.setText("VALIDACION INCORRECTA, CORROBORE LOS DATOS INGRESADOS!");
            }
        });
        //listener del btn y los rb
        binding.rbM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewModel.setSexoM();
            }
        });
        binding.rbF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewModel.setSexoF();
            }
        });
        binding.rbO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewModel.setSexoO();
            }
        });

        binding.btVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //crear un obj datos
                Datos datos = new Datos(binding.etNombre.getText().toString(),
                                binding.etEdad.getText().toString(),
                                binding.etAltura.getText().toString(),
                                binding.etPeso.getText().toString(),
                            "sexo");
                //validar valores y pasar los datos a una nueva activity
                ViewModel.enviarDatos(datos);
            }
        });
    }
}