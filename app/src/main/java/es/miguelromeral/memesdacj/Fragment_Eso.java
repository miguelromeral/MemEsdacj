package es.miguelromeral.memesdacj;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Fragment_Eso extends Fragment {

    public static final String IMAGE_ESO_1 = "eso1.jpg";
    public static final String IMAGE_ESO_2 = "eso2.jpg";
    public static final String IMAGE_ESO_3 = "eso3.jpg";
    public static final String IMAGE_ESO_4 = "eso4.jpg";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Set title bar
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.navigation_eso));

        return inflater.inflate(R.layout.fragment_eso, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ((ImageView) getActivity().findViewById(R.id.iv_eso1)).setImageDrawable(
                ((MainActivity) getActivity()).resizeImage(R.drawable.eso1));
        ((ImageView) getActivity().findViewById(R.id.iv_eso2)).setImageDrawable(
                ((MainActivity) getActivity()).resizeImage(R.drawable.eso2));
        ((ImageView) getActivity().findViewById(R.id.iv_eso3)).setImageDrawable(
                ((MainActivity) getActivity()).resizeImage(R.drawable.eso3));
        ((ImageView) getActivity().findViewById(R.id.iv_eso4)).setImageDrawable(
                ((MainActivity) getActivity()).resizeImage(R.drawable.eso4));

    }
}
