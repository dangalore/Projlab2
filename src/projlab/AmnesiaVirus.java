package projlab;

public class AmnesiaVirus extends GeneticCode{
    public AmnesiaVirus(int aminoCost, int nucleoCost, int duration) {
        this.aminoCost = aminoCost;
        this.nucleoCost = nucleoCost;
        this.duration = duration;
    }

    @Override
    public void ApplyEffect(Virologist v){
        v.ForgetCodes();
    }

    @Override
    public void RemoveEffect(Virologist v) {

    }

    public boolean CheckImmune(GeneticCode gc){
        return gc.ImmuneTo(this);
    }

    @Override
    public String ToString(){
        return "Felejto virus";
    }
}
