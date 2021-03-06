/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho;

import didatico.SubmarinoProducts;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.PortableServer.POAPackage.ServantNotActive;

/**
 *
 * @author Ana Paula Fidelis, Bárbara Marquez e Dener de Souza
 */
public class SubmarinoAdapter implements Loja{
    private SubmarinoProducts sub;
    private ArrayList<CD> listaCDs;

    private static SubmarinoAdapter uniqueInstance;
    
    private SubmarinoAdapter()
    {
        sub = SubmarinoProducts.getInstance();
    }
    
    //permite apenas uma instancia deste objeto
    public static SubmarinoAdapter getInstance()
    {
        if (uniqueInstance == null)
            uniqueInstance = new SubmarinoAdapter();
        
        return uniqueInstance; 
    }

    @Override
    public boolean conectar(String usuario, String senha) {
        try {
            sub.connect(usuario, senha);
        } catch (Exception ex) {
            Logger.getLogger(SubmarinoAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sub.isConnected();
    }

    @Override
    public void desconectar() {
        sub.disconnect();
    }

    @Override
    public Collection procurar(String chave)
    {
        ArrayList<CD> cdsBusca = new ArrayList();
        
        listaCDs.stream().filter((cd) -> (cd.equals(chave))).forEachOrdered((cd) -> {
            cdsBusca.add(cd);
        });
        
        return cdsBusca;
    }

    @Override
    public Collection ler()
    {
        listaCDs = new ArrayList();
        String[][] informacoesCDs = null;
        
        try {
            informacoesCDs = sub.getCDProducts();
        } catch (ServantNotActive ex) {
            Logger.getLogger(SubmarinoAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //percorre toda a matriz, cria o objeto CD e adiciona na lista
        if (informacoesCDs != null){
            for (String[] informacoesCD : informacoesCDs) { 
                CD cd = new CD(informacoesCD[2], informacoesCD[0], Double.parseDouble(informacoesCD[3]), "Submarino");
                listaCDs.add(cd);
            }
        }
        return listaCDs;
    }
}