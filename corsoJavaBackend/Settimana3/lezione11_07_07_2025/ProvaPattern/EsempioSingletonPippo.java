// package corsoJavaBackend.lezione11_07_07_2025.ProvaPattern;

// // Definizione della classe Singleton
// class Singleton {
// // Istanza privata statica della classe Singleton
// private static Singleton instance;

// // Costruttore privato per impedire l'istanziazione diretta
// private Singleton() {
// // Inizializza l'istanza con un oggetto Pippo
// System.out.println("Singleton instance created");
// }

// // Metodo pubblico statico per ottenere l'unica istanza della classe
// public static Singleton getInstance() {
// // Se l'istanza non esiste, viene creata
// if (instance == null) {
// instance = new Singleton();
// }
// // Restituisce l'istanza esistente o appena creata
// return instance;
// }

// // Metodo di esempio che può essere chiamato sull'istanza Singleton
// public void DoSomething() {
// System.out.println("Singleton: DoSomething() called");
// }
// }

// // La classe Pippo diventa un Singleton
// class Pippo {
// // 1. Istanza privata statica della classe Pippo.
// // Sarà l'unica istanza di Pippo che esisterà.
// private static Pippo instance;

// private String nome;
// private int eta;

// // 2. Costruttore privato.
// // Impedisce la creazione diretta di oggetti Pippo da fuori (es. new
// // Pippo("Pluto", 5)).
// private Pippo(String nome, int eta) {
// this.nome = nome;
// this.eta = eta;
// // Messaggio di debug per mostrare quando l'istanza viene effettivamente
// creata.
// System.out.println("Pippo instance created with name: " + nome + ", age: " +
// eta);
// }

// // 3. Metodo pubblico statico per ottenere l'unica istanza di Pippo.
// public static Pippo getInstance() {
// // Questa è la logica centrale del Singleton:
// // Se l'istanza non esiste ancora (è null), la crea.
// if (instance == null) {
// // Nota: qui si decide come inizializzare Pippo la prima volta.
// // Spesso, un Singleton non prende parametri nel costruttore pubblico,
// // o li prende da configurazioni globali. Se li prendesse qui,
// // il primo caller definirebbe nome ed età per tutte le volte successive.
// // Per questo esempio, li passiamo direttamente.
// instance = new Pippo("Pippo-Singleton", 30); // Esempio di inizializzazione
// }
// // Restituisce l'istanza esistente o appena creata.
// return instance;
// }

// // Metodi di esempio della classe Pippo
// public void salta() {
// System.out.println(nome + " salta!");
// }

// public void dormi() {
// System.out.println(nome + " dorme.");
// }

// public String getNome() {
// return nome;
// }

// public int getEta() {
// return eta;
// }
// }

// // Classe principale per testare il Singleton Pippo
// public class EsempioSingletonPippo {

// public static void main(String[] args) {
// // Tentativo 1 di ottenere l'istanza di Pippo
// System.out.println("--- Primo tentativo di ottenere Pippo ---");
// Pippo pippo1 = Pippo.getInstance(); // La prima volta, il costruttore privato
// verrà chiamato
// Singleton singleton = Singleton.getInstance(); // Otteniamo l'istanza del
// Singleton
// singleton.DoSomething(); // Chiamiamo un metodo del Singleton
// pippo1.salta();
// System.out.println("Nome di pippo1: " + pippo1.getNome());

// System.out.println("\n--- Secondo tentativo di ottenere Pippo ---");
// // Tentativo 2 di ottenere l'istanza di Pippo
// Pippo pippo2 = Pippo.getInstance(); // Questa volta, l'istanza non verrà
// creata di nuovo
// pippo2.dormi();
// System.out.println("Nome di pippo2: " + pippo2.getNome());

// System.out.println("\n--- Verifica che siano la stessa istanza ---");
// // Verifichiamo che pippo1 e pippo2 siano lo stesso oggetto in memoria
// if (pippo1 == pippo2) {
// System.out.println("pippo1 e pippo2 puntano alla stessa istanza di Pippo (è
// un Singleton).");
// } else {
// System.out.println("Errore: pippo1 e pippo2 sono istanze diverse.");
// }

// // Se provassimo a fare:
// // Pippo pippo3 = new Pippo("Pluto", 5); // Questo darebbe errore di
// // compilazione
// // perché il costruttore è privato.
// }
// }