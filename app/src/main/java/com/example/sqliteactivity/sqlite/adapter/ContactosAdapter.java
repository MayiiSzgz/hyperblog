package com.example.sqliteactivity.sqlite.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqliteactivity.R;
import com.example.sqliteactivity.sqlite.ConsultaActivity;
import com.example.sqliteactivity.sqlite.modelo.Contacto;

import java.util.ArrayList;

public class ContactosAdapter extends RecyclerView.Adapter<ContactosAdapter.ViewHolder>
{
    ArrayList <Contacto> listaContactos;

    public ContactosAdapter(ArrayList<Contacto> listaContactos)
    {
        this.listaContactos = listaContactos;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv_nombre, tv_numero, tv_email;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            tv_email = itemView.findViewById(R.id.tv_email);
            tv_numero = itemView.findViewById(R.id.tv_numero);
            tv_nombre = itemView.findViewById(R.id.tv_nombre);

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Intent intent = new Intent(itemView.getContext(), ConsultaActivity.class);
                    intent.putExtra("ID", listaContactos.get(getAdapterPosition()).getId());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
    @NonNull
    @Override
    public ContactosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.lista_item_contacto, parent, false);
        return new ContactosAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactosAdapter.ViewHolder holder, int position)
    {
        Contacto contactoActual = listaContactos.get(position);

        holder.tv_nombre.setText(contactoActual.getNombre());
        holder.tv_numero.setText(contactoActual.getTelefono());
        holder.tv_email.setText(contactoActual.getCorreo_electronico());

    }

    @Override
    public int getItemCount()
    {
        return listaContactos.size();
    }


}
