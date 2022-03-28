package projlab;

public class Equipment {

    public Equipment() {

    }

    public void EquipTo(Virologist virologist){
        virologist.AddEquipment(this);
    }

    public boolean Defend(){
        return false;
    }

    public String ToString(){
        return "BaseEquipment";
    }

    public boolean CounterAttack(Virologist v, GeneticCode gc){
        return false;
    }

    public void RemoveFrom(Virologist v){
        v.RemoveEquipment(this);
    }
}
