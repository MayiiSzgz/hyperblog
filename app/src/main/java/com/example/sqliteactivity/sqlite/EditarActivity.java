package com.example.sqliteactivity.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sqliteactivity.R;
import com.example.sqliteactivity.databinding.ActivityEditarBinding;
import com.example.sqliteactivity.sqlite.db.DbContactos;
import com.example.sqliteactivity.sqlite.modelo.Contacto;

public class EditarActivity extends AppCompatActivity {
    ActivityEditarBinding activityEditarBinding;
    int id = 0;
    Contacto contacto;
    boolean seActualizoCorrectamente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityEditarBinding = ActivityEditarBinding.inflate(getLayoutInflater());
        setContentView(activityEditarBinding.getRoot());

        if(savedInstanceState == null){
            Bundle bundle = getIntent().getExtras();

            if(bundle == null){
                id = Integer.parseInt(null);
            }else{
                id = bundle.getInt("ID");
            }

        }else{
            id = (int) savedInstanceState.getSerializable("ID");
        }

        DbContactos dbContactos = new DbContactos(EditarActivity.this);
        contacto = dbContactos.obtenerContactoPorId(id);

        if(contacto != null){
            activityEditarBinding.txtNombre.setText(contacto.getNombre());
            activityEditarBinding.txtCorreoElectronico.setText(contacto.getCorreo_electronico());
            activityEditarBinding.txtTelefono.setText(contacto.getTelefono());
            //evitando que salga el teclado

        }

        activityEditarBinding.btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!activityEditarBinding.txtNombre.getText().toString().equals("")
                        && !activityEditarBinding.txtCorreoElectronico.getText().toString().equals("")
                        && !activityEditarBinding.txtTelefono.getText().toString().equals("")){

                    seActualizoCorrectamente = dbContactos.actualizarContacto(id,
                            activityEditarBinding.txtNombre.getText().toString(),
                            activityEditarBinding.txtTelefono.getText().toString(),
                            activityEditarBinding.txtCorreoElectronico.getText().toString());
                    if(seActualizoCorrectamente){
                        verRegistro();
                        Toast.makeText(EditarActivity.this, "registro actualizado", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(EditarActivity.this, "error al actualizar registro", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(EditarActivity.this, "Debes llenar los campos obligatorios", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void verRegistro()
    {
        Intent intent = new Intent(this, ConsultaActivity.class);
        intent.putExtra("ID", id);
        startActivity(intent);
    }
}