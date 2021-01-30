package kurs;

public class Dog extends Animal{
    private static int count;

    public Dog(String name, boolean male) {
        super(name, 500, 10, male, "пес", "собака");
        count++;
    }

    public static int getCount() {
        return count;
    }
}
