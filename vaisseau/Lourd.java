package vaisseau;

import dechets.Matiere;

import java.util.ArrayList;

/**
 * Created by BelSi1731422 on 2018-04-26.
 */
public class Lourd extends Vaisseau {
    public Lourd() {
        this.cargo = new ArrayList<>();
        this.nom = "Lourd";
        this.maxCapacite = 30;
    }
}
