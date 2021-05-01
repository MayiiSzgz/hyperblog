package com.example.sqliteactivity.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sqliteactivity.R;
import com.example.sqliteactivity.databinding.ActivityAgregandoDatosBinding;
import com.example.sqliteactivity.sqlite.db.DbContactos;

public class AgregandoDatosActivity extends AppCompatActivity {
    ActivityAgregandoDatosBinding activityAgregandoDatosBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAgregandoDatosBinding = ActivityAgregandoDatosBinding.inflate(getLayoutInflater());
        setContentView(activityAgregandoDatosBinding.getRoot());

        activityAgregandoDatosBinding.btnGuarda.setOnClickListener( new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                DbContactos dbContactos = new DbContactos(AgregandoDatosActivity.this);
                long id = dbContactos.insertarContacto(activityAgregandoDatosBinding.txtNombre.getText().toString(),
                                                    activityAgregandoDatosBinding.txtTelefono.getText().toString(),
                                                    activityAgregandoDatosBinding.txtCorreoElectronico.getText().toString());

                if(id>0)
                {
                    Toast.makeText(getApplicationContext(), "Registro guardado", Toast.LENGTH_SHORT).show();
                    limpiarETRegistro();
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Error al guardar el registro", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void limpiarETRegistro() {
    }
}