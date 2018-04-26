package vaisseau;

import dechets.Matiere;

/**
 * Created by BelSi1731422 on 2018-04-26.
 */
public class Leger extends Vaisseau {
    public Leger(Matiere cargo[], String nom) {
        this.cargo = new Matiere[10];
        this.nom = "Leger";
    }
}
