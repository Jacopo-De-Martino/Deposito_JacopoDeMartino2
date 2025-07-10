# DevOps

Dev = Development (Sviluppo)
Ops = Operations (Operazioni IT)

## Cos'è:

È il collante tra la programmazione e gli altri settori del mondo IT.

È un insieme di pratiche e principi che mirano a unire i team di sviluppo (Dev) e operazioni (Ops) per una consegna del software più rapida, affidabile e continua.

È una cultura collaborativa che abbatte i silos tra i dipartimenti e promuove una comunicazione aperta, efficiente e frequente.

## Cosa rappresenta:

I principi fondamentali per un flusso di lavoro ottimizzato e continuo.

Il miglioramento continuo, l’automazione e l’integrazione costante tra sviluppo, test e produzione.

## Fasi tipiche nel ciclo DevOps:

### Fasi che interessano gli sviluppatori:

Plan → Pianificazione delle funzionalità e gestione dei requisiti

Build → Scrittura del codice e compilazione

Test → Verifica automatica/manuale del codice

Deploy → Rilascio in ambienti di test o produzione

### Fasi che interessano il DevOps engineer (o Dev Master):

Release → Gestione del rilascio e versionamento

Operate → Monitoraggio, gestione dell'infrastruttura, uptime

Monitor → Raccolta di metriche, logging, feedback continuo

## 🔑 Principi chiave del DevOps

### 🤝 Collaborazione e comunicazione

I team di sviluppo e operazioni devono lavorare insieme e comunicare in modo efficace. Questo aiuta a:

Evitare errori

Risolvere i problemi più rapidamente

Migliorare la qualità del software

### Integrazione e automazione

Unire i processi tra sviluppo e operazioni consente di automatizzare attività ripetitive, come:

Eseguire test automatici

Rilasciare nuove versioni del software

Monitorare il sistema in produzione

L’automazione riduce i tempi, gli errori umani e migliora l'efficienza.

### 🔁 Feedback continuo

Un ciclo di feedback continuo permette di identificare e correggere problemi in modo rapido.
Il feedback può arrivare da:

Test automatizzati

Monitoraggio del sistema

Feedback degli utenti (email, recensioni, ticket)

### 🎯 Pensiero orientato al cliente

Lo sviluppo deve essere centrato sulle esigenze del cliente, con l'obiettivo di:

Soddisfare le sue richieste

Rispettare le tempistiche

Offrire valore reale attraverso il software

### 🔄 Miglioramento continuo

È un processo iterativo che richiede un impegno costante da parte dei team.
Consiste nel:

Monitorare costantemente i processi

Individuare i punti deboli

Apportare modifiche per migliorare efficienza, qualità e stabilità

L’obiettivo è evolversi passo dopo passo, senza mai fermarsi.

### ⚠️ Cultura del caos (DevOps)

DevOps abbraccia l'incertezza e accetta che il cambiamento è inevitabile. In questo contesto:

I team devono adattarsi rapidamente alle nuove sfide

Devono imparare dai propri errori, e non evitarli a tutti i costi

Il fallimento è visto come un momento di apprendimento, non solo come un problema

🧠 Cos'è la error history?
La "error history" è la traccia documentata degli errori passati:

Aiuta i team a capire cosa è andato storto

Permette di evitare gli stessi errori in futuro

È utile durante analisi post-mortem, debug o in caso di incidenti critici

In pratica, è un “archivio degli sbagli” da cui imparare.

## 🛠️ Tecniche utili per gestire il caos:

Versionamento evolutivo: aggiornare il software a piccoli passi, mantenendo sempre versioni funzionanti

Disaster recovery: piani e sistemi per ripristinare rapidamente l’operatività in caso di crash, bug gravi o attacchi

Testing continuo: per anticipare problemi prima che si presentino in produzione

## Pratiche DevOps (sviluppo operazioni it)

🧩 Sviluppo agile / Lavorare in modo agile
Suddividere il lavoro in piccole attività (task), lavorando in cicli brevi e iterativi per adattarsi rapidamente ai cambiamenti e alle esigenze del cliente.

🔁 Continuous Integration (CI)
Automatizzare l’integrazione del codice scritto da diversi sviluppatori in una repository centrale.
Ogni modifica viene testata automaticamente per evitare conflitti e bug.

🚀 Continuous Delivery (CD)
Automatizzare il processo di rilascio del software in ambienti di test e produzione.
Il codice è sempre pronto per essere distribuito, in modo sicuro e rapido.

🖥️ Infrastruttura come Codice (IaC)
Gestire l’infrastruttura IT (server, rete, configurazioni) usando file di codice.
Questo permette di:

Automatizzare la configurazione di ambienti

Replicare infrastrutture facilmente

Gestire risorse fisiche come se fossero digitali

📈 Monitoraggio e Alerting
Controllare costantemente il funzionamento del sistema per:

Rilevare anomalie o guasti in tempo reale

Inviare avvisi (alert) ai team tecnici per intervenire subito

Migliorare la stabilità e le prestazioni

# Strumenti DevOps , i fondamentali :

🔄 Controllo della versione
Permettono di tracciare le modifiche al codice, collaborare in team e gestire versioni diverse dello stesso progetto.

Git: Sistema di controllo versione distribuito, il più usato al mondo.

GitHub: Piattaforma online per ospitare progetti Git, collaborare e fare code review.

SVN (Subversion): Sistema di controllo versione centralizzato (meno usato oggi rispetto a Git).

🔁 Integrazione continua (CI) e distribuzione continua (CD)
Automatizzano il processo di build, test e rilascio del software.

Jenkins: Strumento open source molto personalizzabile per CI/CD.

GitLab CI/CD: Sistema integrato in GitLab per pipeline di integrazione e rilascio.

Travis CI: Servizio CI focalizzato su progetti open source.

CircleCI: CI/CD veloce e scalabile, molto usato in ambienti cloud.

📦 Containerizzazione
Isola le applicazioni in ambienti leggeri e portabili, facilitando il deploy su qualsiasi macchina.

Docker: Strumento per creare e gestire container (ambienti isolati per applicazioni).

Kubernetes: Piattaforma per orchestrare e gestire molti container in modo automatizzato (scalabilità, alta disponibilità).

⚙️ Gestione della configurazione
Automatizzano l’installazione, configurazione e aggiornamento di server e infrastrutture.

Ansible: Semplice e leggibile (basato su YAML), senza agenti.

Chef: Più complesso, usa Ruby per le configurazioni.

Puppet: Potente e molto usato in ambienti enterprise, basato su dichiarazioni.

📊 Monitoraggio
Servono a controllare lo stato e le prestazioni dei sistemi, notificando errori e problemi.

Nagios: Monitoraggio di infrastrutture IT (storico, molto diffuso).

Prometheus: Monitoraggio moderno con raccolta dati a intervalli e supporto per alert.

Grafana: Dashboard visive per i dati raccolti (spesso usato con Prometheus).

📝 Registrazione e Log Management
Gestiscono i log generati da sistemi e applicazioni per analisi e debug.

ELK Stack:

Elasticsearch: Motore di ricerca per analisi e interrogazione dei log.

Logstash: Raccolta e trasformazione dei log da varie fonti.

Kibana: Interfaccia grafica per visualizzare i log in tempo reale.
