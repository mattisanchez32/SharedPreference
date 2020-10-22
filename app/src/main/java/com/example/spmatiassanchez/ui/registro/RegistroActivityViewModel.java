package com.example.spmatiassanchez.ui.registro;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.spmatiassanchez.model.Usuario;
import com.example.spmatiassanchez.request.ApiClient;

public class RegistroActivityViewModel extends AndroidViewModel {

    private MutableLiveData<Usuario> usuarioMutableLiveData;
    private ApiClient apiClient;
    private Context context;



    public RegistroActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }


    public LiveData<Usuario> getUsuarioLiveData(){
        if(usuarioMutableLiveData == null){
            usuarioMutableLiveData = new MutableLiveData<>();
        }
        return usuarioMutableLiveData;
    }

    public void guardar(Usuario user){
        //if(user != null){
            apiClient.guardar(context,user);
            Toast.makeText(getApplication(), "Datos guardados correctamente", Toast.LENGTH_LONG).show();
        //}
    }

    public void cargar(){
        Usuario user=apiClient.leer(context);
        if(user.getDni()!=-1){
            usuarioMutableLiveData.setValue(user);
        }
    }

}
