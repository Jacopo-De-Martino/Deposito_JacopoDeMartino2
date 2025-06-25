# ProvaWhile.java – Cicli `while` e `do while` in Java

Questo file illustra le basi dell'iterazione in Java utilizzando i cicli `while` e `do while`.

---

## 🔁 Il ciclo `while`

Il ciclo `while` esegue un blocco di istruzioni **finché** una condizione è vera. La condizione viene valutata **prima** dell'esecuzione del blocco.

### Sintassi

```java
while (condizione) {
    // istruzioni da eseguire
}

Esempio

     // Inizializzazione della variabile di controllo
        int i = 0;
        while (i < 5) {
            i++;
            System.out.println("Ciao " + i);
        }


Output
Valore di i: 0
Valore di i: 1
Valore di i: 2
Valore di i: 3
Valore di i: 4

Il ciclo do while
Il ciclo do while garantisce almeno un'esecuzione del blocco di codice perché la condizione viene valutata dopo l'esecuzione.

Sintassi

do {
    // istruzioni da eseguire
} while (condizione);
Esempio

int j = 0;
do {
    System.out.println("Valore di j: " + j);
    j++;
} while (j < 5);

Output
Valore di j: 0
Valore di j: 1
Valore di j: 2
Valore di j: 3
Valore di j: 4

Differenze tra while e do while
Caratteristica
Controllo della condizione while->	Prima del blocco	do while -> Dopo il blocco
Esecuzione garantita almeno una volta	while->❌ No	do while ->✅ Sì

📝 Conclusione
Utilizza il ciclo while quando vuoi che il codice venga eseguito solo se la condizione è vera fin dall’inizio. Usa do while quando hai bisogno che il blocco venga eseguito almeno una volta, indipendentemente dalla condizione iniziale.

```
