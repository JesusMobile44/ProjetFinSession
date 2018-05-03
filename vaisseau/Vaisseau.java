package vaisseau;

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

    public void remplir(Vaisseau vaisseau, Planete planete){
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
        for (int i =0; i< vaisseau.maxCapacite;i++){
            index = choix.nextInt(100);
            if (index < chanceGalo){
                vaisseau.cargo.add(new Gadolinium());
            }
            else if (index >= chanceGalo && index < (chanceGalo+chanceNept)){
                vaisseau.cargo.add(new Neptunium());
            }
            else if (index >= (chanceGalo+chanceNept) && index < (chanceGalo+chanceNept+chancePlut)){
                vaisseau.cargo.add(new Plutonium());
            }
            else if (index >= (chanceGalo+chanceNept+chancePlut) && index < (chanceGalo+chanceNept+chancePlut+chanceTerb)){
                vaisseau.cargo.add(new Terbium());
            }
            else if (index >= (chanceGalo+chanceNept+chancePlut+chanceTerb) && index <100){
                vaisseau.cargo.add(new Thulium());
            }
        }
    }
}

