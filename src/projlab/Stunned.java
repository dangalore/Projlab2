package projlab;

public class Stunned implements MovementStrategy{
    public void Move(Field f, Virologist v){

    }

    public boolean Mugged(Virologist victim, int amino, int nucleo){
        return victim.EnoughResources(amino, nucleo);
    }

    public boolean Mugged(Virologist v, Equipment e){
        return v.GetEquipment().contains(e);
    }
    public String ToString(){
        return "Benult";
    }
}
