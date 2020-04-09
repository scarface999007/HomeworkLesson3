package lesson7;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public boolean decreaseFood(int n) {
        if(food >= n){
            food-=n;
            return true;
        } else {
            System.out.println("Недостаточно еды");
            return false;
        }
    }
    public void info() {
        System.out.println("plate: " + food);
    }

    public void setFood(int n){
        if(n > 0){
            food += n;
        } else {
            System.out.println("Нельзя добавить отрицательное количество еды");
        }
    }
}
