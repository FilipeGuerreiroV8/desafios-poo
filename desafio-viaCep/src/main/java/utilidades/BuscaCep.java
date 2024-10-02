package utilidades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import utilidades.records.DadosCep;

public class BuscaCep {
    private String mensagem;


    public void buscar(String cep){

        String cepFormatado = tratarCep(cep);
        ConsultaApi consultador = new ConsultaApi("https://viacep.com.br/ws/" + cepFormatado + "/json/");
        String json = consultador.consultar();

        if (json.equals("erro_argumento") || json.equals("erro_runtime")){
            this.mensagem = "ERRO NA REQUISIÇÃO DA API.";
        }else{
            Gson gson = new GsonBuilder().create();

            DadosCep dados = gson.fromJson(json, DadosCep.class);
            Cep cepObjeto = new Cep(dados);

            if (cepObjeto.getErro()){
                this.mensagem = "Erro! Cep não encontrado.";
            }else{
                this.mensagem = """
                        Dados do CEP %s
                        Rua: %s
                        Estado: %s
                        Uf: %s
                        DDD: %s
                        Região %s
                        """.formatted(cepFormatado,
                                      cepObjeto.getRua(),
                                      cepObjeto.getEstado(),
                                      cepObjeto.getUf(),
                                      cepObjeto.getDdd(),
                                      cepObjeto.getRegiao()
                                      );
            }
        }
    }

    private String tratarCep(String cep){
        if (!cep.matches("\\d{5}-\\d{3}") && !cep.matches("\\d{8}")){
            return "CEP INVÁLIDO INSERIDO.";
        }
        String cepFormatado = cep.replace("-", "");
        return cepFormatado;
    }

    @Override
    public String toString() {
        return this.mensagem;
    }
}

