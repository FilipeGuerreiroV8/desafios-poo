package matematica.operacoes;

import matematica.Calculo;
import matematica.OperacaoMatematica;

public class Divisao extends Calculo implements OperacaoMatematica {

    public Divisao(){
        super("Divisão");
    }



    @Override
    public void calcular(Double n1, Double n2){
        this.adicionaResultado(n1 / n2);
    }
}
