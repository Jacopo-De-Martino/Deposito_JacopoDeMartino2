package corsoJavaBackend.lezione12_08_07_2025.Esericizi.EsercizioFacile;

public class MainNotificheStazioneMeteo {
    public static void main(String[] args) {
        // Oggetto StazioneMeteo
        StazioneMeteo stazioneMeteo = new StazioneMeteo("Mia Stazione");
        // Oggetti di tipo Display(observer)
        Display display1 = new TempDisplay("Display 1");
        Display display2 = new TempDisplay("Display 2");
        // Aggiungo un observer
        stazioneMeteo.registerDisplay(display1);
        // setto la temperatura e catturo la modifica
        stazioneMeteo.setTemp(20.40f);
        // rimuovo l'observer
        stazioneMeteo.removeDisplay(display1);
        // aggiungo un altro observer
        stazioneMeteo.registerDisplay(display2); // lo registro
        stazioneMeteo.setNome("Test Observer"); // setto il nome e intercetto la modifica
        stazioneMeteo.setTemp(40.40f);
    }

}
