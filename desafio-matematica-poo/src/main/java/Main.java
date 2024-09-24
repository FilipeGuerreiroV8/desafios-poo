import matematica.operacoes.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        calculadora();
    }

    public static void calculadora(){
        Scanner input = new Scanner(System.in);
        System.out.println("""
                -----Calculadora-----
                1 - Somar.
                2 - Subtrair.
                3 - Multiplicar.
                4 - Dividir.
                5 - Elevar.
                
                6 - Sair.
                """);

        int escolha = input.nextInt();

        switch(escolha){
            case 1 -> {
                System.out.println("Digite os valores para a Soma: ");
                int n1 = input.nextInt();
                int n2 = input.nextInt();

                Soma soma = new Soma();

                soma.objetivo();
                System.out.println("somando %d + %d. ".formatted(n1, n2));
                soma.calcular((double) n1, (double) n2);
                System.out.println("Resultado: " + soma.getResultados().get(0));

                calculadora();
            }case 2 -> {
                System.out.println("Digite os valores para a Subtração: ");
                int n1 = input.nextInt();
                int n2 = input.nextInt();

                Subtracao subtracao = new Subtracao();

                subtracao.objetivo();
                System.out.println("Subtraindo %d - %d. ".formatted(n1, n2));
                subtracao.calcular((double) n1, (double) n2);
                System.out.println("Resultado: " + subtracao.getResultados().get(0));

                calculadora();

            }case 3 -> {
                System.out.println("Digite os valores para a Multiplicação: ");
                int n1 = input.nextInt();
                int n2 = input.nextInt();

                Multiplicacao multiplicacao = new Multiplicacao();

                multiplicacao.objetivo();
                System.out.println("Multiplicando %d * %d. ".formatted(n1, n2));
                multiplicacao.calcular((double) n1, (double) n2);
                System.out.println("Resultado: " + multiplicacao.getResultados().get(0));

                calculadora();

            }case 4 -> {
                System.out.println("Digite os valores para a Divisão: ");
                int n1 = input.nextInt();
                int n2 = input.nextInt();

                Divisao divisao = new Divisao();
                divisao.objetivo();
                System.out.println("Dividindo %d por %d. ".formatted(n1, n2));
                divisao.calcular((double) n1, (double) n2);
                System.out.println("Resultado: " + divisao.getResultados().get(0));

                calculadora();

            }case 5 -> {
                System.out.println("Digite os valores para a Potenciação: ");
                int n1 = input.nextInt();
                int n2 = input.nextInt();

                Potenciacao potencia = new Potenciacao();

                potencia.objetivo();
                System.out.println("Elevando %d ^ %d. ".formatted(n1, n2));
                potencia.calcular((double) n1, (double) n2);
                System.out.println("Resultado: " + potencia.getResultados().get(0));

                calculadora();

            }case 6 -> System.out.println("Saindo......");
            default -> {
                System.out.println("Digite um número valido!!!");

            calculadora();
            }
        };
    }
}
