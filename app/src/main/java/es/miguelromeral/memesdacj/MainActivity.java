package es.miguelromeral.memesdacj;
import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import es.miguelromeral.memesdacj.utilities.CheckForSDCard;
import es.miguelromeral.memesdacj.utilities.UrlFinder;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
    EasyPermissions.PermissionCallbacks {

    private static final int WRITE_REQUEST_CODE = 300;
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String PREFERENCES_MAIN = "Preferencias";
    private static final String PREFERENCES_REANUDADO = "Preferencias_reanudado";
    private String url;
    private DrawerLayout drawer;
    // Indica si es la primera vez que se ejecuta la aplicación
    private boolean reanudado;


    private int imagenPulsada = 0;
    private static int MAX_CLICKS = 5;
    private static int WARNING_CLICKS = 2;
    private String imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Fragment_Home()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }


        if(new SimpleDateFormat("MM.dd").format(new Date()).equals("03.24")){
            new AlertDialog.Builder(this)
                    .setCancelable(false)
                    .setPositiveButton(R.string.tOk, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    })
                    .setMessage(R.string.wBirthday)
                    .show();
        }

        // Recuperamos los valores de la sesión
        try{
            SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCES_MAIN, Context.MODE_PRIVATE);
            reanudado = sharedPreferences.getBoolean(PREFERENCES_REANUDADO, false);
        }catch(Exception e){
            reanudado = false;
        }

        // Si es la primera vez que se ejecuta
        if(!reanudado){
            mostrarFelicitacion();
            mostrarInstrucciones();
        }
    }

    private void mostrarFelicitacion(){
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle(R.string.tFelicitacionTitulo)
                .setPositiveButton(R.string.tUnderstood, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                })
                .setMessage(R.string.tFelicitacionCuerpo)
                .show();
    }


    private void mostrarInstrucciones(){
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle(R.string.tInstruccionesTitulo)
                .setPositiveButton(R.string.tUnderstood, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                })
                .setMessage(R.string.tInstruccionesCuerpo)
                .show();
    }

    // Cuando se pare la ejecución, guardamos las preferencias del main.
    @Override
    public void onStop(){
        super.onStop();
        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCES_MAIN, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(PREFERENCES_REANUDADO, true);
        editor.commit();
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_Home()).commit();
                break;
            case R.id.nav_messenger:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_Messenger()).commit();
                break;
            case R.id.nav_hockey:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_Hockey()).commit();
                break;
            case R.id.nav_concierto:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_Concierto()).commit();
                break;
            case R.id.nav_slender:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_Slender()).commit();
                break;
            case R.id.nav_skating:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_Skating()).commit();
                break;
            case R.id.nav_conociendote:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_Conociendote()).commit();
                break;
            case R.id.nav_harlemshake:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_Harlemshake()).commit();
                break;
            case R.id.nav_futuro:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_Futuro()).commit();
                break;
            case R.id.nav_tenis:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_Tenis()).commit();
                break;
            case R.id.nav_favor:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_Favor()).commit();
                break;
            case R.id.nav_eso:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_Eso()).commit();
                break;
            case R.id.nav_bachillerato:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_Bachillerato()).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void actionImageClicks(String imagenNueva){
        if(imagen == imagenNueva){
            if (imagenPulsada == MAX_CLICKS) {

                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(UrlFinder.GetUrlVideo(imagenNueva)));
                startActivity(myIntent);

                imagenPulsada = 0;
                return;
            }
            if(imagenPulsada == WARNING_CLICKS)
                Toast.makeText(this, R.string.tKeepClicking, Toast.LENGTH_LONG).show();

            imagenPulsada++;

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    imagenPulsada = 0;
                }
            }, 3000);
        }else{
            imagen = imagenNueva;
            imagenPulsada = 1;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.actionbar_go_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_Home()).commit();
                break;
            case R.id.actionbar_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_About()).commit();
                break;
            case R.id.actionbar_spotify:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_Spotify()).commit();
                break;
            case R.id.actionbar_howto:
                mostrarInstrucciones();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }



    public Drawable resizeImage(int imageResource) {
        // R.drawable.large_image
        // Get device dimensions
        Display display = getWindowManager().getDefaultDisplay();
        double deviceWidth = display.getWidth();

        BitmapDrawable bd = (BitmapDrawable) this.getResources().getDrawable(
                imageResource);
        double imageHeight = bd.getBitmap().getHeight();
        double imageWidth = bd.getBitmap().getWidth();

        double ratio = deviceWidth / imageWidth;
        int newImageHeight = (int) (imageHeight * ratio);

        Bitmap bMap = BitmapFactory.decodeResource(getResources(), imageResource);
        Drawable drawable = new BitmapDrawable(this.getResources(),
                getResizedBitmap(bMap, newImageHeight, (int) deviceWidth));

        return drawable;
    }

    /************************ Resize Bitmap *********************************/
    public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) {

        int width = bm.getWidth();
        int height = bm.getHeight();

        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;

        // create a matrix for the manipulation
        Matrix matrix = new Matrix();

        // resize the bit map
        matrix.postScale(scaleWidth, scaleHeight);

        // recreate the new Bitmap
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height,
                matrix, false);

        return resizedBitmap;
    }


    /************************ BUTTON ACTIONS ******************************/

    public void downloadImageHome(View view){
        downloadContent(Fragment_Home.IMAGE_HOME);
    }
    public void downloadImageMessange(View view){ downloadContent(Fragment_Messenger.IMAGE_MESSENGER); }
    public void downloadImageHockey1(View view){ downloadContent(Fragment_Hockey.IMAGE_HOCKEY_1); }
    public void downloadImageHockey2(View view){ downloadContent(Fragment_Hockey.IMAGE_HOCKEY_2); }
    public void downloadImageConcierto1(View view){ downloadContent(Fragment_Concierto.IMAGE_CONCIERTO_1); }
    public void downloadImageConcierto2(View view){ downloadContent(Fragment_Concierto.IMAGE_CONCIERTO_2); }
    public void downloadImageEso1(View view){ downloadContent(Fragment_Eso.IMAGE_ESO_1); }
    public void downloadImageEso2(View view){ downloadContent(Fragment_Eso.IMAGE_ESO_2); }
    public void downloadImageEso3(View view){ downloadContent(Fragment_Eso.IMAGE_ESO_3); }
    public void downloadImageEso4(View view){ downloadContent(Fragment_Eso.IMAGE_ESO_4); }
    public void downloadImageBachillerato1(View view){ downloadContent(Fragment_Bachillerato.IMAGE_BACHILLERATO_1); }
    public void downloadImageBachillerato2(View view){ downloadContent(Fragment_Bachillerato.IMAGE_BACHILLERATO_2); }
    public void downloadImageBachillerato3(View view){ downloadContent(Fragment_Bachillerato.IMAGE_BACHILLERATO_3); }
    public void downloadImageBachillerato4(View view){ downloadContent(Fragment_Bachillerato.IMAGE_BACHILLERATO_4); }
    public void downloadImageBachillerato5(View view){ downloadContent(Fragment_Bachillerato.IMAGE_BACHILLERATO_5); }
    public void downloadImageConociendote1(View view){ downloadContent(Fragment_Conociendote.IMAGE_CONOCIENDOTE_1); }
    public void downloadImageConociendote2(View view){ downloadContent(Fragment_Conociendote.IMAGE_CONOCIENDOTE_2); }
    public void downloadImageConociendote3(View view){ downloadContent(Fragment_Conociendote.IMAGE_CONOCIENDOTE_3); }
    public void downloadImageConociendote4(View view){ downloadContent(Fragment_Conociendote.IMAGE_CONOCIENDOTE_4); }
    public void downloadImageFuturo(View view){ downloadContent(Fragment_Futuro.IMAGE_FUTURO); }
    public void downloadImageTenis1(View view){ downloadContent(Fragment_Tenis.IMAGE_TENIS_1); }
    public void downloadImageTenis2(View view){ downloadContent(Fragment_Tenis.IMAGE_TENIS_1); }
    public void openSpotify(View view){
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://open.spotify.com/user/miguelromeral/playlist/7EGfF9n2rlHq0Ymh7d6QWM?si=uQussHsgRvihBVdKx3NksA"));
        startActivity(myIntent);
    }
    public void downloadImageAbout(View view){ downloadContent(Fragment_About.IMAGE_ABOUT); }
    public void watchVideoSlender(View view){
        Intent i = new Intent(this, VideoActivity.class);
        i.putExtra(VideoActivity.PARAM_VIDEO_FILE, R.raw.slender);
        startActivity(i);
    }
    public void watchVideoSkate1(View view){
        Intent i = new Intent(this, VideoActivity.class);
        i.putExtra(VideoActivity.PARAM_VIDEO_FILE, R.raw.skate1);
        startActivity(i);
    }
    public void watchVideoSkate2(View view){
        Intent i = new Intent(this, VideoActivity.class);
        i.putExtra(VideoActivity.PARAM_VIDEO_FILE, R.raw.skate2);
        startActivity(i);
    }
    public void watchVideoHarlemshake(View view){
        Intent i = new Intent(this, VideoActivity.class);
        i.putExtra(VideoActivity.PARAM_VIDEO_FILE, R.raw.harlemshake);
        startActivity(i);
    }
    public void watchVideoFavor1(View view){
        Intent i = new Intent(this, VideoActivity.class);
        i.putExtra(VideoActivity.PARAM_VIDEO_FILE, R.raw.favor1);
        startActivity(i);
    }
    public void goTomasFalsas(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new Fragment_TomasFalsas()).commit();
    }
    public void watchVideoFavor2(View view){
        Intent i = new Intent(this, VideoActivity.class);
        i.putExtra(VideoActivity.PARAM_VIDEO_FILE, R.raw.favor2);
        startActivity(i);
    }
    public void watchVideoMessenger(View view){
        Intent i = new Intent(this, VideoActivity.class);
        i.putExtra(VideoActivity.PARAM_VIDEO_FILE, R.raw.messengerleague);
        startActivity(i);
    }


    /************************ DOWNLOAD FILES ******************************/

    public void downloadContent(String resource){
        //Check if SD card is present or not
        if (CheckForSDCard.isSDCardPresent()) {

            //check if app has permission to write to the external storage.
            if (EasyPermissions.hasPermissions(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                //Get the URL entered
                url = resource;
                new DownloadFile().execute(url);

            } else {
                //If permission is not present request for the same.
                EasyPermissions.requestPermissions(MainActivity.this, getString(R.string.wWritePermission), WRITE_REQUEST_CODE, Manifest.permission.READ_EXTERNAL_STORAGE);
            }


        } else {
            new AlertDialog.Builder(this)
                    .setCancelable(false)
                    .setPositiveButton(R.string.tOk, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                    })
                    .setMessage(R.string.tDownload_fail)
                    .show();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, MainActivity.this);
    }
    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        //Download the file once permission is granted
        new DownloadFile().execute(url);
    }
    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Log.d(TAG, "Permission has been denied");
    }
    /**
     * Async Task to download file from URL
     */
    private class DownloadFile extends AsyncTask<String, String, String> {

        private ProgressDialog progressDialog;
        private String fileName;
        private String folder;
        private boolean isDownloaded;

        /**
         * Before starting background thread
         * Show Progress Bar Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            this.progressDialog = new ProgressDialog(MainActivity.this);
            this.progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            this.progressDialog.setCancelable(false);
            this.progressDialog.show();
        }

        /**
         * Downloading file in background thread
         */
        @Override
        protected String doInBackground(String... f_url) {
            int count;
            try {
                String url = f_url[0];


                AssetManager assManager = getApplicationContext().getAssets();
                InputStream input = assManager.open(url);

                AssetFileDescriptor fd = getAssets().openFd(url);
                int lengthOfFile = (int) fd.getLength();

                //Extract file name from URL
                fileName = f_url[0].substring(f_url[0].lastIndexOf('/') + 1, f_url[0].length());


                //External directory path to save file
                folder = Environment.getExternalStorageDirectory() + File.separator + "Esteban/";

                //Create androiddeft folder if it does not exist
                File directory = new File(folder);

                if (!directory.exists()) {
                    directory.mkdirs();
                }

                // Output stream to write file
                OutputStream output = new FileOutputStream(folder + fileName);

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    // publishing the progress....
                    // After this onProgressUpdate will be called
                    publishProgress("" + (int) ((total * 100) / lengthOfFile));
                    Log.d(TAG, "Progress: " + (int) ((total * 100) / lengthOfFile));

                    // writing data to file
                    output.write(data, 0, count);
                }

                // flushing output
                output.flush();

                // closing streams
                output.close();
                input.close();
                return "Downloaded at: " + folder + fileName;

            } catch (Exception e) {
                e.printStackTrace();
                Log.e("Error: ", e.getMessage());
            }

            return getResources().getString(R.string.wFailDownload);
        }

        /**
         * Updating progress bar
         */
        protected void onProgressUpdate(String... progress) {
            // setting progress percentage
            progressDialog.setProgress(Integer.parseInt(progress[0]));
        }


        @Override
        protected void onPostExecute(String message) {
            // dismiss the dialog after the file was downloaded
            this.progressDialog.dismiss();

            // Display File path after downloading
            Toast.makeText(getApplicationContext(),
                    message, Toast.LENGTH_LONG).show();
        }
    }

}
