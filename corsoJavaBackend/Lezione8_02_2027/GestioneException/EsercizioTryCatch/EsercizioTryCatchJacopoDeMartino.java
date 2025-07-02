package corsoJavaBackend.Lezione8_02_2027.GestioneException.EsercizioTryCatch;

import java.util.Scanner;

//! Classi Exception specifiche per casi
class NumeroNegativoException extends Exception {
    NumeroNegativoException() {
    }

    NumeroNegativoException(String message, Throwable cause) {
        super(message, cause);
    }
}

class NumeroZeroException extends Exception {
    NumeroZeroException() {
    }

    NumeroZeroException(String message, Throwable cause) {
        super(message, cause);
    }
}

// ! Fine classi Exception
class Validator {
    public static void checkPositive(int numero) throws Exception {
        if (numero < 0) {
            throw new NumeroNegativoException("Numero inserito: " + numero +
                    "\nHai inserito un numero non valido, per favore inserisci un numero positivo.", null);
        }
    }

    public static void checkNotZero(int numero) throws Exception {
        if (numero == 0) {
            throw new NumeroZeroException("Numero inserito: " + numero +
                    "\nIl numero 0 non è valido come divisore.", null);
        }
    }
}

public class EsercizioTryCatchJacopoDeMartino {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scelta = 0;

        do {
            System.out.println("Procedere con la divisione?\n'1' = sì\n'2' = no");
            while (!scanner.hasNextInt()) {
                System.out.println("Input non valido. Inserisci '1' per sì o '2' per no.");
                scanner.next(); // scarta input non valido
            }
            scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                    boolean inputValido = false;
                    while (!inputValido) {
                        int dividendo = 0;
                        int divisore = 0;

                        // --- Input e validazione del dividendo ---
                        boolean dividendoValido = false;
                        while (!dividendoValido) {
                            try {
                                System.out.println("Inserisci il primo numero (dividendo):");
                                while (!scanner.hasNextInt()) {
                                    System.out.println("Input non valido. Inserisci un numero intero:");
                                    scanner.next();
                                }
                                dividendo = scanner.nextInt();
                                Validator.checkPositive(dividendo);
                                dividendoValido = true;
                            } catch (NumeroNegativoException e) {
                                System.err.println("Errore: " + e.getMessage());
                            } catch (Exception e) {
                                System.err.println("Errore generico: " + e.getMessage());
                            }
                        }

                        // --- Input e validazione del divisore ---
                        boolean divisoreValido = false;
                        while (!divisoreValido) {
                            try {
                                System.out.println("Inserisci il secondo numero (divisore):");
                                while (!scanner.hasNextInt()) {
                                    System.out.println("Input non valido. Inserisci un numero intero diverso da 0:");
                                    scanner.next();
                                }
                                divisore = scanner.nextInt();
                                Validator.checkNotZero(divisore);
                                divisoreValido = true;
                            } catch (NumeroZeroException e) {
                                System.err.println("Errore: " + e.getMessage());
                            } catch (Exception e) {
                                System.err.println("Errore generico: " + e.getMessage());
                            }
                        }

                        // --- Divisione ---
                        int risultato = dividendo / divisore;
                        System.out.println("Risultato della divisione: " + risultato);
                        inputValido = true;
                    }
                    break;
                case 2:
                    System.out.println("Programma terminato.");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }

        } while (scelta != 2);

        scanner.close();
    }
}
