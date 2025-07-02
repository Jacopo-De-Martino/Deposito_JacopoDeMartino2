Appunti: Ereditarietà (Programmazione Orientata agli Oggetti)
Concetti Fondamentali
Principio di Ereditarietà: Si basa sulla capacità di definire un legame di dipendenza gerarchico tra classi diverse.

Derivazione di Classe: Una classe "deriva" da un'altra se da essa "eredita" il comportamento e le caratteristiche.

Classi "Figlie" e "Padre":

La classe "figlia" è chiamata "classe derivata".

La classe "padre" è chiamata "classe base" (o "superclasse").

Ruolo della Classe Base: La classe base contiene il codice comune a tutte le classi che da essa derivano.

Ruolo della Classe Derivata: Ogni classe derivata rappresenta una specializzazione della superclasse, ma eredita in ogni caso dalla classe base i comportamenti in essa definiti.

Esempio Chiarificatore: Gerarchia Animale
Scopo: Rappresentare il genere animale definendo una struttura di classi equivalente.

Classe Base Principale: Nel diagramma, la classe base iniziale è "Animale", da cui tutte le altre classi derivano.

## @Override — Cos'è e a cosa serve

### Definizione

@Override è un'annotazione in Java che indica al compilatore che un metodo sta sovrascrivendo (override) un metodo definito in una classe padre (superclasse) o interfaccia.

### Perché usarla?

Verifica del compilatore: se il metodo non esiste nella superclasse o ha una firma diversa, il compilatore genera un errore.

Aiuta a evitare errori di battitura o confusione nella firma dei metodi.

Migliora la leggibilità del codice: chiarisce l’intenzione del programmatore.

### Differenza tra Override(Sovraccarico) e Overload

Differenza tra Override e Overload
Nel contesto della programmazione orientata agli oggetti, Override e Overload sono due concetti fondamentali legati al polimorfismo, ma operano in modi distinti.

Riassunto dei Concetti Chiave
Override (Sovrascrittura):

Relazione: Tra classe base e classe derivata (ereditarietà).

Firma del Metodo: Stesso nome, stessi parametri, stesso tipo di ritorno.

Scopo: Ridefinire il comportamento ereditato.

Polimorfismo: Fase di Esecuzione (Runtime).

Esempio: Animal.makeSound() vs Dog.makeSound().

Overload (Sovraccarico):

Relazione: All'interno della stessa classe (o classi diverse).

Firma del Metodo: Stesso nome, ma parametri diversi (numero, tipo, ordine).

Scopo: Fornire diverse funzionalità con lo stesso nome.

Polimorfismo: Fase di Compilazione (Compile-time).

Esempio: add(int a, int b) vs add(double a, double b).
