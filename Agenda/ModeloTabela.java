import javax.swing.table.AbstractTableModel;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.*;



public class ModeloTabela extends AbstractTableModel{

    private String[] nomeColuna = {"CÓDIGO", "NOME", "ENDEREÇO", "TELEFONE"};
    private List<Dados> listaDados= new ArrayList<Dados>();

    public ModeloTabela () {   
    }

    public int getRowCount(){
        if(listaDados == null){
            return 0;
    }
    return listaDados.size();
    }

    public int getColumnCount() {
        return nomeColuna.length;
    }

    
    public Object getValueAt(int linha, int coluna){        
        switch(coluna){
            case 0 :
                return listaDados.get(linha).getCodigo();
            case 1 : 
                return listaDados.get(linha).getNome();
            case 2 :
                return listaDados.get(linha).getEndereco();
            case 3 :
                return listaDados.get(linha).getTelefone();
            default : 
                return 0;
        }           
    }
 
    public String getColumnName(int indice) {
        return nomeColuna[indice];
    }   

    public Class getColClass(int coluna){

        switch(coluna) {
            case 0 : 
                return String.class;
            case 1 :
                return String.class;
            case 2 :
                return String.class;
            case 3 :
                return String.class;
            default :
            return null;
        }
    }

    public void setValueAt(Dados data) {

        listaDados.add(data);
        fireTableDataChanged();

    }
    public void ler(){
        listaDados.clear();
        File arq = new File( "dados.txt");
        try{
            FileReader fr = new FileReader(arq);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            String[] q = {""};
            Dados d;
            d = new Dados();
            for(int i=0; i<25; i++){
                if(line == null){
                    break;
                }
                q = line.split(";");
                d = new Dados(q[0],q[1],q[2],q[3]);
                setValueAt(d);
                line = br.readLine(); 
            }
            br.close();
            fr.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}

