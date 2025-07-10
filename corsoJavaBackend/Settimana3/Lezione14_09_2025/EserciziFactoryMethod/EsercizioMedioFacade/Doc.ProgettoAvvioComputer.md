Documentazione del Progetto "EsercizioMedioFacade"
Questo progetto dimostra l'applicazione dei pattern di design Facade, Singleton e Strategy, insieme al pattern Observer, per simulare il processo di avvio di un computer. L'obiettivo è semplificare l'interazione con un sottosistema complesso (l'avvio del PC) e permettere una gestione flessibile delle diverse modalità di accensione.

1. Componenti del Sistema (File Logico: Componenti.java)
   Questo "file logico" (che nel codice è distribuito tra le interfacce Componente, Hardware, Software, Firmware, Osservatore, Subject, Avvio e le classi Bios, SistemaOperativo, HardDisk) definisce gli elementi fondamentali del nostro sistema e le loro interazioni.

Interfacce Comuni
Componente: Interfaccia marker base per tutti gli elementi del sistema.

Hardware, Software, Firmware: Interfacce marker per classificare i tipi di componenti.

Avvio: Definisce il contratto per i componenti che possono essere inizializzati, caricati e avviati (inizializza(), carica(), avvia()).

Osservatore: Parte del pattern Observer. Definisce il metodo update(String messaggio) per ricevere notifiche.

Subject: Parte del pattern Observer. Definisce i metodi per registrare (registerObservator()), rimuovere (removeObservator()) e notificare (notificaOsservatori()) gli osservatori.

Classi dei Componenti
Bios:

Ruolo: Rappresenta il Basic Input/Output System, il firmware di base.

Funzionalità: Implementa Firmware, Avvio (per la sua inizializzazione) e Osservatore (può essere aggiornato, ad esempio, dal Sistema Operativo).

Metodi: inizializza(), carica(), avvia(), update().

SistemaOperativo:

Ruolo: Rappresenta il sistema operativo (es. Windows, Linux).

Pattern: Implementa il pattern Singleton (getSistemaOperativo()) per assicurare che esista una sola istanza del SO nel sistema. Implementa anche Subject (può notificare aggiornamenti ad altri componenti) e Osservatore (può ricevere aggiornamenti).

Funzionalità: Gestisce la propria versione e notifica gli osservatori quando questa cambia.

Metodi: inizializza(), carica(), avvia(), getVersione(), setVersione(), registerObservator(), removeObservator(), notificaOsservatori().

HardDisk:

Ruolo: Rappresenta l'unità di archiviazione dati.

Funzionalità: Implementa Hardware, Avvio (può essere inizializzato e caricato) e Osservatore (può essere aggiornato).

Metodi: inizializza(), carica(), avvia(), update().

2. Strategie di Avvio (File Logico: Strategy.java)
   Questo "file logico" (corrispondente alle interfacce e classi AvvioStrategy, AvvioNormaleStrategy, AvvioProvvisorioStrategy) introduce il pattern Strategy per definire diverse sequenze di avvio.

Interfaccia di Strategia
AvvioStrategy:

Ruolo: Definisce l'interfaccia per tutte le strategie di avvio possibili.

Metodo: sequenzaDiAvvio(Bios bios, HardDisk hardDisk, SistemaOperativo os). Questo metodo è il cuore della strategia, specificando come i componenti devono essere avviati.

Implementazioni Concrete delle Strategie
AvvioNormaleStrategy:

Ruolo: Implementa la strategia per un avvio standard del sistema.

Logica: Avvia sequenzialmente BIOS, Hard Disk e Sistema Operativo.

AvvioProvvisorioStrategy:

Ruolo: Implementa la strategia per un avvio in modalità provvisoria.

Logica: Simula un avvio ridotto, attivando solo il BIOS e l'inizializzazione/avvio essenziale del Sistema Operativo, saltando o riducendo l'interazione con altri componenti come l'Hard Disk.

3. Facade di Avvio (File: AvvioFacade.java)
   La classe AvvioFacade è l'implementazione del pattern Facade e semplifica l'interazione con il complesso sottosistema di avvio del computer.

AvvioFacade:

Ruolo: Fornisce un'interfaccia semplificata per il client (es. MainAccendiComputer) per eseguire operazioni complesse di avvio. Nasconde i dettagli interni di come i singoli componenti interagiscono.

Pattern: Implementa il pattern Singleton (getAvvioFacade()) per avere un unico punto di accesso all'operazione di avvio del PC. Utilizza il pattern Strategy per delegare l'effettiva sequenza di avvio a un oggetto AvvioStrategy.

Attributi: Mantiene riferimenti ai componenti interni (hardDisk, sistemaOperativo, bios) e all'attuale strategiaDiAvvio.

Metodi Chiave:

aggiornaSistemaOperativo(String versione): Un'operazione di alto livello che permette di aggiornare il SO, sfruttando il pattern Observer per notificare altri componenti.

configura(): Configura le relazioni di Observer (es. BIOS e Hard Disk si registrano come osservatori del Sistema Operativo).

setStrategiaDiAvvio(AvvioStrategy strategia): Permette al client di cambiare dinamicamente la modalità di avvio (ad esempio, da "normale" a "provvisoria").

esegui(): Il metodo principale della Facade che delega l'esecuzione della sequenza di avvio alla strategia attualmente impostata.

4. Classe Principale (File: MainAccendiComputer.java)
   Questa è la classe di test che dimostra come il client interagisce con il sistema attraverso la AvvioFacade, senza conoscere la complessità sottostante.

MainAccendiComputer:

Ruolo: Il punto di ingresso dell'applicazione. Dimostra come utilizzare la AvvioFacade per accendere il computer in diverse modalità.

Logica:

Ottiene l'istanza della AvvioFacade.

Chiama configura() per impostare le relazioni tra i componenti.

Chiama aggiornaSistemaOperativo() sulla Facade, che a sua volta attiva il meccanismo Observer.

Esegue un avvio normale chiamando esegui() (che utilizza la strategia di default).

Cambia dinamicamente la strategia di avvio impostandola su AvvioProvvisorioStrategy.

Esegue nuovamente esegui(), mostrando il comportamento della modalità provvisoria.
