/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Gustavo Camargo
 */
public class Contato {
    //atributos
    private String cpf = "";
    private String nomeCompleto = "";
    private String email = "";
    //private Endereco endereco = null;
    //private Telefone telefone = null;

    //Medotos
    public Contato() {
        this.cpf = "";
        this.nomeCompleto = "";
        this.email = "";
    }
    public Contato(String cpf,String nomeCompleto,String email)throws Exception{
        if ( cpf.equals("") ) throw new Exception("Campo cpf esta vazio!!");
        this.cpf = cpf;
        if ( nomeCompleto.equals("") ) throw new Exception("Campo Nome esta vazio!!");
        this.nomeCompleto = nomeCompleto;
        if ( email.equals("") ) throw new Exception("Campo email esta vazio!!");
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws Exception{
        if ( cpf.equals("") ) throw new Exception("Campo cpf esta vazio!!");
        this.cpf = cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) throws Exception{
        if ( nomeCompleto.equals("") ) throw new Exception("Campo Nome esta vazio!!");
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email)throws Exception{
        if ( email.equals("") ) throw new Exception("Campo email esta vazio!!");
        this.email = email;
    }

    @Override
    public String toString() {
        return  cpf + ";" + nomeCompleto + ";" + email ;
    }

}
