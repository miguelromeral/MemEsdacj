package es.miguelromeral.memesdacj.utilities;
import es.miguelromeral.memesdacj.*;

/**
 * Created by miguelangel.garciar on 15/03/2019.
 */

public class UrlFinder {

    public static String GetUrlVideo(String imagen){
        switch(imagen){
            case Fragment_About.IMAGE_ABOUT:
                return "";
            default:
                return null;
        }
    }
}
