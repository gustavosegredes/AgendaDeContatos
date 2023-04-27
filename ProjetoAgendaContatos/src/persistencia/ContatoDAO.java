/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import modelos.IContatoCRUD;
import modelos.Contato;

/**
 *
 * @author Gustavo Camargo
 */
public class ContatoDAO implements IContatoCRUD {
    //Atributos
    private String nomeDoArquivoNoDisco = null;
    
    
    public ContatoDAO() {
        nomeDoArquivoNoDisco = "./src/bancodedados/contatosBD.txt";
    }
    @Override
    public void incluir(Contato objContato) throws Exception {
      try{
         //cria o arquivo
         FileWriter fw = new FileWriter(nomeDoArquivoNoDisco,true);
         //Criar o buffer do arquivo
         BufferedWriter bw = new BufferedWriter(fw);
         //Escreve no arquivo
         bw.write(objContato.toString()+"\n");
         //fecha o arquivo
         bw.close();		
      }catch(Exception erro){
        String msg = "Metodo Incluir Contato - "+erro.getMessage();
        throw new Exception(msg);
      }
    }

    @Override
    public Contato buscar(String cpf) throws Exception {
    try{
      FileReader fr = new FileReader(nomeDoArquivoNoDisco);
      BufferedReader br  = new BufferedReader(fr);
      String linha = "";
      while((linha=br.readLine())!=null){
        String vetorStr[] = linha.split(";");
        String cpfAux = vetorStr[0];
        String nomeCompleto = vetorStr[1];
        String email = vetorStr[2];
        Contato objetoContato = new Contato(cpfAux,nomeCompleto,email);
        if(cpf.equals(cpfAux)){
          br.close();
          return objetoContato;
        }
      }
      br.close();
      return null;
    }catch(Exception erro){
        String msg = "Metodo buscar Contato - "+erro.getMessage();
      throw new Exception(msg);
    }   
  }

    @Override
    public ArrayList<Contato> listagemDeContatos() throws Exception {
        ArrayList<Contato> agenda = new ArrayList();
        try {
            Contato contato;
            FileReader fr = new FileReader(nomeDoArquivoNoDisco);
            BufferedReader br  = new BufferedReader(fr);
            String linha = "";
            while((linha=br.readLine())!=null) {
                String vetorStr[] = linha.split(";");
                String cpf = vetorStr[0];
                String nomeCompleto = vetorStr[1];
                String email = vetorStr[2];
                contato = new Contato(cpf,nomeCompleto, email);
                agenda.add(contato);
            }
            return agenda;
        } catch(Exception erro) {
            String msg = "Metodo listagemDeContatos Contato - "+erro.getMessage();
            throw new Exception(msg);
        }

    }

    @Override
    public boolean excluir(String cpf) throws Exception {
        boolean r = false;
        ArrayList<Contato> auxAgenda = new ArrayList<>();
        auxAgenda = listagemDeContatos();
        Contato contato;
        ArrayList<Contato> auxAgendaAtual = new ArrayList<>();
        
        for(Contato i : auxAgenda){
            if(!i.getCpf().equals(cpf)){
                auxAgendaAtual.add(i );
             }else{
                r = true;
            }
        }
        FileWriter fw = new FileWriter(nomeDoArquivoNoDisco);
        BufferedWriter bw = new BufferedWriter(fw);
        System.out.println(auxAgenda);
        System.out.println(auxAgendaAtual);
        for(Contato i : auxAgendaAtual){
            bw.write(i.toString() + "\n");
        }
       
        bw.close();
        return r;           
       }
}
   
