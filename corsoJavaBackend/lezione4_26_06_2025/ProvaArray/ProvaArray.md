## In questa senzione vediamo una struttura dati fondamentale in tutti i linguaggi di programmazione gli Array.

## In Java rispetto ad altri linguaggi gli Array sono di dimensione fissa. una volta effettuata l'inizializzazione o la vera e propria assegnazione la dimensione dell'array non può essere modificata

## Cosa sono e come funzionano gli Array?

Array in Java – Cosa sono e come funzionano
Definizione:
Un array è una struttura dati che consente di memorizzare una sequenza di elementi dello stesso tipo, accessibili tramite un indice numerico (che parte da 0).

## Dichiarazione e Inizializzazione di un Array

Solo dichiarazione:
int[] numeri; // dichiarazione
Allocazione memoria:
numeri = new int[5]; // array di 5 interi (tutti inizializzati a 0) 3. Dichiarazione + inizializzazione:
int[] numeri = {10, 20, 30, 40, 50};
Accesso agli elementi:
System.out.println(numeri[0]); // stampa: 10
numeri[2] = 99; // cambia il terzo (0 BASED) elemento in 99
