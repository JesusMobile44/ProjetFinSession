package Centre;

import dechets.Matiere;
import planetes.*;
import vaisseau.Vaisseau;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by BelSi1731422 on 2018-05-03.
 */
public class CentreDeTri {
    private HashMap<String,Pile> mapPile;
    private File fileVaisseau;

    public HashMap<String, Pile> getMapPile() {
        return mapPile;
    }

    public void setMapPile(HashMap<String, Pile> mapPile) {
        this.mapPile = mapPile;
    }

    public File getFileVaisseau() {
        return fileVaisseau;
    }

    public void setFileVaisseau(File fileVaisseau) {
        this.fileVaisseau = fileVaisseau;
    }

    public LinkedList<Vaisseau> getFileDattente() {
        return fileDattente;
    }

    public void setFileDattente(LinkedList<Vaisseau> fileDattente) {
        this.fileDattente = fileDattente;
    }

    public Planete[] getListeDesPlanètes() {
        return listeDesPlanètes;
    }

    public void setListeDesPlanètes(Planete[] listeDesPlanètes) {
        this.listeDesPlanètes = listeDesPlanètes;
    }

    public LinkedList<CentreDeTri> getCentreDeTris() {
        return centreDeTris;
    }

    public void setCentreDeTris(LinkedList<CentreDeTri> centreDeTris) {
        this.centreDeTris = centreDeTris;
    }

    LinkedList<Vaisseau> fileDattente = new LinkedList<Vaisseau>();
    protected Planete[] listeDesPlanètes = {new AlphaRomeo() , new BravoTerre(), new CharlieJupiter(), new DeltaNeptune() , new QuebecVenus()};
    protected LinkedList<CentreDeTri> centreDeTris = new LinkedList<>();
    public CentreDeTri(){
        this.mapPile = creerHashMap();
    }


    public void recyclerPile(Pile pile){
        
    }
    public void charger(Vaisseau vaisseau){
        for (int i=vaisseau.getMaxCapacite()-1;i>=0;i--){
            Pile pileTemp = mapPile.get(vaisseau.getCargo().get(i).getNom());
            if (pileTemp.getPile().size()==pileTemp.getMax()-1){
                recyclerPile(pileTemp);
            }
            mapPile.get(vaisseau.getCargo().get(i).getNom()).getPile().add(vaisseau.getCargo().get(i));
        }
    }

    public HashMap<String,Pile> creerHashMap(){
        HashMap<String,Pile> map  = new HashMap<>();
        map.put("Gadolinium",new Pile("Gadonilium"));
        map.put("Neptunium",new Pile("Neptunium"));
        map.put("Plutonium",new Pile("Plutonium"));
        map.put("Terbium",new Pile("Terbium"));
        map.put("Thulium",new Pile("Thulium"));
        return map;
    }
}
