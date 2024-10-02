package sistema;

import sistema.cep.BuscaCep;
import sistema.cep.CepException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private Connection conn;
    UsuarioDAO(Connection connection){
        conn = connection;
    }

    public void inserir(String nome, String dtNasc, String email){
        try {
            String sql = "Insert into usuario(nome, dtNasc, email) values (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            String[] partes = dtNasc.split("/");

            int ano = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int dia = Integer.parseInt(partes[2]);

            java.sql.Date dtNascFormatada = new java.sql.Date(ano - 1900, mes, dia);
            ps.setDate(2, dtNascFormatada);
            ps.setString(3, email);
            ps.execute();
            conn.close();
            System.out.println("Usuário " + nome + " cadastrado com sucesso!.");

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void inserirEndereco(String cep, Integer UID){
        try{
            String sql = "Update usuario set cep = (?) where UID = (?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cep);
            ps.setInt(2, UID);
            ps.execute();
            ps.close();
            System.out.println("Cep " + cep + " atualizado com sucesso!.");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Usuario recuperarUsuario(Integer UID){
        try{

            String sql = "select * from usuario where UID = (?) limit 1";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, UID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){

                Usuario usuarioRecuperado = new Usuario();
                usuarioRecuperado.setUID(rs.getInt("UID"));
                usuarioRecuperado.setNome(rs.getString("nome"));
                usuarioRecuperado.setEmail(rs.getString("email"));
                usuarioRecuperado.setDtNasc(rs.getDate("dtNasc").toString());
                usuarioRecuperado.setCep(rs.getString("cep"));
                System.out.println("Usuário " + rs.getString("nome") + " recuperado com sucesso!.");
                return usuarioRecuperado;
            } else {
                return null;
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public List<Usuario> recuperarUsuarios(){
        try{

            String sql = "select * from usuario";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Usuario> usuarios = new ArrayList<>();
            while(rs.next()){
                Usuario usuarioRecuperado = new Usuario();
                usuarioRecuperado.setUID(rs.getInt("UID"));
                usuarioRecuperado.setNome(rs.getString("nome"));
                usuarioRecuperado.setEmail(rs.getString("email"));
                usuarioRecuperado.setDtNasc(rs.getDate("dtNasc").toString());
                rs.getString("cep");
                String cep = rs.wasNull() ? null : rs.getString("cep");
                usuarioRecuperado.setCep(cep);
                if(cep != null){

                BuscaCep buscarCep = new BuscaCep();
                usuarioRecuperado.setEndereco(buscarCep.buscar(cep));
                }

                usuarios.add(usuarioRecuperado);
            }
            System.out.println("Usuários recuperados com sucesso!");
            rs.close();
            ps.close();
            return usuarios;
        }catch (SQLException e){
            throw new RuntimeException(e);
        } catch (CepException e) {
            throw new RuntimeException(e);
        }

    }
}
