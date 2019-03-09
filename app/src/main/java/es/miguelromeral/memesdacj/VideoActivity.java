package es.miguelromeral.memesdacj;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

/**
 * Created by miguelangel.garciar on 08/03/2019.
 */

public class VideoActivity extends AppCompatActivity {

    private VideoView myVideoView;
    private int position = 0;
    private ProgressDialog progressDialog;
    private MediaController mediaControls;

    public static String PARAM_VIDEO_FILE = "VIDEO_URI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_video);

        //set the media controller buttons
        if (mediaControls == null) {
            mediaControls = new MediaController(VideoActivity.this);
        }

        //initialize the VideoView
        myVideoView = (VideoView) findViewById(R.id.video_view);

        // create a progress bar while the video file is loading
        progressDialog = new ProgressDialog(VideoActivity.this);
        // set a title for the progress bar
        progressDialog.setTitle(getResources().getString(R.string.wVideoLoadingTitle));
        // set a message for the progress bar
        progressDialog.setMessage(getResources().getString(R.string.wVideoLoading));
        //set the progress bar not cancelable on users' touch
        progressDialog.setCancelable(false);
        // show the progress bar
        progressDialog.show();

        try {
            //set the media controller in the VideoView
            myVideoView.setMediaController(mediaControls);

            // Video to play:
            int uri = getIntent().getIntExtra(PARAM_VIDEO_FILE, -1);


            if(uri == -1){
                throw new Exception("-sadasddsgageeg-");
            }

            myVideoView.setVisibility(View.VISIBLE);
            //set the uri of the video to be played
            myVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + uri));



        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        myVideoView.requestFocus();
        //we also set an setOnPreparedListener in order to know when the video file is ready for playback
        myVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mediaPlayer) {
                // close the progress bar and play the video
                progressDialog.dismiss();
                //if we have a position on savedInstanceState, the video playback should start from here
                myVideoView.seekTo(position);
                if (position == 0) {
                    myVideoView.start();
                } else {
                    //if we come from a resumed activity, video playback will be paused
                    myVideoView.pause();
                }
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        //we use onSaveInstanceState in order to store the video playback position for orientation change
        savedInstanceState.putInt("Position", myVideoView.getCurrentPosition());
        myVideoView.pause();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //we use onRestoreInstanceState in order to play the video playback from the stored position
        position = savedInstanceState.getInt("Position");
        myVideoView.seekTo(position);
    }

}
