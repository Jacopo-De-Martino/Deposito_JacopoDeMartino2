# File di test per quanto riguarda la stampa di una variabile di tipo String .

# ProvaVariabiliString.java.

    public static void main(String[] args) {
        String nome = "Jacopo"; // Prima variabile
        System.out.print("Hi "); //Stampa una string " iniziailizzata come parametro "
        System.out.print(nome); //Stampa la nostra variabile " nome "
        System.out.println(". How are you?");
    }

---

# Java essendo un linguaggio TIPIZZATO le variabili vanno dichiarate il TIPO di valore che vogliamo salvare

## I tipi si dividono principalmente i 2 macro categorie :

## Primitivi(immutabili e gia forniti da JAVA)

- char --> contiene singoli caratteri
- int/logn/short --> contengono numeri interi con cifrature massime/minime differenti
- String(Reference) --> contengono Stringhe
- float/double --> numeri con la virgola
- boolean --> true o false
- byte --> min -128 max 127

## Non primitive ( Wrapper/Oggetti )

- Integer
- Character
- Boolean
- Double
- Float
- Long
- Short
- Oggetti
