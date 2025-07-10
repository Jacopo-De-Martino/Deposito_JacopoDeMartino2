![alt text](image.png)

# Observer

## Design Pattern Observer: Spiegazione Logica Semplice

Il Design Pattern Observer è un modo per organizzare la comunicazione tra oggetti nel software, in particolare quando un oggetto deve informare automaticamente altri oggetti dei suoi cambiamenti di stato.

In sintesi, la logica è questa:

Il Soggetto (cosa succede?): "Quando il mio stato cambia, non voglio che gli altri mi vengano a chiedere. Voglio essere io a dirglielo."

Gli Osservatori (cosa devono fare?): "Io sono interessato a ciò che succede al Soggetto. Mi iscrivo per ricevere un avviso, e quando lo ricevo, faccio la mia parte."

Vantaggi chiave di questa logica:

Disaccoppiamento (Meno dipendenza): Il Soggetto non ha bisogno di sapere nulla sugli Osservatori specifici (come sono fatti o cosa faranno). Semplicemente li notifica. E gli Osservatori non hanno bisogno di conoscere i dettagli interni del Soggetto, solo che esiste e li avviserà. Questo rende il codice più flessibile e facile da modificare.

Modularità: Puoi aggiungere o rimuovere Osservatori in qualsiasi momento senza toccare il codice del Soggetto. Questo rende il sistema più facile da estendere.

## Comunicazione efficiente: La notifica avviene solo quando c'è un cambiamento reale, evitando inutili controlli continui.

## Punti chiave del design Pattern Observer

- Definisce come un gruppo di oggetti(observer->osservatori) interagisce in base ai cambiamenti nello stato di subject

- Gli observer(osservatore) reagiscono automaticamente ai cambiamenti di stato del subject(osservato).

- il subject non ha bisogno di conoscere le classi specifiche dei suoi observer possono essere aggiunti o rimossi facilmente senza impattare la logica del subject
