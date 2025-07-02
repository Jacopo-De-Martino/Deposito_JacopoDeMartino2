package corsoJavaBackend.Lezione8_02_2027.EserciziEreditarieta;

import java.util.ArrayList;

//Classe padre
class Camera {
    protected int nCamera; // identificativo camera
    protected float prezzo; // prezzo
    // super costruttore

    public Camera(int nCamerai, float prezzoi) {
        this.nCamera = nCamerai;
        this.prezzo = prezzoi;
    }

    // super metodo info
    public void info() {
        System.out.println("Camera : " + nCamera + " Prezzo : " + prezzo);
    }

    // super metodo info overraidato
    public void info(boolean prezzo) {
        if (prezzo) {
            this.info();
        } else {
            System.out.println("Camera : " + nCamera);
        }
    }
}

// Classe figlia di Camera <- Suite
class Suite extends Camera {
    private String serviziExtra; // attributo privato proprietario della classe Suite

    public Suite(int nCamerai, float prezzoi, String serviziExtrai) {
        super(nCamerai, prezzoi);
        this.serviziExtra = serviziExtrai;
    }

    @Override
    public void info() {
        System.out.println("Suite : " + nCamera + " Prezzo : " + prezzo + " Servizi extra : " + serviziExtra);
    }

}

class Hotel {
    private String name;
    private ArrayList<Camera> listaCamere;
    static int counterSuite = 0;
    static int counterCamere = 0;

    private void aggiungiCamera(Camera camera) {
        if (camera instanceof Suite) {
            counterSuite++;
        } else if (camera instanceof Camera) {
            counterCamere++;
        }
        listaCamere.add(camera);
    }

    static void stampaSuite() {
        System.out.println("Suite totali : " + counterSuite);
    }

}

public class GestoreHotel {
    public static void main(String[] args) {

    }
}
