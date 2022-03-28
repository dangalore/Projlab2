package projlab;

public class StunVaccine extends GeneticCode{

    public StunVaccine(int aminoCost, int nucleoCost, int duration) {
        this.aminoCost = aminoCost;
        this.nucleoCost = nucleoCost;
        this.duration = duration;
    }

    @Override
    public boolean CheckImmune(GeneticCode i) {
        return false;
    }

    @Override
    public boolean ImmuneTo(StunVirus sv){
        return true;
    }
    @Override
    public void RemoveEffect(Virologist v){
        v.RemoveActive(this);
    }

    @Override
    public String ToString(){
        return "Benulas elleni vakcina";
    }
}
