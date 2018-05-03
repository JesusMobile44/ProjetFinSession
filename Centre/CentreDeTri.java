package Centre;

import dechets.Matiere;
import vaisseau.Vaisseau;

import java.io.File;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by BelSi1731422 on 2018-05-03.
 */
public class CentreDeTri {
    private HashMap<String,Pile> mapPile;
    private File fileVaisseau;
    public CentreDeTri(){
        this.mapPile = creerHashMap();
    }
    public void recyclerPile(Pile pile){

    }
    public void charger(Vaisseau vaisseau){
        /*for (int i=vaisseau.getMaxCapacite()-1;i>=0;i--){
            if (vaisseau.getCargo().get(i).getNom().equals("Gadolinium")){
                Pile pileTemp = mapPile.get("Gadolinium");
                pileTemp.getPile().add(vaisseau.getCargo().get(i));

            }                               ca ne marche pas
        }*/
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
