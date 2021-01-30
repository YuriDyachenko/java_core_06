package kurs;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    Animal[] animals = new Animal[5];

        System.out.println("--- заполнение массива животных ---");
        fillAnimals(animals);

        System.out.println("--- сколько всего объектов создано ---");
        outCreated();

        System.out.println("--- сколько объектов хранится в массиве ---");
        outInArray(animals);

        System.out.println("--- случайно выбирается расстояние и что делать ---");
        doSomeRandom(animals);
    }

    private static void doSomeRandom(Animal[] animals) {
        Random randomWhat = new Random();
        Random randomDistance = new Random();
        int attempts = 10;
        while (attempts > 0) {
            int who = (attempts - 1) % 5;
            int what = randomWhat.nextInt(10) % 2;
            int distance = (randomDistance.nextInt(600)) / 10 * 10 + 10;
            if (what == 0)
                animals[who].run(distance);
            else
                animals[who].swim(distance);
            attempts--;
        }
    }

    private static void outCreated() {
        String created = "Создано объектов %s: %d\n";
        System.out.printf(created, "Animal", Animal.getCount());
        System.out.printf(created, "Cat", Cat.getCount());
        System.out.printf(created, "Dog", Dog.getCount());
    }

    private static void outInArray(Animal[] animals) {
        int countCat = 0;
        int countDog = 0;
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] instanceof Cat)
                countCat++;
            else
                if (animals[i] instanceof Dog)
                    countDog++;
        }
        String created = "В массиве объектов %s: %d\n";
        System.out.printf(created, "Animal", animals.length);
        System.out.printf(created, "Cat", countCat);
        System.out.printf(created, "Dog", countDog);
    }

    private static void fillAnimals(Animal[] animals) {
        putAnimalToAnimals(animals, new Cat("Барсик", true));
        putAnimalToAnimals(animals, new Dog("Шарик", true));
        putAnimalToAnimals(animals, new Cat("Тигра", false));
        putAnimalToAnimals(animals, new Dog("Белка", false));
        putAnimalToAnimals(animals, new Cat("Чернышка", false));
        putAnimalToAnimals(animals, new Dog("Малыш", true));
    }

    private static void putAnimalToAnimals(Animal[] animals, Animal animal) {
        int place = findPlaceInAnimals(animals);
        if (place == -1) {
            animal.talk("ну не помещаюсь же уже, куда пихаешь?\n");
            return;
        }
        animals[place] = animal;
        animal.talk("ура, я в домике!\n");
    }

    private static int findPlaceInAnimals(Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) return i;
        }
        return -1;
    }
}
