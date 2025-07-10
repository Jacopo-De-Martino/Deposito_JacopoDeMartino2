🔧 Il costruttore in Java
Un costruttore è un metodo speciale che viene eseguito quando si crea un oggetto con la keyword new.

🎯 Serve per inizializzare i campi di un oggetto.

🧩 Caratteristiche principali:
Ha lo stesso nome della classe

Non ha tipo di ritorno (neanche void)

Può essere sovraccaricato (overload)

🏗️ Tipi di costruttori in Java
Tipo Descrizione Esempio
Default Creato automaticamente da Java se non definisci nulla Persona p = new Persona();
Senza parametri Definito manualmente, ma senza argomenti public Persona() { ... } o implicito
Con parametri Permette di inizializzare i campi direttamente public Persona(String nome) { ... }
