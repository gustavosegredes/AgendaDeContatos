/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import java.util.ArrayList;
import modelos.Contato;
import modelos.IContatoCRUD;
import persistencia.ContatoDAO;

/**
 *
 * @author Gustavo Camargo
 */
public class ContatoController implements IContatoCRUD{
    //Atributos
    IContatoCRUD contatoPersistencia = null;
    ValidaCPF validarCPF = new ValidaCPF();
    ValidarEmail validaEmail = new ValidarEmail();
    
    public ContatoController() {
        contatoPersistencia = new ContatoDAO();
    }
    
    @Override
    public void incluir(Contato objContato) throws Exception {
        try {
            // Verificacao das regras
            // validando CPF
            if ( !validarCPF.isCPF(objContato.getCpf())) throw new Exception("CPF INVALIDO!!");
            if ( contatoPersistencia.buscar(objContato.getCpf()) != null) throw new Exception("Ja existe este CPF em sua agenda!!");

            // Validando Nome Completo - Se tem espaço / se nome e sobrenome tem -2 caracteres
            if(!objContato.getNomeCompleto().contains(" ")) throw new Exception("Nome invalido!!");
            if(objContato.getNomeCompleto().substring(0,objContato.getNomeCompleto().indexOf(" ")).length() < 2 || objContato.getNomeCompleto().substring(objContato.getNomeCompleto().lastIndexOf(" ") + 1).length() < 2) throw  new Exception("O nome e o sobrenome deve contrer pelo menos 2 caracteres");

            //Validar email
            if (!validaEmail.validate(objContato.getEmail()))throw new Exception("Email invalido!!");
            
            //Validar numero telefone
            if (objContato.getDdi().length() <0 )throw  new Exception("DDI nao pode ser menor que 0");
            if (objContato.getDdd().length() <0 )throw  new Exception("DDD nao pode ser menor que 0");
            if (objContato.getNumero().length() <0 )throw  new Exception("Numero nao pode ser menor que 0");
             if (objContato.getNumero().length() > 14 )throw  new Exception("Numero nao deve ter mas que 14 digitos");
            
            // Se passar pela validações ele adiciona o obj.
            contatoPersistencia.incluir(objContato);
        } catch (Exception erro) {
            String msg = "Metodo INCLUIR/ContatoController - " +erro.getMessage();
            throw new Exception(msg);
        }

    }

    @Override
    public Contato buscar(String cpf) throws Exception {
        try {
        //instancia com com referencia a contato e verifica passando parametro CPF
        Contato contato = contatoPersistencia.buscar(cpf);
        //Verifica se o campo cpf esta vazio, caso esteja retorna para preencher o campo
        if (cpf.equals("")) throw new Exception("Preencha o campo CPF para buscar o contato!");
        //verifica se retorno do contato esta null, caso esteja null -> retorna contato inexistente;
        if ( contato == null ) throw new Exception("Contato inexistente!");
        //se passar pela condição ele retorna o contato;
        return contato;
        } catch (Exception erro) {
            String msg = "Metodo BUSCAR/ContatoController - " +erro.getMessage();
            throw new Exception(msg);
        }

    }

    @Override
    public ArrayList<Contato> listagemDeContatos() throws Exception {
        try {
            // Verifica se a lista esta vazia
            if( contatoPersistencia.listagemDeContatos().isEmpty())throw new Exception("Lista de contatos esta vazia.");
               
            //retorna arraylist de contatos
            return contatoPersistencia.listagemDeContatos();
            
        } catch (Exception erro) {
            String msg = "Metodo ListagemDeContatos/ContatoController - " +erro.getMessage();
            throw new Exception(msg);
        }
    }

    @Override
    public boolean excluir(String cpf) throws Exception {
        //System.out.println(contatoPersistencia.excluir(cpf));
        //if (!contatoPersistencia.excluir(cpf)) throw new Exception("FALSE!!");
        return contatoPersistencia.excluir(cpf);      
    }

    @Override
    public void alterar(Contato objContato) throws Exception {
        try {
            // validando CPF
            if ( !validarCPF.isCPF(objContato.getCpf())) throw new Exception("CPF INVALIDO!!");
            //if ( contatoPersistencia.buscar(objContato.getCpf()) != null) throw new Exception("Ja existe este CPF em sua agenda!!");

            // Validando Nome Completo - Se tem espaço / se nome e sobrenome tem -2 caracteres
             if(!objContato.getNomeCompleto().contains(" ")) throw new Exception("Nome invalido!!");
             if(objContato.getNomeCompleto().substring(0,objContato.getNomeCompleto().indexOf(" ")).length() < 2 || objContato.getNomeCompleto().substring(objContato.getNomeCompleto().lastIndexOf(" ") + 1).length() < 2) throw  new Exception("O nome e o sobrenome deve contrer pelo menos 2 caracteres");

            //Validar email
            if (!validaEmail.validate(objContato.getEmail()))throw new Exception("Email invalido!!");
            
            //Validar numero telefone
            if (objContato.getDdi().length() <0 )throw  new Exception("DDI nao pode ser menor que 0");
            if (objContato.getDdd().length() <0 )throw  new Exception("DDD nao pode ser menor que 0");
            if (objContato.getNumero().length() <0 )throw  new Exception("Numero nao pode ser menor que 0");
            
            //Passsou validacoes envia objeto para persistencia
            contatoPersistencia.alterar(objContato);
        } catch (Exception erro) {
            String msg = "Metodo ALTERAR/ContatoController - " +erro.getMessage();
            throw new Exception(msg);
        }
        
    }


    
}
