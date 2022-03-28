package projlab;

public class Lab extends Field {
    private final GeneticCode code;

    public Lab(GeneticCode code) {
        this.code = code;
    }

    //public void Teach() {}

    @Override
    public String ToString(){
        return "Labor -- Genetikai kód: " + code.ToString();
    }
}
