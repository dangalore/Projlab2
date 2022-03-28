package projlab;

public class Bag extends Equipment{
    private final int capacity;

    public Bag() {
        capacity = 10;
    }

    @Override
    public void EquipTo(Virologist virologist){
        super.EquipTo(virologist);
        virologist.AddCapacity(capacity);
    }

    @Override
    public void RemoveFrom(Virologist v){
        super.RemoveFrom(v);
        v.AddCapacity(-capacity);
        //Todo: ha a kapacitasa kisebb mint amennyi cucc van nala, akkor dobjon el dolgokat
        v.ReSize(capacity);
    }

    @Override
    public String ToString(){
        return "Zsak";
    }
}
