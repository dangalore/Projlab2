package projlab;

public class Virologist {
    private int capacity;
    private int amino;
    private int nucleo;
    private List<GeneticCode> active;
    private List<GeneticCode> codes;
    private MovementStrategy movement;
    private Field currentField;
    private List<Equipment> equipment;


    /**
     * A virologus konstruktora.
     * @param capacity
     * @param amino
     * @param nucleo
     * @param mov
     * @param cf
     */
    public Virologist(int capacity, int amino, int nucleo, MovementStrategy mov, Field cf) {
        this.amino = amino;
        this.capacity = capacity;
        this.nucleo = nucleo;
        this.movement = mov;
        codes = new ArrayList<GeneticCode>();
        active = new ArrayList<GeneticCode>();
        currentField = cf;
        equipment = new ArrayList<Equipment>();
        currentField.AddVirologist(this);
    }

    /**
     * Megtanul egy genetikai kodót amit eddig nem ismert még.
     * @param gc a megatnulandó genetikai kód.
     */
    public void LearnCode(GeneticCode gc){
        if (!codes.contains(gc))
            codes.add(gc);
    }

    /**
     * Beállítja a jelenlegi Filed-et a kapott paraméterre.
     * @param f a field ahova a Virologus most lépett, ez lesz aza field ahol jelenleg áll.
     */
    public void SetCurrentField(Field f){
        currentField = f;
    }

    /**
     * A virologus megkapja, hogy melyik field legyen a következő ahova lép.
     * @param f A következő field.
     */
    public void Move(Field f){
        movement.Move(f, this);
    }
    //Todo: ellenőrizni, hogy a Move kapott f fieldje, szomszédos-e a currentFielddel.

    /**
     * A paraméterként kapott virologusra felhasználja a genetikai kódót.
     * A célzott virologus lehet saját maga is.
     * Ha nincs elég reasource nem hivodik meg a függvény.
     * Ha immunis a kiszemelt virologus akkor nem történik semmmi.
     * Ha a kiszemelt virologus kesztyűt visel, visszakeni a támadóra akin már csak a köpeny segíthet.
     * Ha a kiszemelt virologuson nincs kesztyű csak a köpeny menthet meg.
     * Ha sehol nem lépett ki a függvény, a genetikai kód alkalmazódik a másik virologusra.
     * @param otherVirologist kiszemlt virologus, lehet önmaga is
     * @param gc    felkenni kivánt ágens.
     */
    public void UseCode(Virologist otherVirologist, GeneticCode gc ){
        if (!this.codes.contains(gc))
            return;
        if (!EnoughResources(gc.GetAminoCost(), gc.GetNucleoCost()))
            return;
        this.amino -= gc.GetAminoCost();
        this.nucleo -= gc.GetNucleoCost();

        //saját magára alkalmazza
        if(otherVirologist == this)
        {
            gc.ApplyEffect(this);
            return;
        }

        //immunitas csekkolása
        if (otherVirologist.CheckImmunity(gc))
            return;

        //visszakenés kesztyűvel
        for(Equipment e: otherVirologist.equipment){
            if (e.CounterAttack(this, gc))
                return;
        }

        //kivédés köpennyel
        for(Equipment e: otherVirologist.equipment)
            if (e.Defend())
                return;
        gc.ApplyEffect(otherVirologist);
    }

    /**
     * A virologus felvesz X amino és Y nucleo resource-t egy mezőről.
     * @param amino felvenni kivánt amino mennyisége
     * @param nucleo    felvenni kivánt nucleo mennyisége
     */
    //Todo: Ellenőrzése, hogy a megfelelő mezőn all-e?
    public void PickupResource(int amino, int nucleo) {
        currentField.GiveResourceToVirologist(this, amino, nucleo );
    }

    //Todo:Ha vakcinát kap akkor a hozzá tartozó virús szünjön meg.

    /**
     * Hozzáadja az active genetikai kódókhoz a kapottgenetikai kódót.
     * Ha ezáltal valamelyikre immunis lesz, annak effektje megszünik.
     * @param gc A genetikai kód amit hozzászeretnénk adni az active kódókhoz.
     */
    public void AddActive(GeneticCode gc){
        active.add(gc);
        for (GeneticCode i: active)
            if (CheckImmunity(i))
                i.RemoveEffect(this);
    }

    /**
     * Az active genetikai kódok közül eltávolítjuk azt amit paraméterben kapunk.
     * @param gc Az eltávolitandó genetikai kód.
     */
    public void RemoveActive(GeneticCode gc) {
        active.remove(gc);
    }

    /**
     * Amnesia vírus hatására elfelejtük az összes már megtanult genetikai kódot.
     */
    public void ForgetCodes(){
        codes.clear();
    }

    /**
     * Ha a virologus tovább lép, eltávolitjuk az adott Field-ről amin állt.
     */
    public void RemoveFromField(){
        currentField.RemoveVirologist(this);
    }

    /**
     * Megnézi, hogy a paraméterként kapott genetikai kódra immunis-e a virologus.
     * @param gc Amire szeretnénk megnézni, hogy immunis-e.
     * @return Ha immunis true-val ha nem immunis false-szal tér vissza.
     */
    public boolean CheckImmunity(GeneticCode gc){
        for(GeneticCode i: active){
            if (gc.CheckImmune(i)) return true;
        }
        return false;
    }

    /**
     * Randomolunk egy Field-et ami szomszédos azzal ahol most állunk.
     * @return A véletlenszerűen kiválasztott field.
     */
    public Field RandomNeighbour(){
        return currentField.RandomNeighbour();
    }

    /**
     * Megnézi, hogy van-e elegendő helye a virologúsnak, ha felvenné a paraméterként kapott resource-kat.
     * @param am Felvevendő amoniosav mennyisége
     * @param nuc Felvevendő nukleosav mennyisége
     * @return Bool eredménye, hogy feltudná-e venni.
     */
    //Resource:
    public boolean CheckSpace(int am, int nuc){
        if (this.amino+am+this.nucleo+nuc <= capacity)
            return true;
        return false;
    }

    /**
     * A virologúshoz adja a paraméterben megkapott aminosav és nukleosav mennyiséget.
     * @param amino Virologúshoz adandó aminosav
     * @param nucleo Virologúshoz adandó nukleosav
     */
    public void AddResource(int amino, int nucleo) {
        this.amino +=amino;
        this.nucleo += nucleo;
    }


    /**
     * Kibőviti a virológus kapacitását.
     * @param capacity Ennyivel bővítit a kapacitást.
     */
    //Equipment:
    public void AddCapacity(int capacity){
        this.capacity += capacity;
    }

    /**
     * A virológus felvesz felszerelést a jelenlegi Field-ről.
     */
    public void PickupEquipment(){
        currentField.GiveEquipmentToVirologist(this);
    }

    /**
     * Végig megy az összes aktív genetikai kódon és mindegyiknek meghívja a Reapply függvényét.
     *
     */
    public void Reapply(){
        for (GeneticCode i: active)
            i.Reapply(this);
    }

    /**
     * A paraméterként kapott felszerelést hozzáadja a saját felszerléseihez, ha nincs több mint 3 felszerelése.
     * @param e A hozzáadandó felszerelés.
     */
    public void AddEquipment(Equipment e){
        if (equipment.size() <= 3)
            equipment.add(e);
    }

    /**
     * Eltávolítja a virológus felszerlései közül a paraméterként kapottat.
     * @param e Ezt a felszerelést távolítja el.
     */
    public void RemoveEquipment(Equipment e){
        equipment.remove(e);
    }

    /**
     * Át állítja a Mozgási stratégiját/lehetősgét a paraméterként kapottra.
     * @param m Ez lesz az új mozgási stratégiája.
     */
    public void SetMovement(MovementStrategy m){
        movement = m;
    }

    /**
     * A virologús egy másik virologústól lop resource-t.
     * Ha azonos Fielden állnak.
     * Ha eltud venni annyit.
     * Ha van elég hely neki, hogy elraktározza.
     * @param otherVirologist kitől
     * @param amino mennyi aminosav
     * @param nucleo mennyi nukleosav
     */
    //Steal:
    public void StealResource(Virologist otherVirologist, int amino, int nucleo)
    {
        if(otherVirologist.currentField == this.currentField)
            if (otherVirologist.Mugged(amino, nucleo))
                if(this.CheckSpace(amino, nucleo)){
                    otherVirologist.amino -= amino;
                    otherVirologist.nucleo -= nucleo;
                    this.amino += amino;
                    this.nucleo += nucleo;
                }
    }

    /**
     * A virologús egy másik virologústól lop felszerlést.
     * Ha azonos mezőn állnak.
     * Ha van nála olyan.
     * Ha eltudja rakni.
     * @param v kitől
     * @param e mit.
     */
    public void StealEquipment(Virologist v, Equipment e){
        if(v.currentField == this.currentField)
            if (v.Mugged(e))
                if(equipment.size() < 3) {
                    e.RemoveFrom(v);
                    e.EquipTo(this);
                }
    }

    /**
     * Az adott virológus rendelkezik-e a paraméterként megkapott aminosav és nukleosav mennyiséggel.
     * @param amino Rendelkezik-e ennyi aminosavval.
     * @param nucleo Rendelkezik-e ennyi nukleosavval.
     * @return Ha rendelkezik true-val ha nem rendelkezik false-szal tér vissza.
     */
    public boolean EnoughResources(int amino, int nucleo)
    {
        if (this.amino- amino >= 0 && this.nucleo -nucleo >= 0)
        {
            return true;
        }
        return false;
    }

    /**
     * Van-e a virológusnak a paraméterként megkapott mennyisége az eggyes resource-kból.
     * @param amino Rendelkezik-e ennyi aminosavval.
     * @param nucleo Rendelkezik-e ennyi nukleosavval.
     * @return Ha rendelkezik a megadott mennyiségekkel true-val, ha nem false-szal tér vissza.
     */
    public boolean Mugged(int amino, int nucleo){
        return movement.Mugged(this, amino, nucleo);
    }

    /**
     * A virológus rendelkezik-e a paraméterként kapott felszereléssel.
     * @param e A kérdésés felszerelés.
     * @return Ha rendelekzik true-val ha nem false-szal tér vissza.
     */
    public boolean Mugged(Equipment e){
        return movement.Mugged(this, e);
    }

    /**
     *Equipment getter-e
     * @return A virolugsnál fellelhető felszerlésekből álló listával tér vissza.
     */
    public List<Equipment> GetEquipment(){
        return equipment;
    }

    /**
     * Amennyiben a virlógus elveszti a táskáját, a kapacitás feletti részek arányos változnak meg.
     * @param difference A táska kapacitása.
     */
    public void ReSize(int difference) {
        int oldCap = capacity + difference;
        int current = this.amino + nucleo;
        if (current <= capacity)
            return;
        int leftover = current - capacity;
        double aminoMinus = leftover * (this.amino / (double)current);
        amino -= aminoMinus;
        nucleo -= (leftover - aminoMinus);
    }

    /**
     * Stringé alakítja az osztály adatait.
     * @return
     */
    public String ToString(){
        String knownCodes = "";
        String activeCodes = "";
        String eq = "";
        for (GeneticCode i : codes)
            knownCodes += (i.ToString() + ' ');
        for (GeneticCode i : active)
            activeCodes += (i.ToString() + ' ' + i.GetDuration()) + " korig, ";
        for (Equipment i: equipment)
            eq += (i.ToString() + ' ');
        return ("Jelenlegi mezo: " + currentField.ToString() + '\n' +
                "Mozgasi mod: " + movement.ToString() + '\n' +
                "Kapacitas: " + capacity + '\n' +
                "Aminosavak: " + amino + '\n' +
                "Nukleotidok: " + nucleo + '\n' +
                "Ismert kodok: " + knownCodes + '\n' +
                "Aktiv agensek: " + activeCodes + '\n' +
                "Felszereles: " + eq + '\n'
                );
    }
}
