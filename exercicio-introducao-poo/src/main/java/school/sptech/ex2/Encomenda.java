package school.sptech.ex2;

public class Encomenda {
    String tamanho = "";
    String enderecoRemetente = "";
    String enderecoDestinatario = "";
    Double distancia = 0.0;
    Double valorProduto = 0.0;

    public Double calcularFrete(){
        Double frete = 0.0;
        Double porcentagem = 0.0;
        Double valorAdicionado = 0.0;
        switch (tamanho) {
            case "P" -> {
                porcentagem = 0.01;
            }
            case "M" -> {
                porcentagem = 0.03;
            }
            case "G" -> {
                porcentagem = 0.05;
            }
        }
           if (distancia <= 50.0){
                valorAdicionado = 3.0;
            }else if(distancia <= 200.0){
                valorAdicionado = 5.0;
            }else {
                valorAdicionado = 7.0;
            }
        frete = valorProduto * porcentagem + valorAdicionado;
        return frete;
    }

    public void aplicarCupomDeDesconto(Integer porcentDesconto){
        Double desconto = valorProduto * (double) porcentDesconto / 100.0;
        valorProduto -= desconto;
    }

    public Double valorTotalDaEncomenda(){
        Double frete = 0.0;
        Double porcentagem = 0.0;
        Double valorAdicionado = 0.0;
        switch (tamanho) {
            case "P" -> {
                porcentagem = 0.01;
            }
            case "M" -> {
                porcentagem = 0.03;
            }
            case "G" -> {
                porcentagem = 0.05;
            }
        }
        if (distancia <= 50.0){
            valorAdicionado = 3.0;
        }else if(distancia <= 200.0){
            valorAdicionado = 5.0;
        }else {
            valorAdicionado = 7.0;
        }
        frete = valorProduto * porcentagem + valorAdicionado;
        return valorProduto + frete;
    }
}
