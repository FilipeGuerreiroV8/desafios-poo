package school.sptech.ex3;

public class Funcionario {
    String nome = "";
    String cargo = "";
    Double salario = 0.0;

    public void reajustarSalario(Integer porcentAjuste){
        Double reajuste = salario * (double) porcentAjuste / 100.0;
        salario += reajuste;
    }
    public Double calcularValorHora(){
        return salario/220.0;
    }

    public Double calcularHoraExtra(Integer qtdHoras, Integer porcentAdicional){
        Double valorHora = salario/220.0 * qtdHoras;
        Double adicionalNoturno = valorHora * (double) porcentAdicional / 100.0;
        valorHora += adicionalNoturno;
        return valorHora;

    }

}
