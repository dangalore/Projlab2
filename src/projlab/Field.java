package projlab;

import java.util.*;
import java.util.EnumMap;

public class Field {

    public enum Direction {
        TOP,
        BOTTOM,
        RIGHT,
        LEFT;

        public static Direction RandomDirection(){
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }

    private List<Virologist> virologists;
    private EnumMap<Direction, Field> neighbours;

    public Field() {
        virologists = new ArrayList<Virologist>();
        neighbours = new EnumMap<>(Direction.class);
    }

    public void AddNeighbour(Field f, Direction d) {
        neighbours.put(d, f);
    }

    public Field GetNeighbour(Field f, Direction d){
        Field neighbourField = new Field();
        neighbourField = neighbours.get(d);
        return neighbourField;
    }

    public void AddVirologist(Virologist v) {
        virologists.add(v);
    }

    public void RemoveVirologist(Virologist v) {
        virologists.remove(v);
    }

    public Field RandomNeighbour(){
        return neighbours.get(Direction.RandomDirection());
    }

    public void GiveResourceToVirologist(Virologist v, int amino, int nucleo){}

    public void GiveEquipmentToVirologist(Virologist v){}

    public String ToString(){
        return ("Ures mezo");
    }
}
