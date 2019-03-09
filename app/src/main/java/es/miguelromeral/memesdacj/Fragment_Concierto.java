package es.miguelromeral.memesdacj;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Fragment_Concierto extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Set title bar
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.navigation_concierto));

        return inflater.inflate(R.layout.fragment_concierto, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView im = (ImageView) getActivity().findViewById(R.id.iv_concierto1);
        im.setImageDrawable(((MainActivity) getActivity()).resizeImage(R.drawable.concierto1));

        ImageView im2 = (ImageView) getActivity().findViewById(R.id.iv_concierto2);
        im2.setImageDrawable(((MainActivity) getActivity()).resizeImage(R.drawable.concierto2));

    }
}
