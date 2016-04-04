package mx.edu.utng.primefaceslfar.ui.a_tema_i;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mx.edu.utng.primefaceslfar.R;


/**
 * Fragmento para la pestaña "TARJETAS" de la sección "Mi Cuenta"
 */
public class FragmentoWebComponentesVideo extends Fragment {

    public FragmentoWebComponentesVideo() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragmento_web_componentes_video, container, false);
       /* VideoView video = (VideoView)v.findViewById(R.id.video);
        video.setVideoPath(
                "http://primefacesapplfar.hol.es/videos/primefaces_introduccion.mp4");
        MediaController mc= new MediaController(getContext());
        mc.setAnchorView(video);
        mc.setMediaPlayer(video);
        video.setMediaController(mc);*/



                return v;



    }


}
