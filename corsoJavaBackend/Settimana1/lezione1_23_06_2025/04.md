# Incapsulamento

Serve a nascondere i dati a l'interno del codice e dal codice stesso.
--> Gestione/modificatore di visibilità di dati
modificatori di accesso :
default
private
public
-->un costrutto del linguaggio che
favorisce l'integrazione dei metodi
propri della classe all'interno della
classe stessa

# Ereditarietà

la capacità di collegare gerarchicamente le classi tra loro
--> Contratti di funzionamento/legame tra i dati

# Polimorfismo

La capacità di un oggetto di assumere forme diverse, pur condividendo un’interfaccia comune.

# Astrazione

Fornire un'interfaccia chiara e semplice nascondendo i dettagli interni del funzionamento.

# Modificatori di accesso/visibilità

## Per le classi possiamo usare:

- Public: La classe è accessibile da qualsiasi altra classe
- Default: La classe è accessibile solo dalle classi nello stesso pacchetto. Questa viene usata quando non si specifica un modificatore.

## Per attributi, metodi e costruttori , puoi utilizzare uno dei seguenti:

- Public: Il codice è accessibile per tutte le classi
- Private: Il codice è accessibile solo all'interno della classe dichiarata
- Default: Il codice è accessibile solo nello stesso pacchetto. Viene usato quando non si specifica un modificatore.
- Protected: l codice è accessibile nello stesso pacchetto e nelle stesse sottoclassi.

# Modificatori non di accesso

## Per le classi , puoi utilizzare final o abstract:

final La classe non può essere ereditata da altre classi

astratto La classe non può essere usata per creare oggetti

## Per attributi, metodi e costruttori , puoi utilizzare uno dei seguenti:

- final: Attributi e metodi non possono essere sovrascritti/modificati

- static: Attributi e metodi che appartengono alla classe, piuttosto che ad un oggetto

- abstract: può essere usato solo in una classe astratta, e può essere usato solo su metodi. Il metodo non ha un corpo. Il corpo è fornito dalla sottoclasse (ereditata da).

- synchronized: Metodi accessibili solo da un thread alla volta

- volatile: Il valore di un attributo non è memorizzato nella cache thread-local, ed è sempre letto dalla "memoria principale"

# Perché l'incapsulamento?

- Migliore controllo degli attributi e dei metodi di classe

- Gli attributi di classe possono essere resi di sola lettura (se usi solo il get come metodo) o di sola scrittura (se usi solo il set come metodo)

- Flessibile: il programmatore può modificare una parte del codice senza influire sulle altre parti

- Maggiore sicurezza e mascheramento dei dati

public List<Aereo> filtraAereiPerPosti(int minPosti, int maxPosti) {
List<Aereo> aereiFiltrati = new ArrayList<>();
for (Aereo aereo : aerei) {
if (aereo.getNumeroPosti() >= minPosti && aereo.getNumeroPosti() <= maxPosti) {
aereiFiltrati.add(aereo);
}
}
return aereiFiltrati;
}

    public List<Pilota> filtraPilotiPerOreVolo(int minOre, int maxOre) {
        List<Pilota> pilotiFiltrati = new ArrayList<>();
        for (Pilota pilota : piloti) {
            if (pilota.getOreVolo() >= minOre && pilota.getOreVolo() <= maxOre) {
                pilotiFiltrati.add(pilota);
            }
        }
        return pilotiFiltrati;
    }

    public List<Aereo> filtraAereiPerModello(String modello) {
        List<Aereo> aereiFiltrati = new ArrayList<>();
        for (Aereo aereo : aerei) {
            if (aereo.getModello().equalsIgnoreCase(modello)) {
                aereiFiltrati.add(aereo);
            }
        }
        return aereiFiltrati;
    }

    public List<Pilota> filtraPilotiPerNome(String nome) {
        List<Pilota> pilotiFiltrati = new ArrayList<>();
        for (Pilota pilota : piloti) {
            if (pilota.getNome().equalsIgnoreCase(nome)) {
                pilotiFiltrati.add(pilota);
            }
        }
        return pilotiFiltrati;
    }

    public List<Aereo> filtraAereiPerCodiceIdentificativo(String codice) {
        List<Aereo> aereiFiltrati = new ArrayList<>();
        for (Aereo aereo : aerei) {
            if (aereo.getCodiceIdentificativo().equalsIgnoreCase(codice)) {
                aereiFiltrati.add(aereo);
            }
        }
        return aereiFiltrati;
    }

    public List<Pilota> filtraPilotiPerCodiceBrevettato(String codice) {
        List<Pilota> pilotiFiltrati = new ArrayList<>();
        for (Pilota pilota : piloti) {
            if (pilota.getNumeroBrevetto().equalsIgnoreCase(codice)) {
                pilotiFiltrati.add(pilota);
            }
        }
        return pilotiFiltrati;
    }
