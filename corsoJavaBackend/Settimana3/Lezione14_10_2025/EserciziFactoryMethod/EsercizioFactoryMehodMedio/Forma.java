package corsoJavaBackend.Lezione14_09_2025.EserciziFactoryMethod.EsercizioFactoryMehodMedio;

// --- Componente: Interfaccia di base per le forme ---
interface Forma {
    void disegna();// metodo disegna che verrà specializzato

    String ottieniDescrizione(); // metodo ottieni descrizione che verrà specializzato
}

// --- Componenti Concreti: Le implementazioni base delle forme ---
// Classe Cerchio implementa interfaccia Forma : void disegna(), String
// ottieniDescrizione()
class Cerchio implements Forma {
    @Override
    public void disegna() {// Specializzo il metodo disegna() per la classe Cerchio
        System.out.println("Disegno un Cerchio.");// corpo specializzato "base"
    }

    @Override
    public String ottieniDescrizione() {// Specializzo il metodo ottieniDescrizione() per la classe Cerchio
        return "Cerchio";// corpo specializzato "base"
    }
}

// Classe Quadrato implementa interfaccia Forma : void disegna(), String
// ottieniDescrizione()
class Quadrato implements Forma {
    @Override
    public void disegna() {// Specializzo il metodo disegna() per la classe Quadrato
        System.out.println("Disegno un Quadrato.");// corpo specializzato "base"
    }

    @Override
    public String ottieniDescrizione() {// Specializzo il metodo ottieniDescrizione() per la classe Quadrato
        return "Quadrato";// corpo specializzato "base"
    }
}
