package lesson5;

class Employee {
    private String fio;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    Employee(String fio, String position, String email, String phone, int salary, int age){
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fio='" + fio + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public String getFio() {
        return fio;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }
}

public class HomeworkLesson5 {
    public static void main(String[] args) {
        int numEmployees = 5;
        Employee [] employees = new Employee[numEmployees];
        employees[0] = new Employee("Ivanov Ivan", "Engineer", "qwe@mail.ru",
                "+79991112211", 500000, 27);
        employees[1] = new Employee("Petrov Petr", "Teacher", "asd@mail.ru",
                "+79991112222", 400000, 28);
        employees[2] = new Employee("Vasiliev Vasiliy", "Director", "zxc@mail.ru",
                "+79991112233", 300000, 29);
        employees[3] = new Employee("Alexandrov Alexander", "Driver", "qaz@mail.ru",
                "+79991112244", 200000, 40);
        employees[4] = new Employee("Androidov Android", "Phone", "wsx@mail.ru",
                "+79991112255", 100000, 41);

        for (int i = 0; i < numEmployees; i++) {
            if(employees[i].getAge() >= 40){
                System.out.println("Старше сорока");
                System.out.println(employees[i].toString());
            }
        }

    }
}
