package es.miguelromeral.memesdacj;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * Clase para crear el fragment Tenis.
 */
public class Fragment_Tenis extends Fragment {

    /**
     * Nombre de las imágenes que este fragment muestra.
     */
    public static final String IMAGE_TENIS_1 = "tenis1.jpg";
    public static final String IMAGE_TENIS_2 = "tenis2.jpg";

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
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.navigation_tenis));

        return inflater.inflate(R.layout.fragment_tenis, container, false);
    }


    /**
     * Cargamos las imágenes del fragment cuando se haya creado la vista (no antes).
     * @param view Vista principal.
     * @param savedInstanceState Datos de la instancia.
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView im = (ImageView) getActivity().findViewById(R.id.iv_tenis1);
        im.setImageDrawable(((MainActivity) getActivity()).resizeImage(R.drawable.tenis1));

        ImageView im2 = (ImageView) getActivity().findViewById(R.id.iv_tenis2);
        im2.setImageDrawable(((MainActivity) getActivity()).resizeImage(R.drawable.tenis2));

    }
}
