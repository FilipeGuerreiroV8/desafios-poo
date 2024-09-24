package matematica;

import java.util.ArrayList;
import java.util.List;

public class Calculo {
   private String operacao;
   private List<Double> resultados = new ArrayList<>();

    public Calculo(String operacao){
       this.operacao = operacao;
   }
    public List<Double> getResultados() {
        return this.resultados;
    }
    public void objetivo(){
        System.out.println("O objetivo dessa classe é realizar uma " + this.operacao + " com os argumentos.");
    }

    public void adicionaResultado(Double resultado){
       this.resultados.add(resultado);
    }

}
