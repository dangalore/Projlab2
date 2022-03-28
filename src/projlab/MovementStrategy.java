package projlab;

public interface MovementStrategy {
    void Move(Field f, Virologist v);
    boolean Mugged(Virologist victim, int amino, int nucleo);
    boolean Mugged(Virologist v, Equipment e);
    String ToString();
}
