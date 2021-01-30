package kurs;

public class Cat extends Animal{
    private static int count;

    public Cat(String name, boolean male) {
        super(name, 200, 0, male, "кот", "кошка");
        count++;
    }

    public static int getCount() {
        return count;
    }
}
