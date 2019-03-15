package es.miguelromeral.memesdacj;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Fragment_Azuqueca extends Fragment {

    public static final String IMAGE_AZUQUECA_1 = "azuqueca1.jpg";
    public static final String IMAGE_AZUQUECA_2 = "azuqueca2.jpg";
    public static final String IMAGE_AZUQUECA_3 = "azuqueca3.jpg";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Set title bar
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.navigation_azuqueca));

        return inflater.inflate(R.layout.fragment_azuqueca, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView im = (ImageView) getActivity().findViewById(R.id.iv_azuqueca1);
        im.setImageDrawable(((MainActivity) getActivity()).resizeImage(R.drawable.azuqueca1));

        ImageView im2 = (ImageView) getActivity().findViewById(R.id.iv_azuqueca2);
        im2.setImageDrawable(((MainActivity) getActivity()).resizeImage(R.drawable.azuqueca2));

        ImageView im3 = (ImageView) getActivity().findViewById(R.id.iv_azuqueca3);
        im3.setImageDrawable(((MainActivity) getActivity()).resizeImage(R.drawable.azuqueca3));

    }
}
