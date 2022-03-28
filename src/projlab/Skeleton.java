package projlab;

import java.util.Scanner;


//Todo: roundManager, Steppable, Game
//Todo: exceptions, stackelt equipmentek;

public class Skeleton {
    public void Start(){
        while(true){
            //Virologist player = new Virologist(20, 5, 5, new Normal(), new Field());
            System.out.println(
                    """
                    
                    
                    Valassz menupontot:
                    
                    1. Virologus normal modon mozog
                    2. Benult virologus mozog
                    3. Tancolo virologus mozog
                    4. Agens felhasznalasa mas virologuson
                    5. Agens felhasznalasa mas, kesztyuvel rendelkezo virologuson
                    6. Agens felhasznalasa mas, kopennyel rendelkezo virologuson
                    7. Agens felhasznalasa onmagadon
                    8. Genetikai kód megtanulása laborból
                    9. Anyag felvetele raktarbol
                    10. Felszereles felvetele ovohelyrol
                    11. Anyag lopasa mas virologustol
                    12. Felszereles lopasa mas virologustol
                    
                    0. Kilepes
                    """);
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            switch (choice){
                case (0): break;
                case (1): {
                    NormalMozgas();
                }break;
                case (2): {
                    BenultMozgas();
                }break;
                case (3): {
                    TancolvaMozgas();
                }break;
                case (4): {
                    AgensHasznalata();
                }break;
                case (5): {
                    AgensHasznalataKesztyusre();
                }break;
                case (6): {
                    AgensHasznalataKopenyesre();
                }break;
                case (7): {
                    AgensOnamagadon();
                }break;
                case (8): {
                    Kodtanulas();
                }break;
                case (9): {
                    AnyagFelvetele();
                }break;
                case (10): {
                    FelszerelesFelvetele();
                }break;
                case (11): {
                    AnyagLopasa();
                }break;
                case (12): {
                    FelszerelesLopasa();
                }break;
                default: {
                    System.out.println("Nincs ilyen menupont!\n");
                }break;
            }
            if (choice == 0)
                break;
        }
    }

    public void NormalMozgas(){
        System.out.println("Normal mozgas\n");
        Virologist player = new Virologist(20, 5, 5, new Normal(), new Field());
        System.out.println("Elotte:\n");
        System.out.println(player.ToString());
        Storage sf = new Storage(10, 10);
        player.Move(sf);
        System.out.println("Utana:\n");
        System.out.println(player.ToString());
    }

    public void BenultMozgas(){
        System.out.println("Benult mozgas\n");
        Virologist player = new Virologist(20, 5, 5, new Stunned(), new Field());
        System.out.println("Elotte:\n");
        System.out.println(player.ToString());
        player.Move(new Storage(10,10));
        System.out.println("Utana:\n");
        System.out.println(player.ToString());
    }

    public void TancolvaMozgas(){
        System.out.println("Tancolo mozgas:\n");
        Field cf = new Field();
        cf.AddNeighbour(new Storage(10,10), Field.Direction.LEFT);
        cf.AddNeighbour(new Field(), Field.Direction.BOTTOM);
        cf.AddNeighbour(new Haven(new Bag()), Field.Direction.RIGHT);
        cf.AddNeighbour(new Lab(new StunVirus(1,1,3)), Field.Direction.TOP);
        Virologist player = new Virologist(20, 5, 5, new Dancing(), cf);
        System.out.println("Elotte:\n");
        System.out.println(player.ToString());
        player.Move(new Storage(10,10));
        System.out.println("Utana:\n");
        System.out.println(player.ToString());
    }

    public void AgensHasznalata()
    {
        System.out.println("Agens hasznalata:\n");
        Field f = new Field();
        Virologist playerOne = new Virologist(20, 5, 5, new Normal(), f);
        Virologist playerTwo = new Virologist(20, 5, 5, new Normal(), f);
        StunVirus sv = new StunVirus( 1, 2, 3);
        playerOne.LearnCode(sv);
        System.out.println("Elotte:\n");
        System.out.println(playerOne.ToString());
        System.out.println(playerTwo.ToString());
        playerOne.UseCode(playerTwo, sv);
        System.out.println("Utana:\n");
        System.out.println(playerOne.ToString());
        System.out.println(playerTwo.ToString());

    }

    public void AgensHasznalataKesztyusre()
    {
        System.out.println("Agens hasznalata kesztyuvel rendelkezo virologuson:\n");
        Field f = new Field();
        Virologist playerOne = new Virologist(20, 5, 5, new Normal(), f);
        Virologist playerTwo = new Virologist(20, 5, 5, new Normal(), f);
        StunVirus sv = new StunVirus( 1, 2, 3);
        playerTwo.AddEquipment(new Gloves());
        playerOne.LearnCode(sv);
        System.out.println("Elotte:\n");
        System.out.println(playerOne.ToString());
        System.out.println(playerTwo.ToString());
        playerOne.UseCode(playerTwo, sv);
        System.out.println("Utana:\n");
        System.out.println(playerOne.ToString());
        System.out.println(playerTwo.ToString());
    }

    public void AgensHasznalataKopenyesre()
    {
        System.out.println("Agens hasznalata kopennyel rendelkezo virologuson:\n");
        Field f = new Field();
        Virologist playerOne = new Virologist(20, 5, 5, new Normal(), f);
        Virologist playerTwo = new Virologist(20, 5, 5, new Normal(), f);
        StunVirus sv = new StunVirus( 1, 2, 3);
        playerTwo.AddEquipment(new Cape());
        playerOne.LearnCode(sv);
        System.out.println("Elotte:\n");
        System.out.println(playerOne.ToString());
        System.out.println(playerTwo.ToString());
        playerOne.UseCode(playerTwo, sv);
        System.out.println("Utana:\n");
        System.out.println(playerOne.ToString());
        System.out.println(playerTwo.ToString());

    }

    public void AgensOnamagadon()
    {
        System.out.println("Agens hasznalata Onmagan:\n");
        Virologist playerOne = new Virologist(20, 5, 5, new Normal(), new Field());
        StunVaccine sv = new StunVaccine( 1, 2, 3);
        playerOne.LearnCode(sv);
        System.out.println("Elotte:\n");
        System.out.println(playerOne.ToString());
        playerOne.UseCode(playerOne, sv);
        System.out.println("Utana:\n");
        System.out.println(playerOne.ToString());
    }

    public void Kodtanulas()
    {
        System.out.println("Kod tanulasa: \n");
        AmnesiaVirus am = new AmnesiaVirus(1, 2, 3);
        Lab lf = new Lab(am);
        Virologist playerOne = new Virologist(20, 5, 5, new Normal(), lf);
        System.out.println("Elotte:\n");
        System.out.println(playerOne.ToString());
        playerOne.LearnCode(am);
        System.out.println("Utana:\n");
        System.out.println(playerOne.ToString());
    }

    public void AnyagFelvetele()
    {
        System.out.println("Virologus anyagot vesz fel: \n");
        Virologist playerOne = new Virologist(20, 5, 5, new Normal(), new Storage(5,5));
        System.out.println("Elotte:\n");
        System.out.println(playerOne.ToString());
        playerOne.PickupResource(5, 3);
        System.out.println("Utana:\n");
        System.out.println(playerOne.ToString());
    }

    public void FelszerelesFelvetele()
    {
        System.out.println("Virologus felszerelest vesz fel: \n");
        Virologist playerOne = new Virologist(20, 5, 5, new Normal(), new Haven(new Cape()));
        System.out.println("Elotte:\n");
        System.out.println(playerOne.ToString());
        playerOne.PickupEquipment();
        Haven hg = new Haven( new Gloves());
        playerOne.Move(hg);
        playerOne.PickupEquipment();
        Haven hb = new Haven(new Bag());
        playerOne.Move(hb);
        playerOne.PickupEquipment();
        System.out.println("Utana:\n");
        System.out.println(playerOne.ToString());
    }

    public void AnyagLopasa()
    {
        System.out.println("A virologus anyagot lop egy masik virologustol: \n");
        Field f = new Field();
        Virologist playerOne = new Virologist(20, 5, 5, new Normal(), f);
        Virologist playerTwo = new Virologist(20, 5, 5, new Stunned(), f);
        System.out.println("Elotte:\n");
        System.out.println(playerOne.ToString());
        System.out.println(playerTwo.ToString());
        playerOne.StealResource(playerTwo, 4, 3);
        System.out.println("Utana:\n");
        System.out.println(playerOne.ToString());
        System.out.println(playerTwo.ToString());
    }

    public void FelszerelesLopasa()
    {
        System.out.println("A virologus felszerelst lop egy masik virologustol: \n");
        Bag b = new Bag();
        Haven f = new Haven(b);
        Virologist playerOne = new Virologist(20, 5, 5, new Normal(), f);
        Virologist playerTwo = new Virologist(20, 5, 5, new Stunned(), f);
        playerTwo.PickupEquipment();
        System.out.println("Elotte:\n");
        System.out.println(playerOne.ToString());
        System.out.println(playerTwo.ToString());
        playerOne.StealEquipment(playerTwo, b);
        System.out.println("Utana:\n");
        System.out.println(playerOne.ToString());
        System.out.println(playerTwo.ToString());
    }
}
