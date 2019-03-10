package es.miguelromeral.memesdacj;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Fragment_Tenis extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Set title bar
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.navigation_tenis));

        return inflater.inflate(R.layout.fragment_tenis, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView im = (ImageView) getActivity().findViewById(R.id.iv_tenis1);
        im.setImageDrawable(((MainActivity) getActivity()).resizeImage(R.drawable.tenis1));

        ImageView im2 = (ImageView) getActivity().findViewById(R.id.iv_tenis2);
        im2.setImageDrawable(((MainActivity) getActivity()).resizeImage(R.drawable.tenis2));

    }
}
