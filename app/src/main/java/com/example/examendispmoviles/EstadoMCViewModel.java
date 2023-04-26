package com.example.examendispmoviles;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.examendispmoviles.Modelo.Datos;

public class EstadoMCViewModel extends AndroidViewModel {

    private MutableLiveData<String> mutableMC;
    private MutableLiveData<Datos> mutableDatos;

    public EstadoMCViewModel(@NonNull Application application) {
        super(application);
        mutableMC = new MutableLiveData<>();
        mutableDatos = new MutableLiveData<>();
        mutableMC.setValue("");
        mutableDatos.setValue(new Datos());
    }

    public LiveData<String> getMutableMC(){
        return mutableMC;
    }
    public LiveData<Datos> getMutableDatos(){
        return mutableDatos;
    }

    public void cargaDatos(Datos datos,String mc){
        mutableDatos.setValue(datos);
        mutableMC.setValue(mc);
    }
}
