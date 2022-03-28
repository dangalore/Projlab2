package projlab;

public class AmnesiaVaccine extends GeneticCode{
    public AmnesiaVaccine(int aminoCost, int nucleoCost, int duration) {
        this.aminoCost = aminoCost;
        this.nucleoCost = nucleoCost;
        this.duration = duration;
    }

    /**
     * A kapott genetikai kód ellen ellenőrzi az immunitást.
     *
     * @param i genetikai kód, ami ellen ellenőrzi, az immuitást.
     * @return alapesetben false, minden
     */
    @Override
    public boolean CheckImmune(GeneticCode i) {
        return false;
    }

    /**
     *
     * @param av A virus, amely ellen ellenorzi az immunitast.
     * @return
     */
    @Override
    public boolean ImmuneTo(AmnesiaVirus av){
        return true;
    }

    /**
     *
     * @param v
     */
    public void RemoveEffect(Virologist v){
        v.RemoveActive(this);
    }

    @Override
    public String ToString(){
        return "Felejtes elleni vakcina";
    }

}
