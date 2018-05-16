package Centre;

import dechets.Matiere;
import planetes.*;
import vaisseau.Vaisseau;

import java.io.File;
import java.util.*;

/**
 * Created by BelSi1731422 on 2018-05-03.
 */
public class CentreDeTri {
    private HashMap<String,Pile> mapPile = creerHashMap();
    private File fileVaisseau;
    private CentreDeTri next;
    private int nbCentre;
    LinkedList<Vaisseau> fileDattente = new LinkedList<Vaisseau>();
    protected Planete[] listeDesPlanètes = {new AlphaRomeo() , new BravoTerre(), new CharlieJupiter(), new DeltaNeptune() , new QuebecVenus()};
    protected LinkedList<CentreDeTri> listeCentreDeTris = new LinkedList<>();

    public static void créationCentres(LinkedList<CentreDeTri> listeCentreDeTris){
        int nbCentre = 5;
        for (int i=0;i<nbCentre;i++){
            listeCentreDeTris.add(new CentreDeTri());
        }
    }


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

    public LinkedList<CentreDeTri> getListeCentreDeTris() {
        return listeCentreDeTris;
    }

    public void setListeCentreDeTris(LinkedList<CentreDeTri> listeCentreDeTris) {
        this.listeCentreDeTris = listeCentreDeTris;
    }


    private ArrayList<Matiere> pileTempo = new ArrayList<>();



    public void recyclerPile(Vaisseau vaisseau,Pile pile,CentreDeTri autreCentre){
        int nbTorRecycle =((pile.getPile().peek().getPourcentage()/100)*pile.getMax());
        for (int i=0;i<nbTorRecycle;i++){
            vaisseau.getCargo().add(pile.getPile().pop());
            if (vaisseau.getCargo().size() == vaisseau.getMaxCapacite()){
                i=nbTorRecycle;
            }
        }
        vaisseau.setCentre(vaisseau.getCentre()+1);
        vaisseau.depot(listeCentreDeTris.get(vaisseau.getCentre()));
    }
    /*public void decharger(Vaisseau vaisseau){
        fileDattente.add(vaisseau);
        vaisseau.triAvantLeDépot();
        for (int i=0;i<)
        for (int i=vaisseau.getMaxCapacite()-1;i>=0;i--){
            Pile pileTemp = mapPile.get(vaisseau.getCargo().get(i).getNom());
            if (pileTemp.getPile().size()==pileTemp.getMax()-1){
                recyclerPile(vaisseau);
            }
            mapPile.get(vaisseau.getCargo().get(i).getNom()).getPile().add(vaisseau.getCargo().get(i));
        }
    }*/

    public HashMap<String,Pile> creerHashMap(){
        HashMap<String,Pile> map  = new HashMap<>();
        map.put("Gadolinium",new Pile("Gadonilium"));
        map.put("Neptunium",new Pile("Neptunium"));
        map.put("Plutonium",new Pile("Plutonium"));
        map.put("Terbium",new Pile("Terbium"));
        map.put("Thulium",new Pile("Thulium"));
        return map;
    }
    public void filePourAttendre (Vaisseau vaisseau){
        if (fileDattente.size() < 10){
            fileDattente.add(vaisseau);
        }

        else if (fileDattente.size() == 10){
            if (pileTempo.size()>0){
                while(pileTempo.size()>0&&vaisseau.getCargo().size()<vaisseau.getMaxCapacite()){
                    vaisseau.getCargo().add(pileTempo.get(0));
                    pileTempo.remove(0);
                }
                //envoyer vers le prochain centre
            }
            else{
                Random choix = new Random();
                fileDattente.peek().remplir(listeDesPlanètes[choix.nextInt(5)]);
                fileDattente.remove(0);
                fileDattente.add(vaisseau);
            }
        }
    }
    public void envoyerProchainCentre(CentreDeTri centreDeTri){
        CentreDeTri apres;
    }
}
