package projlab;

import java.util.Random;

public class DanceVirus extends GeneticCode {

    public DanceVirus(int aminoCost, int nucleoCost, int duration){
        this.aminoCost = aminoCost;
        this.nucleoCost = nucleoCost;
        this.duration = duration;
    }

    public void ApplyEffect(Virologist v) {
        super.ApplyEffect(v);
        v.SetMovement(new Normal());
        v.SetMovement(new Dancing());
    }

    @Override
    public void RemoveEffect(Virologist v) {
        v.RemoveActive(this);
    }

    @Override
    public void Reapply(Virologist v){
        v.SetMovement(new Dancing());
    }

    public boolean CheckImmune(GeneticCode gc) {
        return gc.ImmuneTo(this);
    }

    @Override
    public String ToString(){
        return "Tanc virus";
    }
}
