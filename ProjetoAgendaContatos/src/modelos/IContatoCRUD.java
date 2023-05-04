/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelos;
//import java.util.ArrayList;

import java.util.ArrayList;


/**
 *
 * @author Gustavo Camargo
 */
public interface IContatoCRUD {
    public void incluir(Contato objContato)throws Exception;
    public void alterar(Contato objContato) throws Exception;
    public boolean excluir(String cpf) throws Exception;
    public Contato buscar(String cpf) throws Exception;
    public ArrayList<Contato> listagemDeContatos() throws Exception;
}
