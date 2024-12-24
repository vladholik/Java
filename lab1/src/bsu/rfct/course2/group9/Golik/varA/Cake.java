package bsu.rfct.course2.group9.Golik.varA;

import java.util.Objects;

public class Cake extends Food {

    private String icing = "";
    private static int chocolateCakesAmount = 0;
    private static int creamyCakesAmount = 0;
    private static int caramelCakesAmount = 0;
    static final String Chocolate = "Chocolate";
    static final String Creamy = "Creamy";
    static final String Caramel = "Caramel";

    public Cake(String icing) throws InvalidIcingException {
        this.icing = icing;
        this.name = "Cake";

        switch (icing) {
            case (Chocolate):
                this.calories = 100;
                chocolateCakesAmount++;
                break;
            case (Creamy):
                this.calories = 200;
                creamyCakesAmount++;
                break;
            case (Caramel):
                this.calories = 300;
                caramelCakesAmount++;
                break;
            default:
                throw new InvalidIcingException("Invalid cake icing");
        }
    }



    public int Amount(){
        return switch (icing) {
            case (Chocolate) -> chocolateCakesAmount;
            case (Creamy) -> creamyCakesAmount;
            case (Caramel) -> caramelCakesAmount;
            default -> 0;
        };
    }

    @Override
    public String toString() {
        return "Cake{" +
                "icing='" + icing + '\'' +
                ", calories=" + calories +
                '}';
    }

    public void consume(){
        System.out.println(icing + " " + name + " has been eaten.");
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cake cake = (Cake) o;
        return Objects.equals(icing, cake.icing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(icing);
    }

    @Override
    public int calculateCalories() {
        return calories;
    }
}
