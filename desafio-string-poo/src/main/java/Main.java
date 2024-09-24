import texto.manipulacao.tipo.RemoveLetraA;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        inicializador();
    }


    public static void inicializador(){
        Scanner input = new Scanner(System.in);
        Scanner inputTexto = new Scanner(System.in);
        System.out.println("""
                -----Operações com texto.-----
                1 - Remover a letra A.
               
                2 - Sair.
                """);

        int escolha = input.nextInt();

        switch(escolha){
            case 1 -> {
                RemoveLetraA removerLetraA = new RemoveLetraA();
                removerLetraA.getDescricao();
                System.out.println("Digite o texto: ");
                String texto = inputTexto.nextLine();


                System.out.println("Removendo a letra A....");
                String resultado = removerLetraA.operacao(texto);
                System.out.println("Resultado: " + resultado);

                inicializador();
            }case 2 -> System.out.println("Saindo......");
            default -> {
                System.out.println("Digite um número valido!!!");

                inicializador();
            }
        };
    }
}
