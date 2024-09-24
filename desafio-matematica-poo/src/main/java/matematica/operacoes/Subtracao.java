package matematica.operacoes;

import matematica.Calculo;
import matematica.OperacaoMatematica;

public class Subtracao extends Calculo implements OperacaoMatematica {
    public Subtracao(){
        super("Subtração");
    }

    @Override
    public void calcular(Double n1, Double n2) {
       this.adicionaResultado(n1 - n2);
    }
}
