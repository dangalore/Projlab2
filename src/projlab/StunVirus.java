package projlab;

public class StunVirus extends GeneticCode{

    public StunVirus(int aminoCost, int nucleoCost, int duration) {
        this.aminoCost = aminoCost;
        this.nucleoCost = nucleoCost;
        this.duration = duration;
    }

    public void ApplyEffect(Virologist v){
        super.ApplyEffect(v);
        v.SetMovement(new Stunned());
    }

    public void RemoveEffect(Virologist v){
        v.RemoveActive(this);
        v.SetMovement(new Normal());
        v.Reapply();
    }

    @Override
    public void Reapply(Virologist v){
        v.SetMovement(new Stunned());
    }

    public boolean CheckImmune(GeneticCode gc){
        return gc.ImmuneTo(this);
    }

    @Override
    public String ToString(){
        return "Benulas virus";
    }
}
