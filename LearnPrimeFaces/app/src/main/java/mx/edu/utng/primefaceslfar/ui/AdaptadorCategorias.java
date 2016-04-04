package mx.edu.utng.primefaceslfar.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import mx.edu.utng.primefaceslfar.R;
import mx.edu.utng.primefaceslfar.modelo.Prime;

/**
 * Luis Arevalo
 * Adaptador para listas de prime usadas en la sección
 */
public class AdaptadorCategorias
        extends RecyclerView.Adapter<AdaptadorCategorias.ViewHolder> {


    private final List<Prime> items;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView nombre;
       // public TextView precio;
        public ImageView imagen;

        public ViewHolder(View v) {
            super(v);

            nombre = (TextView) v.findViewById(R.id.nombre_prime);
         //   precio = (TextView) v.findViewById(R.id.);
            imagen = (ImageView) v.findViewById(R.id.miniatura_prime);
        }
    }


    public AdaptadorCategorias(List<Prime> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_lista_categorias, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Prime item = items.get(i);

        Glide.with(viewHolder.itemView.getContext())
                .load(item.getIdDrawable())
                .centerCrop()
                .into(viewHolder.imagen);
        viewHolder.nombre.setText(item.getNombre());
//        viewHolder.precio.setText("$" + item.getPrecio());

    }


}