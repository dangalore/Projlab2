package projlab;

public class AmnesiaVirus extends GeneticCode{

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
