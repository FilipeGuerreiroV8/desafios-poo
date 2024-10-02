package sistema;

import DB.ConnectionDB;
import sistema.cep.BuscaCep;
import sistema.cep.Cep;
import sistema.cep.CepException;

import java.sql.Connection;
import java.util.List;

import static java.util.Objects.isNull;

public class Usuario {
    private Integer UID;
    private String nome;
    private String dtNasc;
    private String email;
    private String cep;
    private Cep endereco;

    private ConnectionDB connection;

    public Usuario(){
        this.connection = new ConnectionDB();
    }

    public void cadastrar(String nome, String dtNasc, String email){
        Connection conn = connection.abrirConexao();
        new UsuarioDAO(conn).inserir(nome, dtNasc, email);
    }
    public void cadastrarEndereco(String busca) throws CepException {
        Connection conn = connection.abrirConexao();
        new UsuarioDAO(conn).inserirEndereco(busca, getUID());
        BuscaCep buscarCep = new BuscaCep();
        setEndereco(buscarCep.buscar(busca));

    }

    @Override
    public String toString() {
        String rua = isNull(this.endereco) ? "Não registrado." : endereco.getRua();
        String estado = isNull(this.endereco) ? "Não registrado." : endereco.getEstado();
        String uf = isNull(this.endereco) ? "Não registrado." : endereco.getUf();
        String ddd = isNull(this.endereco) ? "Não registrado." : endereco.getDdd();
        String regiao = isNull(this.endereco) ? "Não registrado." : endereco.getRegiao();
        String cep = getCep() == null ? "Não registrado." : getCep();
        return """
                Nome: %s
                data de nascimento: %s
                email: %s
                endereco: 
                 cep: %s
                  rua: %s
                  estado %s
                  uf %s
                  ddd %s
                  regiao %s
                """.formatted(getNome(), getDtNasc(), getEmail(), cep, rua, estado, uf,
                              ddd, regiao);
    }

    public Usuario getUsuario(Integer UID){
        Connection conn = connection.abrirConexao();
        return new UsuarioDAO(conn).recuperarUsuario(UID);

    }

    public List<Usuario> getUsuarios(){
        Connection conn = connection.abrirConexao();
        return new UsuarioDAO(conn).recuperarUsuarios();
    }

    public Integer getUID() {
        return UID;
    }

     void setUID(Integer UID) {
        this.UID = UID;
    }

    public String getNome() {
        return nome;
    }

     void setNome(String nome) {
        this.nome = nome;
    }

    public String getDtNasc() {
        return dtNasc;
    }

     void setDtNasc(String dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getEmail() {
        return email;
    }

     void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

     void setCep(String cep) {
        this.cep = cep;
    }

    void setEndereco(Cep endereco){
        this.endereco = endereco;
    }
}
