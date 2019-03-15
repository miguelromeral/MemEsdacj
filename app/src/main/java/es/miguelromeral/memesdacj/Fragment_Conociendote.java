package es.miguelromeral.memesdacj;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Fragment_Conociendote extends Fragment {

    public static final String IMAGE_CONOCIENDOTE_1 = "conociendonos1.jpg";
    public static final String IMAGE_CONOCIENDOTE_2 = "conociendonos2.jpg";
    public static final String IMAGE_CONOCIENDOTE_3 = "conociendonos3.jpg";
    public static final String IMAGE_CONOCIENDOTE_4 = "conociendonos4.jpg";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Set title bar
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.navigation_conociendote));

        return inflater.inflate(R.layout.fragment_conociendote, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((ImageView) getActivity().findViewById(R.id.iv_Conociendote1)).setImageDrawable(
                ((MainActivity) getActivity()).resizeImage(R.drawable.conociendonos1));

        ((ImageView) getActivity().findViewById(R.id.iv_Conociendote2)).setImageDrawable(
                ((MainActivity) getActivity()).resizeImage(R.drawable.conociendonos2));

        ((ImageView) getActivity().findViewById(R.id.iv_Conociendote3)).setImageDrawable(
                ((MainActivity) getActivity()).resizeImage(R.drawable.conociendonos3));

        ((ImageView) getActivity().findViewById(R.id.iv_Conociendote4)).setImageDrawable(
                ((MainActivity) getActivity()).resizeImage(R.drawable.conociendonos4));


    }
}
