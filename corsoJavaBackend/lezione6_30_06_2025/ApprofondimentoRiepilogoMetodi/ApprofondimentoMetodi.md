I metodi ricorsivi!
Un metodo ricorsivo richiama se stesso fino al raggiungimento di una condizione di chiusura (return)
es fattoriale:
int fattoriale(int n){
if(n== 1){rertun 1}
return n \* fattoriale(n-1);
}

---

🔁 Passaggio per valore vs. Passaggio per riferimento in Java
🧠 Concetto chiave
In Java tutto è passato per valore.

I tipi primitivi vengono passati come copia del valore

Gli oggetti e gli array vengono passati come copia del riferimento (non il valore dell’oggetto stesso!)

✅ Passaggio per valore (tipi primitivi)
Il metodo riceve una copia del valore → le modifiche non si riflettono all'esterno

java
Copia
Modifica
void modifica(int x) {
x = x + 10; // Modifica locale
}

public static void main(String[] args) {
int num = 5;
modifica(num);
System.out.println(num); // Output: 5 ❌ (non 15)
}
✅ Passaggio di riferimento (oggetti e array)
Viene passato il valore del riferimento, quindi il metodo può modificare il contenuto dell’oggetto o dell’array.

java
Copia
Modifica
void modifica(int[] arr) {
arr[0] = 99; // Modifica visibile
}

public static void main(String[] args) {
int[] numeri = {1, 2, 3};
modifica(numeri);
System.out.println(numeri[0]); // Output: 99 ✅
}
🔸 Attenzione: non puoi cambiare il riferimento stesso dall'interno del metodo.

java
Copia
Modifica
void cambia(int[] arr) {
arr = new int[] {9, 9, 9}; // Cambia solo la copia del riferimento
}

public static void main(String[] args) {
int[] numeri = {1, 2, 3};
cambia(numeri);
System.out.println(numeri[0]); // Output: 1 ❌
}

Modificatore Visibilità Dove è accessibile
public Totale Tutto il progetto
private Solo nella stessa classe Nascosto all’esterno
protected Classe + stesso package + sottoclassi Buono per ereditarietà
(default) Nessuna parola chiave (package-private) Solo all'interno dello stesso package

Tipo Passaggio Modificabile fuori? Puoi riassegnare?
int, double Valore (copia) ❌ No ❌ No
Array / Oggetti Riferimento (copia del puntatore) ✅ Sì (contenuto) ❌ No (riferimento)

final per i metodi rende i metodi COSTANTI o meglio non modificabili.

I Metodi sono funzioni legati una classe
se sono statici li possiamo usare senza l'oggetto ma direttamente dalla classe stessa
TIPI DI METODI

- metodi senza ritorno e senza parametri(Eseguono solo istruzioni)
- metodi con ritorno : restituiscono un valore
- metodi con parametri : ricevono input da usare
