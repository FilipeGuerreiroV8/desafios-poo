package utilidades;

import utilidades.records.DadosCep;

public class Cep {
    private String rua;
    private String estado;
    private String uf;
    private String ddd;
    private String regiao;
    private boolean erro;

    public Cep(DadosCep dados) {
        this.rua = dados.logradouro();
        this.estado = dados.estado();
        this.uf = dados.uf();
        this.ddd = dados.ddd();
        this.regiao = dados.regiao();
        this.erro = dados.erro();
    }

    public String getRua() {
        return rua;
    }

    public String getEstado() {
        return estado;
    }

    public String getUf() {
        return uf;
    }

    public String getDdd() {
        return ddd;
    }

    public String getRegiao() {
        return regiao;
    }

    public boolean getErro(){
        return erro;
    }
}
