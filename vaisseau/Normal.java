package vaisseau;

import dechets.Matiere;

/**
 * Created by BelSi1731422 on 2018-04-26.
 */
public class Normal extends Vaisseau {
    public Normal(Matiere cargo[]) {
        this.cargo = new Matiere[20];
        this.nom = "Normal";
    }
}
