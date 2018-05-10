package vaisseau;

import Centre.CentreDeTri;
import Centre.Pile;
import dechets.*;
import planetes.Planete;

import java.util.*;

/**
 * Created by BelSi1731422 on 2018-04-26.
 */
public abstract class Vaisseau {
    protected ArrayList<Matiere> cargo;
    protected int maxCapacite;
    protected String nom;

    public ArrayList<Matiere> getCargo() {
        return cargo;
    }

    public void setCargo(ArrayList<Matiere> cargo) {
        this.cargo = cargo;
    }

    public int getMaxCapacite() {
        return maxCapacite;
    }

    public void setMaxCapacite(int maxCapacite) {
        this.maxCapacite = maxCapacite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void remplir(Planete planete){
        Random choix = new Random();
        int chanceGalo = planete.getNbganolinium();
        int chanceNept = planete.getNbNeptunium();
        int chancePlut = planete.getNbPlutonium();
        int chanceTerb = planete.getNbTerbium();
        int chanceThul = planete.getNbThulium();
        int probabilite[] = new int[100];
        int index;
        for (int i = 0; i < 100;i++){
            probabilite[i] = i;
        }
        for (int i =0; i< this.maxCapacite;i++){
            index = choix.nextInt(100);
            if (index < chanceGalo){
                this.cargo.add(new Gadolinium());
            }
            else if (index >= chanceGalo && index < (chanceGalo+chanceNept)){
                this.cargo.add(new Neptunium());
            }
            else if (index >= (chanceGalo+chanceNept) && index < (chanceGalo+chanceNept+chancePlut)){
                this.cargo.add(new Plutonium());
            }
            else if (index >= (chanceGalo+chanceNept+chancePlut) && index < (chanceGalo+chanceNept+chancePlut+chanceTerb)){
                this.cargo.add(new Terbium());
            }
            else if (index >= (chanceGalo+chanceNept+chancePlut+chanceTerb) && index <100){
                this.cargo.add(new Thulium());
            }
        }
    }
    //TRI Des ressources avant le dépot
    public void triAvantLeDépot()
    {
        int elementNonTrié[] = new int[this.maxCapacite];
        for (int i=0; i <this.maxCapacite;i++){
            if (this.cargo.get(i).getMasseVolumique() == new Gadolinium().getMasseVolumique()){
                elementNonTrié[i] = new Gadolinium().getMasseVolumique();
            }
            if (this.cargo.get(i).getMasseVolumique() == new Plutonium().getMasseVolumique()){
                elementNonTrié[i] = new Plutonium().getMasseVolumique();
            }
            if (this.cargo.get(i).getMasseVolumique() == new Neptunium().getMasseVolumique()){
                elementNonTrié[i] = new Neptunium().getMasseVolumique();
            }
            if (this.cargo.get(i).getMasseVolumique() == new Thulium().getMasseVolumique()){
                elementNonTrié[i] = new Thulium().getMasseVolumique();
            }
            if (this.cargo.get(i).getMasseVolumique() == new Terbium().getMasseVolumique()){
                elementNonTrié[i] = new Terbium().getMasseVolumique();
            }
        }
        int N = elementNonTrié.length;
        if (N == 0)
            return;
        int max = elementNonTrié[0], min = elementNonTrié[0];
        for (int i = 1; i < N; i++)
        {
            if (elementNonTrié[i] > max){
                max = elementNonTrié[i];
            }
            if (elementNonTrié[i] < min){
                min = elementNonTrié[i];
            }
        }
        int écart = max - min + 1;
        int[] count = new int[écart];
        for (int i = 0; i < N; i++){
            count[elementNonTrié[i] - min]++;
        }
        for (int i = 1; i < écart; i++){
            count[i] += count[i - 1];
        }
        int j = 0;
        for (int i = 0; i < écart; i++){
            while (j < count[i])
                elementNonTrié[j++] = i + min;
        }
        for (int i = 0; i <this.maxCapacite;i++){
            if (elementNonTrié[i] == new Gadolinium().getMasseVolumique() )
                this.cargo.set(i,new Gadolinium());

            if (elementNonTrié[i] == new Plutonium().getMasseVolumique())
                this.cargo.set(i,new Plutonium());

            if (elementNonTrié[i] == new Neptunium().getMasseVolumique())
                this.cargo.set(i,new Neptunium());

            if (elementNonTrié[i] == new Terbium().getMasseVolumique())
                this.cargo.set(i,new Terbium());

            if (elementNonTrié[i] == new Thulium().getMasseVolumique())
                this.cargo.set(i, new Thulium());
        }
    }
    public void depot (CentreDeTri centreDeTri)
    {
        this.triAvantLeDépot();

        for(int i=0;i< this.maxCapacite ;i++){
            if (this.getCargo().get(i) instanceof Gadolinium){
                Pile pile =centreDeTri.getMapPile().get("Gadolinium");
                if (pile.getPile().size()<pile.getMax()){
                    pile.getPile().push(this.getCargo().get(i));
                }
                else{
                    centreDeTri.recyclerPile(pile);
                }
            }
            if (this.getCargo().get(i) instanceof Neptunium){
                Pile pile =centreDeTri.getMapPile().get("Neptunium");
                if (pile.getPile().size()<pile.getMax()){
                    pile.getPile().push(this.getCargo().get(i));
                }
                else{
                    centreDeTri.recyclerPile(pile);
                }
            }
            if (this.getCargo().get(i) instanceof Plutonium){
                Pile pile =centreDeTri.getMapPile().get("Plutonium");
                if (pile.getPile().size()<centreDeTri.getMapPile().get("Plutonium").getMax()){
                    pile.getPile().push(this.getCargo().get(i));
                }
                else{
                    centreDeTri.recyclerPile(pile);
                }
            }
            if (this.getCargo().get(i) instanceof Terbium){
                Pile pile =centreDeTri.getMapPile().get("Terbium");
                if (pile.getPile().size()<pile.getMax()){
                    centreDeTri.getMapPile().get("Terbium").getPile().push(this.getCargo().get(i));
                }
                else{
                    centreDeTri.recyclerPile(pile);
                }
            }
            if (this.getCargo().get(i) instanceof Thulium){
                Pile pile =centreDeTri.getMapPile().get("Thulium");
                if (pile.getPile().size()<pile.getMax()){
                    pile.getPile().push(this.getCargo().get(i));
                }
                else{
                    centreDeTri.recyclerPile(pile);
                }
            }
            centreDeTri.filePourAttendre(this);
        }
    }
}