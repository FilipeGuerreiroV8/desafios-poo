import java.util.Scanner;

import utilidades.ApiSpring;
import utilidades.BuscaCep;
public class Main {
    public static void main(String[] args) {
        inicializador();
    }

    public static void inicializador(){
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        System.out.println("""
                -------------- Pesquisador de Cep ---------------
                1 - Pesquisar.
                2 - Sair.
                """);

        var escolha = input.nextInt();

        switch (escolha){
            case 2 -> System.out.println("Saindo....");
            case 1 ->{
                System.out.println("Digite um CEP!");
                var cep = input2.nextLine();
                BuscaCep buscaCep = new BuscaCep();
                buscaCep.buscar(cep);
                System.out.println(buscaCep.toString());




                inicializador();
            }
            default -> {
                System.out.println("Escolha um número válido!");
                inicializador();
            }
        }
    }
}
