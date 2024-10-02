package sistema.cep.records;
import com.google.gson.annotations.SerializedName;

public record DadosCep(
        String logradouro,
        String estado,
        String regiao,
        String uf,
        String ddd,
        boolean erro
) {
}
