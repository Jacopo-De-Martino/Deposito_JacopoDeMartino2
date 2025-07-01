# L'incampsulamento 50% macchina 50% programmatore

## Cose è?

è assicurarsi che i dati sensibili siano nascosti agli utente, aiuta altre caratteristiche come l'oscuramento dei dati, l'isolamento e il disaccoppiamento funzionale. Abbassare il livello di rischio di intercettazione/hacking al minimo

disaccoppiamento funzionale è la capacità di dividere le parti del codice in base alla logica macchina e non solo a quella umana

Per poter raggiungere l'obbiettivo dell'incapsulamento , dobbiamo:

- dichiarare variabili/attributi di classe come PRIVATE(private).
- fornire metodi get e set pubblici per accedere e aggiornare il valore di una private variabile.

database->web->sistema->macchina

## Incampsulamento

il termine incapsulamento nei linguaggi OOP può essere riferito a due concetti, distinti ma collecati tra loro:

1. un meccanismo del linguaggio atto a limitare l'accesso diretto agli elementi dell'oggetto -> dall'esterno non puoi accedere all'oggetto
2. un costrutto del linguaggio che favorisce l'integrazione dei metodi proprio della classe all'interno della classe stessa -> dall'oggetto devi usare i suoi metodi per interagire con l'esterno

## Approfondimento tecnico

Le due definizioni a confronto:

## 1. "Limitare l'accesso diretto agli elementi dell'oggetto"

"Dall'esterno non puoi accedere all'oggetto"

Questa definizione enfatizza la protezione dei dati
Si riferisce all’uso dei modificatori di accesso (come private, protected, public) per nascondere gli attributi interni dell’oggetto e impedirne la modifica diretta da parte di codice esterno.

È il lato restrittivo/protettivo dell’incapsulamento.

Serve per impedire accessi non controllati e mantenere lo stato interno coerente.

Esempio in Java:

java
Copia
Modifica
class Persona {
private String nome; // non accessibile dall’esterno

}
Da fuori non puoi fare persona.nome, ma solo persona.getNome() → accesso controllato.

## 2. "Integrazione dei metodi propri della classe all'interno della classe stessa"

"Dall'oggetto devi usare i suoi metodi per interagire con l'esterno"

Questa definizione enfatizza l'autonomia e il controllo interno
Si riferisce al fatto che gli oggetti espongono un’interfaccia pubblica (i metodi) con cui interagire, nascondendo la logica interna.

È il lato astrattivo dell’incapsulamento.

Ogni oggetto decide da sé come gestire il proprio stato e come esporlo.

Esempio:
Un oggetto ContoBancario non permette a chi lo usa di modificare direttamente il saldo. Invece fornisce metodi come deposita() o preleva().
Chi usa l'oggetto non sa come il saldo viene aggiornato internamente, ma può usare i metodi per interagire correttamente.

---

# I modificatori di accesso

servono ad impostare il livello di accesso

- private
- public
- default

# I modificatori di non accesso

x classi

- final : la classe non può essere eredita da altre classi
- abstact : la classe non puo essere usata per creare oggetti
  x attributi metodi e construttori
- final : attributi e metodi non possono essere sovrascritti o modificati
- static : attributi e metodi che appartengono alla classe, piutto che ad un oggetto
- abstract : può essere usati solo da classi astratte , il metodo non ha corpo la sotto classe è obbligata ad implementarlo
- synchronized : metodi accessibili solo da un thread alla volta
- volatile : il valore di un attributo non è memorizzato nella cache thread-local, ed è sempre letto dalla "memoria principale"

## I modificatori di accesso o di visibilità

x le classi

- public : la classe è accessibile da qualsiasi altra classe
- default : la classe è accessibile solo dalle classi nello stesso pacchetto.

  x gli attributi

- public : il codice è accessibile per tutte le classi
- private : il codice è accessibile solo all'interno della classe dichiarata
- default : il codice è accessibile solo nello stesso pacchetto. Viene usato quando non si specifica un modificatore
- protected : il codice è accessibile nello stesso pacchetto e nelle stesse sottoclassi
