package corsoJavaBackend.Settimana3.lezione13_09_07_2025.EserciziStrategy.EsercizioDifficile;

import java.util.ArrayList;
import java.util.List;

interface Subject {
    void registraOsservatore(Osservatore o);

    void rimuoviOsservatore(Osservatore o);

    void mostraNotifiche(String messaggio);

}

public class PagamentoContext implements Subject {
    private Strategy_MetodoPagamento metodoPagamento;
    private Strategy_TipoPagamento tipoPagamento;
    private List<Osservatore> utenti;

    public List<Osservatore> getUtenti() {
        return utenti;
    }

    public void setUtenti(List<Osservatore> utenti) {
        this.utenti = utenti;
    }

    public static void setPagamentoContext(PagamentoContext pagamentoContext) {
        PagamentoContext.pagamentoContext = pagamentoContext;
    }

    private static PagamentoContext pagamentoContext;

    public static PagamentoContext getPagamentoContext() {
        if (pagamentoContext == null) {
            pagamentoContext = new PagamentoContext(null, null);
            return pagamentoContext;
        }
        return pagamentoContext;
    }

    private PagamentoContext(Strategy_MetodoPagamento metodoPagamento, Strategy_TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
        this.metodoPagamento = metodoPagamento;
        this.utenti = new ArrayList<>();
    }

    public Strategy_MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(Strategy_MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Strategy_TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(Strategy_TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public void paga(double importo, String causale) {
        if (metodoPagamento != null && tipoPagamento != null) {
            metodoPagamento.paga(importo);
            tipoPagamento.pagaCon(metodoPagamento);
            notifica(causale);
        } else {
            System.out.println("Impossibile effetuare l'operazione inserire metodo di pagamento, e tipo di pagamento");
            return;
        }
    }

    @Override
    public void registraOsservatore(Osservatore o) {
        utenti.add(o);
    }

    @Override
    public void rimuoviOsservatore(Osservatore o) {
        utenti.remove(o);
    }

    @Override
    public void mostraNotifiche(String messaggio) {
        for (Osservatore o : utenti) {
            o.update(messaggio);
        }
    }

    public void notifica(String messaggio) {
        System.out.println("Invio cambiamenti utenti....");
        mostraNotifiche(messaggio);
    }

}
