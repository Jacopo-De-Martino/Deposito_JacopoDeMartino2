package corsoJavaBackend.lezione13_09_07_2025.EserciziStrategy.EsercizioDifficile;

interface Strategy_TipoPagamento {
    public void pagaCon(Strategy_MetodoPagamento metodoDiPagamento);
}

interface Strategy_MetodoPagamento {
    public void paga(double importo);
}

class CartaDiCredito implements Strategy_MetodoPagamento {

    @Override
    public void paga(double importo) {
        System.out.println("pagamento con importo :" + importo + " con CartaDiCredito");
    }

}

class PayPal implements Strategy_MetodoPagamento {

    @Override
    public void paga(double importo) {
        System.out.println("pagamento con importo :" + importo + " con PayPal");
    }

}

class BonificoIstantaneo implements Strategy_TipoPagamento {
    @Override
    public void pagaCon(Strategy_MetodoPagamento metodoDiPagamento) {
        if (metodoDiPagamento instanceof PayPal) {
            System.out.println("Stai eseguendo un bonifico Istantaneo con PayPal");

        } else if (metodoDiPagamento instanceof CartaDiCredito) {

            System.out.println("Stai eseguendo un bonifico Istantaneo con CartaDiCredito");
        } else {
            System.out.println("Metodo di pagamento non gestito");
        }
    }
}

class BonificoNormale implements Strategy_TipoPagamento {
    @Override
    public void pagaCon(Strategy_MetodoPagamento metodoDiPagamento) {
        if (metodoDiPagamento instanceof PayPal) {
            System.out.println("Stai eseguendo un bonifico con PayPal, tempi per pagamento 3 giorni");

        } else if (metodoDiPagamento instanceof CartaDiCredito) {

            System.out.println(
                    "Stai eseguendo un bonifico con CartaDiCredito, tempi per pagamento 48-96 ore a seconda della banca di riferimento");
        } else {
            System.out.println("Metodo di pagamento non gestito");
        }
    }

}