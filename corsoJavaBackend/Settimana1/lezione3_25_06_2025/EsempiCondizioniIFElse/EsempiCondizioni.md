In questo file affrontiamo gli operatori condizionali e, in particolare, le strutture condizionali (if, else if, else, switch).

A cosa servono le strutture condizionali?
Le strutture condizionali servono a controllare il flusso di esecuzione del programma in base al risultato di una condizione logica, ovvero una espressione booleana (true o false).

In base a questa valutazione, il programma decide quale blocco di codice eseguire, rendendo possibile il concetto di scelta o ramificazione logica nel codice.

Caratteristiche principali
Le condizioni restituiscono sempre un valore booleano (true o false)

Consentono di eseguire porzioni diverse di codice in base ai dati e agli stati

Sono fondamentali per realizzare logiche decisionali

Strutture principali in Java

## if

if (condizione) {
// codice eseguito se la condizione è vera
}

## if-else

if (condizione) {
// esegue questo se condizione è vera
} else {
// altrimenti esegue questo
}

## if - else if - else

if (condizione1) {
// blocco 1
} else if (condizione2) {
// blocco 2
} else {
// blocco di default
}

## switch

switch (variabile) {
case valore1:
// codice
break;
case valore2:
// codice
break;
default:
// codice di default
}

## Esempio semplice

int numero = 5;

if (numero > 0) {
System.out.println("Il numero è positivo");
} else {
System.out.println("Il numero è zero o negativo");
}
