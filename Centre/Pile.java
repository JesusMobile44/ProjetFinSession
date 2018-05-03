package Centre;

import dechets.Matiere;

import java.util.Stack;

/**
 * Created by BelSi1731422 on 2018-05-03.
 */
public class Pile extends CentreDeTri{
    private int max;
    private String type;
    private Stack<Matiere> pile;

    public Pile(String type){
        this.type = type;
        this.pile = new Stack<Matiere>();
        this.max = 50;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Stack<Matiere> getPile() {
        return pile;
    }

    public void setPile(Stack<Matiere> pile) {
        this.pile = pile;
    }
}
