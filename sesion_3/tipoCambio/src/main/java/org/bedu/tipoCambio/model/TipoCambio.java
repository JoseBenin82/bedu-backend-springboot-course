package org.bedu.tipoCambio.model;
import java.util.HashMap;
public class TipoCambio {

    private String codigo; //USD 

    private HashMap<String, Double> conversiones;  // MXN=18.01, ARS=1433.88


    public TipoCambio(String codigo, HashMap<String, Double> conversiones) {
        this.codigo = codigo;
        this.conversiones = conversiones;
    }


    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public HashMap<String, Double> getConversiones() {
        return conversiones;
    }
    public void setConversiones(HashMap<String, Double> conversiones) {
        this.conversiones = conversiones;
    }

    


}
