package utilidades;

public class ApiSpring {
    private String argumento;

    public ApiSpring(String argumento){
        this.argumento = argumento;
    }

    public void consultar(){
        ConsultaApi consulta = new ConsultaApi("http://localhost:8080/hello?name=" + argumento);
        System.out.println(consulta.consultar());
    }

}
