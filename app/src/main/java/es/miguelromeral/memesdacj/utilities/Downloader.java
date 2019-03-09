package es.miguelromeral.memesdacj.utilities;

import android.os.Environment;
import android.util.Log;

import java.io.File;

/**
 * Created by miguelangel.garciar on 09/03/2019.
 */

public class Downloader {

    public static String IMAGES_DIRECTORY = "Esteban 23";

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

}
