package corsoJavaBackend.Settimana3.lezione13_09_07_2025.EserciziStrategy.EsercizioFacile;

class Operazione_Moltiplicazione implements Operazione {

    @Override
    public int esegui(int a, int b) {
        return a * b;
    }

}

class Operazione_Addizione implements Operazione {

    @Override
    public int esegui(int a, int b) {
        return a + b;
    }

}
