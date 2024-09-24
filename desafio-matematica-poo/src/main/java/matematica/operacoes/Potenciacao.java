package matematica.operacoes;

import matematica.Calculo;
import matematica.OperacaoMatematica;

public class Potenciacao extends Calculo implements OperacaoMatematica {

    public Potenciacao(){
    super("Potenciação");
    }

    @Override
    public void calcular(Double base, Double potencia) {
        if (potencia == 0){
            this.adicionaResultado(1.0);
        }
        double resultado = base;
        for (int i = 0; i < potencia - 1; i++) {
            resultado *= base;
        }
        this.adicionaResultado(resultado);
    }
}
