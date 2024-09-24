package matematica.operacoes;

import matematica.Calculo;
import matematica.OperacaoMatematica;

public class Soma extends Calculo implements OperacaoMatematica {

    public Soma(){
        super("Soma");
    }

    @Override
    public void calcular(Double n1, Double n2){
        Double resultado = n1 + n2;
        this.adicionaResultado(resultado);
    }
}
