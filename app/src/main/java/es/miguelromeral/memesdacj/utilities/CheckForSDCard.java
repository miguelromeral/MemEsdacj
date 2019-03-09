package es.miguelromeral.memesdacj.utilities;

/**
 * Created by miguelangel.garciar on 09/03/2019.
 */

import android.os.Environment;

public class CheckForSDCard {
    //Method to Check If SD Card is mounted or not
    public static boolean isSDCardPresent() {
        if (Environment.getExternalStorageState().equals(

                Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }
}