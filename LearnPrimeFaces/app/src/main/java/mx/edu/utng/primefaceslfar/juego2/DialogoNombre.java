package mx.edu.utng.primefaceslfar.juego2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import mx.edu.utng.primefaceslfar.R;

public class DialogoNombre extends DialogFragment {
		private static MainActivity context;
	
	static DialogoNombre newInstance(int puntos, int eliminados, long fecha, Context context){
		DialogoNombre.context = (MainActivity) context;
		DialogoNombre dialogo = new DialogoNombre();
		Bundle args = new Bundle();
        args.putInt("puntos", puntos);
        args.putInt("eliminados", eliminados);
        args.putLong("fecha", fecha);
        
        dialogo.setArguments(args);
        
		return dialogo;		
	}
	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
		final int puntos = getArguments().getInt("puntos");
		final int eliminados = getArguments().getInt("eliminados");
		final Long fecha = getArguments().getLong("fecha");
		setCancelable(false);
		LayoutInflater inflater = getActivity().getLayoutInflater();
	
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View v = (View)inflater.inflate(R.layout.dialogo_introduce_nombre, null);
        builder.setView(v);
        final EditText et = (EditText)v.findViewById(R.id.dialogo_et);
               builder.setPositiveButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   String nombre = et.getText().toString();
                	   MainActivity.almacen.guardarPuntuacion(puntos, eliminados, nombre,
           					fecha);
                	   DialogoNombre.context.lanzarPuntuaciones(null);
                   }
               });
        
        
        return builder.create();
    }

	@Override
    public void onStart()
    {
        super.onStart();
        Button pButton =  ((AlertDialog) getDialog()).getButton(DialogInterface.BUTTON_POSITIVE);

        pButton.setBackgroundColor(getResources().getColor(R.color.fondo_puntuaciones));
    }
}
