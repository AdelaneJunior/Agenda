import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;



public class RegistroDados{

    File arquivo = new File("dados.txt");

    public RegistroDados(){  
    }


    public void gravar(String codigo, String nome, String endereco, String telefone, String anotacao){

        if(nome.isEmpty()){
            nome = " ";
        }
        if(endereco.isEmpty()){
            endereco = " ";
        }
        if(telefone.isEmpty()){
            telefone = " ";
        }

        if(arquivo.exists()){
            try {
                FileWriter fw = new FileWriter(arquivo, true);
                PrintWriter pw = new PrintWriter(fw);
                
                pw.print(codigo+";");
                pw.print(nome+";");
                pw.print(endereco+";");
                pw.print(telefone+";");
                pw.println(anotacao+";");
                
                pw.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
        else{
            try {
                boolean criaArq = arquivo.createNewFile();
                try {
                    FileWriter fw = new FileWriter(arquivo, true);
                    PrintWriter pw = new PrintWriter(fw);
                    pw.print(codigo+";");
                    pw.print(nome+";");
                    pw.print(endereco+";");
                    pw.print(telefone+";");
                    pw.println(anotacao+";");
  
                  
                    pw.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public void excluir(String apagar){      

        try{
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            
            String linha= br.readLine();
            
            ArrayList<String> salvar =  new ArrayList<>();

            while(linha != null) {

                if(linha.startsWith(apagar)==false) {
                    
                    salvar.add(linha);
                }
                linha = br.readLine();
            }
            br.close();
          
        
            FileWriter fw2 = new FileWriter(arquivo,true);
            fw2.close();
            FileWriter fw = new FileWriter(arquivo,false);
            PrintWriter pw = new PrintWriter(fw);

            for(int i = 0; i < salvar.size(); i++) {
                pw.println(salvar.get(i));
            }

            pw.close();
          
        }catch(IOException e){
         e.printStackTrace();
        }
    }

    public String[] consultacod(String codigo){
        if(codigo.startsWith(" ")){
            return null;
        }
        try{
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha= br.readLine();
            while(linha.startsWith(codigo)==false){
                linha = br.readLine();
            }
            
            br.close();
            String[] resultado;
            resultado = linha.split(";");
            return resultado;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public String[][] consultanome(String nome, ModeloTabela modelo){

        if(nome.startsWith(" ")){
            return null;
        }
        try{
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            String linha= br.readLine();
            String[][]resultados=new String [5][5];
            String[][] retorno = new String[5][5];
            String []b = new String[5];
            String a = new String(); 
            int n =0;
            if(modelo.getRowCount()>=1){
            for(int i=0; i<modelo.getRowCount();i++){
                if(nome.equals(modelo.getValueAt(i, 1))){
                    resultados[n][0] = linha;
                    n++;
                }
                linha = br.readLine();
            }
            for(int i=0;i<n;i++){
                if(resultados[i][0]!=null){
                    a = resultados[i][0];
                    b =a.split(";");
                    retorno[i][0] = b[0];
                    retorno[i][1] = b[1];
                    retorno[i][2] = b[2];
                    retorno[i][3] = b[3];
                    retorno[i][4] = b[4];
                }

            }
            br.close();
            return retorno;
        }
        br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public void altera(String codigo, String nome, String endereco, String telefone, String anotacao){

        try{
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            
            String linha= br.readLine();
            String novo = (codigo+";"+nome+";"+endereco+";"+telefone+";"+anotacao);
            ArrayList<String> salvar =  new ArrayList<>();

            while(linha != null) {

                if(linha.startsWith(codigo)==false) {
                    
                    salvar.add(linha);
                }else{
                    salvar.add(novo);
                }
                linha = br.readLine();
            }
            br.close();
          
        
            FileWriter fw2 = new FileWriter(arquivo,true);
            fw2.close();
            FileWriter fw = new FileWriter(arquivo,false);
            PrintWriter pw = new PrintWriter(fw);

            for(int i = 0; i < salvar.size(); i++) {
                pw.println(salvar.get(i));
            }

            pw.close();
          
        }catch(IOException e){
         e.printStackTrace();
        }


    }

    public String geracod(int linhas){

        try{
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            String cod = ("P"+linhas);
            int n = 1;
            int i = 0;
            String linha= br.readLine();
            while(i <linhas){
                if(linha==null){
                    br.close();
                    return cod;
                }
                if((linha.startsWith(cod))==false){
                    linha = br.readLine(); 
                }
                else{
                    cod= ("P"+(linhas+n));
                    n++;
                    linha = br.readLine();
                }
                i++;
            }
           
            br.close();
            return cod;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}