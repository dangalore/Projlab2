package projlab;

import java.util.Random;

public class Dancing implements MovementStrategy{
    public void Move(Field f, Virologist v) {
        Field next = v.RandomNeighbour();
        v.RemoveFromField();
        next.AddVirologist(v);
        v.SetCurrentField(next);
    }
    public boolean Mugged(Virologist victim, int amino, int nucleo){return false;}

    public boolean Mugged(Virologist v, Equipment e){
        return false;
    }

    public String ToString(){
        return "Tancolo";
    }

}
