package recursos;

public class Items{
    private String nombre;
    private String codigoISO;
    private String simbolo;
    private double valor;


    // para monedas
    public Items(String divisa, String codigoISO, String simbolo, double 
    valor) {
        this.nombre = divisa;
        this.codigoISO = codigoISO;
        this.simbolo = simbolo;
        this.valor = valor;
    }

    // para longitudes
    public Items(String nombre, String simbolo, double valor) {
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.valor = valor;
    }

    public Items(String nombre, String simbolo){
        this.nombre = nombre;
        this.simbolo = simbolo;
    }
        
    @Override
    public String toString() {
        if(codigoISO != null){
            return nombre + " - " + codigoISO;
        } else {
            return nombre;
        }
    }
    
    public double getValor() {
        return valor;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getSimbolo() {
        return simbolo;
    }

}
