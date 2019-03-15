package es.miguelromeral.memesdacj;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Fragment_Messenger extends Fragment {

    public static final String IMAGE_MESSENGER = "messengerleague.jpg";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Set title bar
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.navigation_messenger));

        return inflater.inflate(R.layout.fragment_messenger, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ImageView im = (ImageView) getActivity().findViewById(R.id.iv_messenger);
        im.setImageDrawable(((MainActivity) getActivity()).resizeImage(R.drawable.messengerleague));

    }
}
