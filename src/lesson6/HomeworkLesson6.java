package lesson6;

abstract class Animals {
    String name;
    double runDistance;
    double jumpHeight;

    public Animals(
            String name,
            double runDistance,
            double jumpHeight){
        this.name = name;
        this.runDistance = runDistance;
        this.jumpHeight = jumpHeight;
    }

    public boolean run(double length){
        return runDistance > length ? true : false;
    };
    public boolean jump(double high){
        return jumpHeight > high ? true : false;
    };
    public abstract boolean swim(double length);
}

class Cat extends Animals {

    public Cat(String name, double runDistance, double jumpHeight) {
        super(name, runDistance, jumpHeight);
    }

    @Override
    public boolean swim(double length) {
        return false;
    }
}

class Dog extends Animals {
    double swimDistance;
    public Dog(String name, double runDistance, double jumpHeight, double swimDistance) {
        super(name, runDistance, jumpHeight);
        this.swimDistance = swimDistance;
    }

    @Override
    public boolean swim(double length) {
        return swimDistance > length ? true : false;
    }
}

public class HomeworkLesson6 {
    public static void main(String[] args) {
        double catRunDistance1 = 50.0;
        double catRunDistance2 = 150.0;
        double catJumpHeight1 = 2.0;
        double catJumpHeight2 = 4.0;

        double dogRunDistance1 = 150.0;
        double dogRunDistance2 = 250.0;
        double dogJumpHeight1 = 0.5;
        double dogJumpHeight2 = 2.0;

        double dogSwimDistance1 = 50.0;
        double dogSwimDistance2 = 250.0;

        Cat catA = new Cat("CatA", 100.0, 3.0);
        Dog dogA = new Dog("DogA", 200.0, 1.0, 100.0);

        System.out.println(
                catA.name + "\n" + " run " + catRunDistance1 + ": " + catA.run(catRunDistance1) + "\n"
                        + " swim" + ": " + catA.swim(100.0) + "\n"
                        + " jump " + catJumpHeight1 + ": " + catA.jump(catJumpHeight1));
        System.out.println(
                catA.name + "\n" + " run " + catRunDistance2 + ": " + catA.run(catRunDistance2) + "\n"
                        + " swim" + ": " + catA.swim(100.0) + "\n"
                        + " jump " + catJumpHeight2 + ": " + catA.jump(catJumpHeight2));

        System.out.println(
                dogA.name + "\n" + " run " + dogRunDistance1 + ": " + dogA.run(dogRunDistance1) + "\n"
                        + " swim " + dogSwimDistance1 + ": " + dogA.swim(dogSwimDistance1) + "\n"
                        + " jump " + dogJumpHeight1 + ": " + dogA.jump(dogJumpHeight1));
        System.out.println(
                dogA.name + "\n" + " run " + dogRunDistance2 + ": " + dogA.run(dogRunDistance2) + "\n"
                        + " swim " + dogSwimDistance2 + ": " + dogA.swim(dogSwimDistance2) + "\n"
                        + " jump " + dogJumpHeight2 + ": " + dogA.jump(dogJumpHeight2));

    }
}
