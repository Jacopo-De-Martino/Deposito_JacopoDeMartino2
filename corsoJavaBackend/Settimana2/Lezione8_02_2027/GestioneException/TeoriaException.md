# Le eccezioni (Anomalie)

le eccezioni sono errori che si presentano durante l'esecuzione del codice(run-time)

sono lo strumento che Java ci mette a disposizione per intercettare e gestire gli errori:
se scriviamo il nostro codice in modo corretto dal punto di vista della gestione delle eccezioni qualora si dovesse verificare
un anomalir run-tim java incapsulerà l'errore all'interno senza bloccare il programma.

# Il blocco Try Catch(gestire le exception)

## Sintassi try{}catch{}finally{}

try{//prova ad eseguire questo blocco di codice
//blocco di codice
int x =3;
int y =0;
int z = x/y; Exception impossibili dividere per 0
System.out.println("Z=" + z);
}catch(Exception ex){ //catch è un metodo che viene richiamato dal compilatore in run time qual'ora nel blocco try ci sia un anomali, accetta come parametro un oggetto di tipo Exception
//blocco di codice
System.out.println("Verifica eccezione");
ex.printStackTrace(); // metodo che va chiamato su l'oggetto Exception che stampa la tracciatura dell'anomalia
}finally{
//utilizzo pratico chiusura risorse
}

risultato esempio ex.printStackTrace
nome del file chiamante/messaggio/at percorso intero file + metodo

## Try-witch-resources

try(Scanner scanner = new Scanner(System.in)){
//Blocco principale
}catch(Exception e){
//Blocco eseguito se nel blocco del try in run time qualcosa va storto
}finally{
//Blocco per chiudere risorse in questo caso lo gestisce il try,
}

## La gerarchia delle exception in Java

            <---Error

Throwable(lanciabile)<---

             <---Exception(Gestione anomalie checked,compilatore compilazione(CHECKED) ) <--- RuntimeException(Gestione anomalie unchecked --dopo il controllo del compilatore compilazione in run-time(UNCHECKED))

## Clausole

## Throws -->

una clausola che viene utilizzata in un metodo, un metodo può dichiarare nella sua firma che può lanciare un'eccezione attraverso questa clausola

## Sintassi

public void metodo1(String s, int i) throws Exception
public void metodo2(String s, int i) throws RuntimeException

## throw -->

con la clausola throw decidiamo di lanciare esplictamente un'eccezione di tipo checked,

## Sintassi

throw obj

## Sintassi completa checked obbligatorio utilizzo try catch

public int divisione(int x,int y) throws Exception{
int z = 0;
if(y == 0){
throw new Exception();
}
return z = x/y;
}

## Sintassi completa unchecked non utilizzo try catch

public int divisione(int x,int y) throws RuntimeException{
int z =0;
if(y == 0){
throw new RuntimeException();
}
return z = x/y;
}

## i catch multipli

possiamo usare più catch per un singolo blocco try specializzando blocchi di codice a seconda del catch che scatta.
il catch per l'exception più generico deve essere 'ultimo(catch(Exception x))
il più specifico il primo

## I catch possono avere stessi comportmaneti per 1 o più exception utilizzando il "|"

## Le Exception custom è una best practice quando vogliamo gestire delle exception personali

Creazioni classe figlie che extends Exceptio.

## Sintassi

public class NomeMiaException(Nome parlante) extends Exception{
public CustomChekedException(String message, Throwable cause){
super(message,cause);
}
}

//Struttura JAVA
4 -USER-INTERFACE - interfaccia utente - try catch -servizi rest
3 -OPERAZIONI DB - business function
2 -INTERAZIONI CON DB - salvataggio dati query
1 -ENTITY - modelli classi
// Usare breack point per il debug.
Il debug è fondamentale.
Log fondamentale.
