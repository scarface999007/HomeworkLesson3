package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean isSatiety = false;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }
    public void eat(Plate p) {
       isSatiety = p.decreaseFood(appetite);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", isSatiety=" + isSatiety +
                '}';
    }
}
