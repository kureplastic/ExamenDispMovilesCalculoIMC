package com.example.examendispmoviles;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.examendispmoviles.Modelo.Datos;

import java.security.PrivilegedAction;

public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<Boolean> mutableValidacion;
    private String btSexo;
    private Context context;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        mutableValidacion = new MutableLiveData<>();
        btSexo = "";
    }

    public void setSexoM(){ btSexo = "Masculino";}
    public void setSexoF(){ btSexo = "Femenino";}
    public void setSexoO(){ btSexo = "Otro";}

    public LiveData<Boolean> getMutableValidacion(){
        return mutableValidacion;
    }

    private Boolean validarCampos(String altura, String peso){
        if(altura.equals("")|| peso.equals("") || btSexo.equals("")){
            mutableValidacion.setValue(false);
            return false;
        }
        return true;
    }

    private String calculoIMC(Datos datos){
        Double altura = Double.parseDouble(datos.getAltura());
        Double peso = Double.parseDouble(datos.getPeso());
        Double valor = (peso / (altura * altura));
        if(valor < 20){return "Bajo peso (~" + valor.intValue() + ")";}
        if(valor >= 20 && valor<= 25){return "Peso ideal (~" + valor.intValue() + ")";}
        return "Sobre Peso (~" + valor.intValue() + ")";
    }

    public void enviarDatos(Datos datos){
        if(validarCampos(datos.getAltura(),datos.getPeso())){
            datos.setSexo(btSexo);
            //Log.d("Datos","se van a enviar: " + datos.toString());
            Bundle bndl = new Bundle();
            bndl.putSerializable("datos",datos);
            String mc = calculoIMC(datos);
            //Log.d("Datos","mc es: " + mc);
            bndl.putString("mc",mc);

            Intent intent = new Intent(context,EstadoMC.class)
                    .putExtra("data",bndl)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

}
