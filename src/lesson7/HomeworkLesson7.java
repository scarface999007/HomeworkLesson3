package lesson7;

public class HomeworkLesson7 {
    public static void main(String[] args) {

        int numCats = 6;
        Cat[] cats = new Cat[numCats];
        Plate plate = new Plate(100);
        plate.info();
        for (int i = 0; i < numCats; i++) {
            cats[i] = new Cat("Cat" + (i + 1), 5*(i+1));
            cats[i].eat(plate);
            System.out.println(cats[i].toString());
        }
        plate.info();
    }
}
