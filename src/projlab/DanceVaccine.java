package projlab;

public class DanceVaccine extends GeneticCode{
    public DanceVaccine(int aminoCost, int nucleoCost, int duration) {
        this.nucleoCost = nucleoCost;
        this.aminoCost = aminoCost;
        this.duration = duration;
    }

    @Override
    public boolean CheckImmune(GeneticCode i) {
        return false;
    }

    @Override
    public boolean ImmuneTo(DanceVirus dv){
        return true;
    }

    @Override
    public void RemoveEffect(Virologist v){
        v.RemoveActive(this);
    }

    @Override
    public String ToString(){
        return "Tanc elleni vakcina";
    }
}
