package corsoJavaBackend.lezione12_08_07_2025.EserciziDecorator;

//Interfaccia/ Tipo funzionale che ci permette di lavorarare su oggetti a livello paritario distacco da : /principio di ereditarietà legame stretto/
interface Messaggio {
    String getContenuto();
}

// Classe concreta Messaggio bene specializza il metodo getContenuto ritornando
// una string "Messaggio base"
class MessaggioBase implements Messaggio {
    @Override
    public String getContenuto() {
        return "Messaggio base";
    }
}