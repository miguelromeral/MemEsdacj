package es.miguelromeral.memesdacj;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;


public class Fragment_Favor extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Set title bar
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.navigation_favor));

        return inflater.inflate(R.layout.fragment_favor, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((ImageView) getActivity().findViewById(R.id.iv_elcansi)).setImageDrawable(
                ((MainActivity) getActivity()).resizeImage(R.drawable.elcansi));


        Toast.makeText(getActivity().getApplicationContext(),
                getResources().getString(R.string.wEspontaneo), Toast.LENGTH_SHORT).show();

    }
}
