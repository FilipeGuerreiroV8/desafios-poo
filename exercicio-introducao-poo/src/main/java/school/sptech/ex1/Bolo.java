package school.sptech.ex1;

public class Bolo {

    String sabor = "";
    Double valor = 0.0;
    Integer quantidadeVendida = 0;
    Integer quantidadeEmEstoque = 0;

    public void venderBolo(Integer qtdDesejada){
        if (qtdDesejada <= quantidadeEmEstoque && qtdDesejada > 0){
            quantidadeVendida += qtdDesejada;
            quantidadeEmEstoque -= qtdDesejada;
        }
    }

    public void aumentarEstoque(Integer qtdDesejada){
        if (qtdDesejada > 0){
            quantidadeEmEstoque += qtdDesejada;
        }
    }

    public Integer quantidadeDisponivel(){
        return quantidadeEmEstoque;
    }

    public Double totalVendido(){
        return quantidadeVendida * valor;
    }




}
