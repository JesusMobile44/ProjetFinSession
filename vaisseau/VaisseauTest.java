package vaisseau;

import dechets.Matiere;
import org.junit.jupiter.api.Test;
import planetes.AlphaRomeo;
import planetes.Planete;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by BelSi1731422 on 2018-05-07.
 */
class VaisseauTest {
    @Test
    void triAvantLeDépot() {
        Planete planete = new AlphaRomeo();
        Vaisseau vaisseau = new Lourd();
        vaisseau.remplir(planete);
        vaisseau.triAvantLeDépot();
        assertEquals( 244,vaisseau.getCargo().get(29).getMasseVolumique());
    }

    @org.junit.jupiter.api.Test
    void getCargo() {
    }

    @org.junit.jupiter.api.Test
    void setCargo() {
    }

    @org.junit.jupiter.api.Test
    void getMaxCapacite() {
    }

    @org.junit.jupiter.api.Test
    void setMaxCapacite() {
    }

    @org.junit.jupiter.api.Test
    void getNom() {
    }

    @org.junit.jupiter.api.Test
    void setNom() {
    }

    @org.junit.jupiter.api.Test
    void remplir() {
        Planete planete = new AlphaRomeo();
        Vaisseau vaisseau = new Leger();
        vaisseau.remplir(planete);
        assertEquals(vaisseau.getCargo().size(), vaisseau.getMaxCapacite());
    }

}