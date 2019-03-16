package es.miguelromeral.memesdacj.utilities;
import es.miguelromeral.memesdacj.*;

/**
 * Created by miguelangel.garciar on 15/03/2019.
 */

public class UrlFinder {

    public static String GetUrlVideo(String imagen){
        switch(imagen){
            case Fragment_Azuqueca.IMAGE_AZUQUECA_1: // Abril / Cerral
                return "https://www.youtube.com/watch?v=Y2Zj84kNEKw";
            case Fragment_Azuqueca.IMAGE_AZUQUECA_2: // Eso dijo ella
                return "https://www.youtube.com/watch?v=LVIlGtXBqGA";
            case Fragment_Azuqueca.IMAGE_AZUQUECA_3: // Gatti Te voy a matar
                return "https://www.youtube.com/watch?v=aUJsld5bgD0";
            case Fragment_Denisa.IMAGE_DENISA_1: // Nyan Cat
                return "https://www.youtube.com/watch?v=wZZ7oFKsKzY";
            case Fragment_Denisa.IMAGE_DENISA_2: // Gangnam Style
                return "https://www.youtube.com/watch?v=9bZkp7q19f0";
            case Fragment_About.IMAGE_ABOUT: // Alonso nueces
                return "https://www.youtube.com/watch?v=oeJF55Qphdk";
            case Fragment_Bachillerato.IMAGE_BACHILLERATO_1: // Cansino histórico
                return "https://www.youtube.com/watch?v=3cRWxqRVsfk";
            case Fragment_Bachillerato.IMAGE_BACHILLERATO_2: // Lory Money - Ola k ase
                return "https://www.youtube.com/watch?v=cvyUG4ul_aE";
            case Fragment_Bachillerato.IMAGE_BACHILLERATO_3: // Sugus de piña
                return "https://www.youtube.com/watch?v=-eANTvS5XRA";
            case Fragment_Bachillerato.IMAGE_BACHILLERATO_4: // Crackovia - Se formo la coladera
                return "https://www.youtube.com/watch?v=jXwtboIOiRI";
            case Fragment_Bachillerato.IMAGE_BACHILLERATO_5:
                return "https://www.youtube.com/watch?v=jofNR_WkoCE // What does the fox says";
            case Fragment_Concierto.IMAGE_CONCIERTO_1: // Yisus chica
                return "https://twitter.com/yisucrist/status/1089300705956020225";
            case Fragment_Concierto.IMAGE_CONCIERTO_2: // ANHQV - Felicidad
                return "https://www.youtube.com/watch?v=Hy1RYeUBZho";
            case Fragment_Conociendote.IMAGE_CONOCIENDOTE_1: // Niño pulgares arriba
                return "https://www.youtube.com/watch?v=xz3PbpPR6DY";
            case Fragment_Conociendote.IMAGE_CONOCIENDOTE_2: // La mas chula de mostoles
                return "https://www.youtube.com/watch?v=QsS9avqTPWs";
            case Fragment_Conociendote.IMAGE_CONOCIENDOTE_3: // Cerdo Pato Plastico
                return "https://www.youtube.com/watch?v=dMVuD1JjLok";
            case Fragment_Conociendote.IMAGE_CONOCIENDOTE_4: // mami yo soy guapa?
                return "https://www.youtube.com/watch?v=Il6p2-40-F0";
            case Fragment_Eso.IMAGE_ESO_1: // Compra un cani
                return "https://www.youtube.com/watch?v=cz2kP1uxt4s";
            case Fragment_Eso.IMAGE_ESO_2: // Tha annoying orange
                return "https://www.youtube.com/watch?v=ZN5PoW7_kdA";
            case Fragment_Eso.IMAGE_ESO_3: // Ralph
                return "https://www.youtube.com/watch?v=t9sK3mD5kzc";
            case Fragment_Eso.IMAGE_ESO_4: // Inda shooting stars
                return "https://www.youtube.com/watch?v=gd2hOO-3PD0";
            case Fragment_Favor.IMAGE_FAVOR: // Ramon el vanidoso
                return "https://www.youtube.com/watch?v=t6PAe1ul10s";
            case Fragment_Futuro.IMAGE_FUTURO: // Trump New Rules
                return "https://www.youtube.com/watch?v=on9UFsxdC0Q";
            case Fragment_Hockey.IMAGE_HOCKEY_1: // Benzema Gelatina
                return "https://www.youtube.com/watch?v=JL91OskDHeY";
            case Fragment_Hockey.IMAGE_HOCKEY_2: // Es un genio!
                return "https://www.youtube.com/watch?v=SA2Sqwo1-xE";
            case Fragment_Home.IMAGE_HOME: // Pim pam trucu trucu Kirby
                return "https://www.youtube.com/watch?v=C5mhkYt2NWg";
            case Fragment_Messenger.IMAGE_MESSENGER: // Lamentabla
                return "https://www.youtube.com/watch?v=UjdldZnauMo";
            case Fragment_Tenis.IMAGE_TENIS_1: // Pajilleitor
                return "https://www.youtube.com/watch?v=FCXZ3Ta4h8I";
            case Fragment_Tenis.IMAGE_TENIS_2: // Bongo cat
                return "https://www.youtube.com/watch?v=yJ5YHdt2GIM ";
        }
        return "";
    }
}
