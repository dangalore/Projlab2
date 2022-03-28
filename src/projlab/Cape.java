package projlab;


import java.util.Random;

public class Cape extends Equipment{
    public Cape() {

    }

    @Override
    public boolean Defend() {
        int chance = getRandomNumberInRange(1, 1000);
        return chance <= 823;
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    @Override
    public String ToString(){
        return "Kopeny";
    }
}
