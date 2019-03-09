package es.miguelromeral.memesdacj;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import es.miguelromeral.memesdacj.MainActivity;
import es.miguelromeral.memesdacj.R;


public class Fragment_Home extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Set title bar
        ((MainActivity) getActivity()).setActionBarTitle(getString(R.string.app_name));



        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ImageView im = (ImageView) getActivity().findViewById(R.id.iv_about);

   /*     im.setImageBitmap(MainActivity.decodeSampledBitmapFromResource(
                getResources(), R.drawable.about, im.getWidth(), im.getHeight()));

*/
        im.setImageDrawable(((MainActivity) getActivity()).resizeImage(R.drawable.about));

  //      im.setImageResource(R.drawable.dibujos);
    }
}
