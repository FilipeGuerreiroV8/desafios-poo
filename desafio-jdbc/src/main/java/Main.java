import sistema.Usuario;
import sistema.cep.CepException;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CepException {
        inicializador();
    }

    public static void inicializador() throws CepException {
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        System.out.println("""
                -------------- Desafio jdbc ---------------
                1 - Exibir usuários cadastrados.
                2 - Cadastrar usuário.
                3 - cadastrar endereço. 
                4 - Sair.
                """);

        var escolha = input.nextInt();

        switch (escolha){
            case 4 -> System.out.println("Saindo....");
            case 1 ->{
                System.out.println("listando usuarios");
                Usuario usuario = new Usuario();
                List<Usuario> usuarios = usuario.getUsuarios();
                for (Usuario usuarioAtual : usuarios){
                    System.out.println(usuarioAtual);
                }

                System.out.println("Digite qualquer tecla para sair.");
                input2.hasNext();
                inicializador();
            }
            case 2 ->{
                System.out.println("Cadastrando usuários.");
                System.out.println("Insira um nome:");
                var nome = input2.nextLine();
                System.out.println("Insira uma data de nascimento (AAAA/MM/DD):");
                var dtNasc = input2.nextLine();
                System.out.println("Insira um email:");
                var email = input2.nextLine();

                Usuario novoUsuario = new Usuario();
                novoUsuario.cadastrar(nome, dtNasc, email);
                System.out.println("Digite qualquer tecla para voltar ao menu.");
                input2.hasNext();
                inicializador();
            }
            case 3 ->{
                System.out.println("Cadastrando endereços.");
                System.out.println("Insira um id de usuário:");
                var UID = input.nextInt();
                System.out.println("Insira um cep");
                var cep = input2.nextLine();
                Usuario usuario = new Usuario().getUsuario(UID);
                usuario.cadastrarEndereco(cep);
                System.out.println("Digite qualquer tecla para voltar ao menu.");
                input2.hasNext();
                inicializador();
            }
            default -> {
                System.out.println("Escolha um número válido!");
                inicializador();
            }
        }
    }

}
