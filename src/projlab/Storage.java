package projlab;

public class Storage extends Field {
    private int amino;
    private int nucleo;

    public Storage(int amino, int nucleo) {
        this.amino = amino;
        this.nucleo = nucleo;
    }

    //Todo: Ha nem fér bele annyi, akkor annyit rakjon el amennyit tud.
    @Override
    public void GiveResourceToVirologist(Virologist v, int amino, int nucleo){
        //Idea: radnom számú aminot és nucle-ot add hozzá, ahol a ranodm szám 5-10 között van.
        if (v.CheckSpace(amino, nucleo) && this.amino >= amino && this.nucleo >= nucleo){
            v.AddResource(amino, nucleo);
            this.amino -= amino;
            this.nucleo -= nucleo;
            System.out.println(this.nucleo+this.amino);
        }
            // boolean virologist checkspace = amino nucleo < capacity;
            //ha igen akkor megnézem, hogy van e annyi a filden. Ha mind a kettő igen akkor, virologisthez hozzáad, és fieldről levon.
    }

    @Override
    public String ToString(){
        return "Raktar -- Aminosav: " + amino + " -- Nukleotid: " + nucleo;
    }
}
