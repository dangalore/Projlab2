package projlab;

public class Gloves extends Equipment{
    public Gloves() {

    }

    @Override
    public boolean CounterAttack(Virologist v, GeneticCode gc)
    {
        if (v.CheckImmunity(gc))
            return true;
        for (Equipment e: v.GetEquipment())
            if (e.Defend())
                return true;
        gc.ApplyEffect(v);
        return true;
    }

    @Override
    public String ToString(){
        return "Kesztyu";
    }
}
