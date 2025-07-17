package corsoJavaBackend.Settimana3.lezione13_09_07_2025.EserciziStrategy.EsercizioDifficile;

public class User implements Osservatore {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(String messaggio) {
        System.out.println(nome + " aggiornamento sui pagamenti " + messaggio);
    }

    @Override
    public String toString() {
        return "User [nome=" + nome + ", getNome()=" + getNome() + ", getClass()=" + getClass() + ", hashCode()="
                + hashCode() + ", toString()=" + super.toString() + "]";
    }

}
