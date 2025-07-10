## L'interfaccia Estensione o tipo funzionale non instanziabile

Definizione e Caratteristiche
Un'interfaccia è essenzialmente un elenco di firme di metodi (nome, parametri e tipo di ritorno) senza un corpo. Può essere vista come una classe astratta pura, il cui scopo è garantire che una classe fornisca determinate funzionalità.

Non può essere istanziata: Non è possibile creare un oggetto direttamente da un'interfaccia. Ad esempio, se hai un'interfaccia Volante, non puoi scrivere new Volante(). Devi creare un'istanza di una classe che implementa quell'interfaccia, come new Uccello().

Contratto per le Classi: Quando una classe implementa un'interfaccia, si impegna a fornire un'implementazione concreta per tutti i metodi definiti dall'interfaccia stessa.

Vantaggi Principali
Implementazione Multipla
A differenza dell'ereditarietà tra classi, che è singola in molti linguaggi (come Java), una classe può implementare più interfacce contemporaneamente. Questo permette a una classe di "ereditare" comportamenti da diverse fonti, rendendo il design del software più flessibile.

Esempio: Una classe Idrovolante può implementare sia l'interfaccia Veicolo che l'interfaccia Natante.

Polimorfismo
Le interfacce sono uno strumento chiave per il polimorfismo. Permettono di scrivere codice che opera su oggetti di tipi diversi in modo uniforme, a patto che condividano la stessa interfaccia.

Esempio: Due classi, Cane e Gatto, possono entrambe implementare l'interfaccia Animale, che definisce il metodo emettiSuono(). Sebbene l'implementazione del metodo sia diversa per ciascuna classe ("bau" per il cane, "miao" per il gatto), puoi trattarle entrambe come oggetti di tipo Animale e invocare il loro metodo emettiSuono() senza dover conoscere il tipo specifico dell'oggetto.
