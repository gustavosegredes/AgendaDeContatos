/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import visao.Telefone;

/**
 *
 * @author Gustavo Camargo
 */
public class Contato extends Telefone{
    //atributos
    private String cpf = "";
    private String nomeCompleto = "";
    private String email = "";
    //private Endereco endereco = null;
    private Telefone telefone = null;

    //Medotos
    public Contato() {
        this.cpf = "";
        this.nomeCompleto = "";
        this.email = "";
        telefone = new Telefone();
    }
    public Contato(String cpf,String nomeCompleto,String email, Telefone telefone)throws Exception{
        super(telefone.getDdi(), telefone.getDdd(), telefone.getNumero());
        if ( cpf.equals("") ) throw new Exception("Campo cpf esta vazio!!");
        this.cpf = cpf;
        if ( nomeCompleto.equals("") ) throw new Exception("Campo Nome esta vazio!!");
        this.nomeCompleto = nomeCompleto;
        if ( email.equals("") ) throw new Exception("Campo email esta vazio!!");
        this.email = email;
        this.telefone = telefone;
    }


    public String getCpf() {
        return cpf;
    }
    public String getCpfMascara() {
        char[] parte1 = new char[4];
        char[] parte2 = new char[4];
        char[] parte3 = new char[4];
        char[] parte4 = new char[2];
        cpf.getChars(0, 3, parte1, 0);
        cpf.getChars(3, 6, parte2, 0);
        cpf.getChars(6, 9, parte3, 0);
        cpf.getChars(9, 11, parte4, 0);
        StringBuilder sb = new StringBuilder();
        sb.append(parte1);
        sb.append(".");
        sb.append(parte2);
        sb.append(".");
        sb.append(parte3);
        sb.append("-");
        sb.append(parte4);
        
        String cpfTratado;
        cpfTratado = sb.toString();
        return cpfTratado;
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
        return  cpf + ";" + nomeCompleto + ";" + email + ";" + telefone.getDdi()  + ";" + telefone.getDdd() + ";" + telefone.getNumero();
    }
    @Override
    public String getDdi(){
        return telefone.getDdi();
    }
    @Override
    public String getDdd(){
        return telefone.getDdd();
    }
    @Override
    public String getNumero(){
        return telefone.getNumero();
    }
    @Override
    public void setDdi(String ddi) throws Exception{
        if ( ddi.equals("")) throw  new Exception("DDI Invalido");
        telefone.setDdi(ddi);
    }
    @Override
    public void setDdd(String ddd)throws Exception{
        if ( ddd.equals("")) throw  new Exception("DDD Invalido");
        telefone.setDdd(ddd);
    }
    @Override
    public void setNumero(String numeroTelefone)throws Exception{
         if ( numeroTelefone.equals("")) throw new Exception("Campo Numero de telefone esta vazio!!");
        //if ( numeroTelefone.length() < 10 || numeroTelefone.length() <= 7  ) throw new Exception("Campo Numero de telefone esta incorrreto!!");
        telefone.setNumero(numeroTelefone);
    }
}
