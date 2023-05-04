/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visao;

/**
 *
 * @author Gustavo Camargo
 */
public class Telefone {
    // atributos
    private String ddi = "" ;
    private String ddd = "";
    private String numeroTelefone= "";
    
    //Metodos
    public Telefone(){
        this.ddi = "";
        this.ddd = "";
        this.numeroTelefone = "";
    }

    public Telefone(String ddi, String ddd, String numeroTelefone)throws Exception{
        if ( ddi.equals("")) throw  new Exception("DDI Invalido");
        this.ddi = ddi;
        if ( ddd.equals("")) throw  new Exception("DDD Invalido");
        this.ddd = ddd;
        if ( numeroTelefone.equals("")) throw new Exception("Campo Numero de telefone esta vazio!!");
        if ( numeroTelefone.length() <= 8  ) throw new Exception("Campo Numero de telefone esta incorrreto!! < 8 ");
        this.numeroTelefone = numeroTelefone;
    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) throws Exception{
        if ( ddi.equals("")) throw  new Exception("DDI Invalido");
        this.ddi = ddi;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd)throws Exception{
        if ( ddd.equals("")) throw  new Exception("DDD Invalido");
        this.ddd = ddd;
    }

    public String getNumero() {
        return numeroTelefone;
    }

    public void setNumero(String numeroTelefone)throws Exception{
        if ( numeroTelefone.equals("")) throw new Exception("Campo Numero de telefone esta vazio!!");
        if ( numeroTelefone.length() <= 8  ) throw new Exception("Campo Numero de telefone esta incorrreto!! < 8 ");
        this.numeroTelefone = numeroTelefone;
    }

    @Override
    public String toString() {
        return  ddi + ";" + ddd + ";" + numeroTelefone;
    }
    
}
