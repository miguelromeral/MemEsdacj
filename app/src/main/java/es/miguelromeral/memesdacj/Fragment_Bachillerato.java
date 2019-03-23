package es.miguelromeral.memesdacj;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * Clase para crear el fragment Bachillerato.
 */
public class Fragment_Bachillerato extends Fragment {

    /**
     * Nombre de las imágenes que este fragment muestra.
     */
    public static final String IMAGE_BACHILLERATO_1 = "bachillerato1.jpg";
    public static final String IMAGE_BACHILLERATO_2 = "bachillerato2.jpg";
    public static final String IMAGE_BACHILLERATO_3 = "bachillerato3.jpg";
    public static final String IMAGE_BACHILLERATO_4 = "bachillerato4.png";
    public static final String IMAGE_BACHILLERATO_5 = "bachillerato5.jpg";

    /**
     * Creamos la vista sustituyendo el fragment actual por el nuevo. Además, cambiamos la Tittle Bar.
     * @param inflater LayoutInflater
     * @param container Contenedor de las vistas principal.
     * @param savedInstanceState Datos de la aplicación.
     * @return Nueva vista creada.
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Set title bar
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.navigation_bachillerato));

        return inflater.inflate(R.layout.fragment_bachillerato, container, false);
    }


    /**
     * Cargamos las imágenes del fragment cuando se haya creado la vista (no antes).
     * @param view Vista principal.
     * @param savedInstanceState Datos de la instancia.
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ((ImageView) getActivity().findViewById(R.id.iv_bachillerato1)).setImageDrawable(
                ((MainActivity) getActivity()).resizeImage(R.drawable.bachillerato1));
        ((ImageView) getActivity().findViewById(R.id.iv_bachillerato2)).setImageDrawable(
                ((MainActivity) getActivity()).resizeImage(R.drawable.bachillerato2));
        ((ImageView) getActivity().findViewById(R.id.iv_bachillerato3)).setImageDrawable(
                ((MainActivity) getActivity()).resizeImage(R.drawable.bachillerato3));
        ((ImageView) getActivity().findViewById(R.id.iv_bachillerato4)).setImageDrawable(
                ((MainActivity) getActivity()).resizeImage(R.drawable.bachillerato4));
        ((ImageView) getActivity().findViewById(R.id.iv_bachillerato5)).setImageDrawable(
                ((MainActivity) getActivity()).resizeImage(R.drawable.bachillerato5));

    }
}
