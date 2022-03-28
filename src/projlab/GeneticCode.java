package projlab;

public abstract class GeneticCode {
    int aminoCost;
    int nucleoCost;
    int duration;

    public int GetAminoCost(){
        return aminoCost;
    }

    public int GetNucleoCost(){
        return nucleoCost;
    }

    public void ApplyEffect(Virologist v){
        v.AddActive(this);
    }

    public abstract void RemoveEffect(Virologist v);

    public void Reapply(Virologist v){
        //nothing
    }

    public abstract boolean CheckImmune(GeneticCode gc);

    public boolean ImmuneTo(StunVirus sv){
        return false;
    }

    public boolean ImmuneTo(DanceVirus dv){
        return false;
    }

    public boolean ImmuneTo(AmnesiaVirus av){
        return false;
    }

    public String ToString(){
        return "BaseCode";
    }

    public int GetDuration() {
        return duration;
    }
}
