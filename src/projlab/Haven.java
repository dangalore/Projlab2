package projlab;

public class Haven extends Field{
    private Equipment equipment;

    public Haven(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public void GiveEquipmentToVirologist(Virologist v){
        if (equipment != null){
            equipment.EquipTo(v);
            this.equipment = null;
        }
    }

    @Override
    public String ToString(){
        if (equipment != null)
            return ("Ovohely -- " + equipment.ToString());
        else return "Ovohely -- Ures";
    }

    public void SetEquipment(Equipment e){
        equipment = e;
    }
}
