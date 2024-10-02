package sistema.cep;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import sistema.cep.records.DadosCep;

public class BuscaCep {
    public Cep buscar(String cep) throws CepException {
        String cepFormatado = tratarCep(cep);
        ConsultaApi consultador = new ConsultaApi("https://viacep.com.br/ws/" + cepFormatado + "/json/");
        String json = consultador.consultar();

        if (json.equals("erro_argumento") || json.equals("erro_runtime")){
             throw new CepException("ERRO NA REQUISIÇÃO DA API.");
        }else{
            Gson gson = new GsonBuilder().create();

            DadosCep dados = gson.fromJson(json, DadosCep.class);
            Cep cepObjeto = new Cep(dados);

            if (cepObjeto.getErro()){
                throw new CepException("Erro! Cep não encontrado.");
            }else{
               return cepObjeto;
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

}

