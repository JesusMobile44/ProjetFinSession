package vaisseau;

import dechets.Matiere;

/**
 * Created by BelSi1731422 on 2018-04-26.
 */
public class Lourd extends Vaisseau {
    public Lourd(Matiere cargo[]) {
        this.cargo = new Matiere[30];
        this.nom = "Lourd";
    }
}
