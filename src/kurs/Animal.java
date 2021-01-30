package kurs;

public abstract class Animal {
    private String name;
    private String maleName;
    private String femaleName;
    private int maxDistanceForRun;
    private int maxDistanceForSwim;
    private boolean male;
    private static int count;

    public Animal(String name, int maxDistanceForRun, int maxDistanceForSwim, boolean male,
                  String maleName, String femaleName) {
        this.name = name;
        this.maxDistanceForRun = maxDistanceForRun;
        this.maxDistanceForSwim = maxDistanceForSwim;
        this.male = male;
        this.maleName = maleName;
        this.femaleName = femaleName;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public void talk(String what) {
        System.out.printf("%s говорит: %s", String.format("%s %s", male ? maleName : femaleName, name), what);
    }

    public void run(int distance) {
        doSome(maxDistanceForRun, distance, "бегать", "беги", "пробежал");
    };

    public void swim(int distance) {
        doSome(maxDistanceForSwim, distance, "плавать", "плыви", "проплыл");
    };

    private void doSome(int maxDistance, int distance, String undefined, String imperative, String accomplished) {
        if (maxDistance == 0) {
            talk(String.format("сорри, я не умею %s!\n", undefined));
            return;
        }
        if (distance > maxDistance) {
            talk(String.format("та ну, сам %s аж %d м. (могу только %d м.)!\n", imperative, distance, maxDistance));
            return;
        }
        talk(String.format("это я мигом, %d м. - не расстояние%s, вот... %s%s!\n",
                distance, distance == maxDistance ? "" : String.format(" (могу и %d м.)", maxDistance),
                accomplished, male ? "" : "а"));
    }
}
