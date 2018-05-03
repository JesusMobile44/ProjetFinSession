package vaisseau;

import dechets.Matiere;

import java.util.ArrayList;

/**
 * Created by BelSi1731422 on 2018-04-26.
 */
public class Normal extends Vaisseau {
    public Normal(ArrayList<Matiere> cargo, String nom, int maxCap) {
        this.cargo = new ArrayList<>();
        this.nom = "Normal";
        this.maxCapacite = 20;
    }
}
