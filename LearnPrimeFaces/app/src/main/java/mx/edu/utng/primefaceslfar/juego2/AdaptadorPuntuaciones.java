package mx.edu.utng.primefaceslfar.juego2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Vector;

import mx.edu.utng.primefaceslfar.R;

public class AdaptadorPuntuaciones extends BaseAdapter {
	private final Activity actividad;
	private final Vector<String> lista;

	public AdaptadorPuntuaciones(Activity actividad, Vector<String> lista) {
		super();
		this.actividad = actividad;
		this.lista = lista;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder mViewHolder = null;

		if (convertView == null) {

			mViewHolder = new ViewHolder();

			LayoutInflater inflater = actividad.getLayoutInflater();
			convertView = inflater.inflate(
					R.layout.elemento_lista_puntuaciones, null, true);
			mViewHolder.puntuacion = (TextView) convertView
					.findViewById(R.id.puntuacion);
			mViewHolder.icono = (ImageView) convertView
					.findViewById(R.id.icono);
			
			mViewHolder.eliminados = (TextView)convertView.findViewById(R.id.eliminados);

			switch (Math.round((float) Math.random() * 7)) {
			case 0:
				mViewHolder.drawable = R.drawable.zb1;
				break;
			case 1:
				mViewHolder.drawable = R.drawable.zb2;
				break;
			case 2:
				mViewHolder.drawable = R.drawable.zb3;
				break;
			case 3:
				mViewHolder.drawable = R.drawable.zb4;
				break;
			case 4:
				mViewHolder.drawable = R.drawable.zb5;
				break;
			case 5:
				mViewHolder.drawable = R.drawable.zb6;
				break;
			case 6:
				mViewHolder.drawable = R.drawable.zb7;
				break;
			}
			convertView.setTag(mViewHolder);
		} else {
			mViewHolder = (ViewHolder) convertView.getTag();
		}
		String puntosNombre = lista.elementAt(position);
		String[] partes = puntosNombre.split(",");		
		
		mViewHolder.eliminados.setText(partes[2]);
		mViewHolder.puntuacion.setText(partes[0] + partes[1]);
		mViewHolder.icono.setImageResource(mViewHolder.drawable);
		return convertView;
	}

	public int getCount() {
		return lista.size();
	}

	public Object getItem(int arg0) {
		return lista.elementAt(arg0);
	}

	public long getItemId(int position) {
		return position;
	}

	static class ViewHolder {
		private TextView puntuacion;
		private TextView eliminados;
		private ImageView icono;
		private int drawable;
	}
}
