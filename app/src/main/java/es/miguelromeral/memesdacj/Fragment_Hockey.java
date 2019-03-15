package es.miguelromeral.memesdacj;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class Fragment_Hockey extends Fragment {

    public static final String IMAGE_HOCKEY_1 = "hockey1.jpg";
    public static final String IMAGE_HOCKEY_2 = "hockey2.jpg";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Set title bar
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.navigation_hockey));

        return inflater.inflate(R.layout.fragment_hockey, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView im = (ImageView) getActivity().findViewById(R.id.iv_hockey1);
        im.setImageDrawable(((MainActivity) getActivity()).resizeImage(R.drawable.hockey1));

        ImageView im2 = (ImageView) getActivity().findViewById(R.id.iv_hockey2);
        im2.setImageDrawable(((MainActivity) getActivity()).resizeImage(R.drawable.hockey2));

    }
}
