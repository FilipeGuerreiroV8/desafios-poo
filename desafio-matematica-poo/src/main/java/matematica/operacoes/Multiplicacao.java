package matematica.operacoes;

import matematica.Calculo;
import matematica.OperacaoMatematica;

public class Multiplicacao extends Calculo implements OperacaoMatematica {
    public Multiplicacao(){
        super("Multiplicação");
    }

    @Override
    public void calcular(Double n1, Double n2) {
        this.adicionaResultado(n1 * n2);
    }
}
