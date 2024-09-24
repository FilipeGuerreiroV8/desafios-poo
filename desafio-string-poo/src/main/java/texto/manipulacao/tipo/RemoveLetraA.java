package texto.manipulacao.tipo;

import texto.manipulacao.Manipulacao;
import texto.manipulacao.OperacaoCaracteres;

public class RemoveLetraA extends Manipulacao implements OperacaoCaracteres {


    public RemoveLetraA(){
        super("Esta classe tem como objetivo remover as letras A de um texto.");
    }

    @Override
    public String operacao(String texto) {
       String textoFormatado = texto.toLowerCase();
        String resultado = textoFormatado.replace("a", "");
        return resultado;
    }
}
