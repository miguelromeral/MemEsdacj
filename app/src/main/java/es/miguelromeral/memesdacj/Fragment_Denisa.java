package es.miguelromeral.memesdacj;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Fragment_Denisa extends Fragment {

    public static final String IMAGE_DENISA_1 = "denisa1.jpg";
    public static final String IMAGE_DENISA_2 = "denisa2.jpg";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Set title bar
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.navigation_denisa));

        return inflater.inflate(R.layout.fragment_denisa, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView im = (ImageView) getActivity().findViewById(R.id.iv_denisa1);
        im.setImageDrawable(((MainActivity) getActivity()).resizeImage(R.drawable.denisa1));

        ImageView im2 = (ImageView) getActivity().findViewById(R.id.iv_denisa2);
        im2.setImageDrawable(((MainActivity) getActivity()).resizeImage(R.drawable.denisa2));

    }
}
