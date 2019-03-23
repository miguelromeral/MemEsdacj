package es.miguelromeral.memesdacj.utilities;

/**
 * Created by miguelangel.garciar on 09/03/2019.
 */

import android.os.Environment;

/**
 * Clase que comprueba si la SD está disponible
 */
public class CheckForSDCard {

    /**
     * Comprueba que la SD está disponible
     * @return true si se la SD está montada.
     */
    public static boolean isSDCardPresent() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }
}