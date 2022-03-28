package projlab;

public class Normal implements MovementStrategy{
    public void Move(Field f, Virologist v){
        v.RemoveFromField();
        f.AddVirologist(v);
        v.SetCurrentField(f);
    }

    public boolean Mugged(Virologist victim, int amino, int nucleo){return false;}
    public boolean Mugged(Virologist v, Equipment e){
        return false;
    }
    public String ToString(){
        return "Normal";
    }


}
