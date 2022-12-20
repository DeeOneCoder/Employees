import java.util.*;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Employee dave = new Employee("David John", 35);
        Employee mike = new Employee("Mike John", 13);
        Employee jane = new Employee("Jane John", 49);
        Employee louis = new Employee("Mike Joe", 53);
        Employee blue = new Employee("Red Hart", 23);
        Employee jude = new Employee("Jude High", 50);

        List<Employee> employees = new ArrayList<>();
        employees.add(dave);
        employees.add(mike);
        employees.add(jane);
        employees.add(louis);
        employees.add(blue);
        employees.add(jude);

        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(' '));
        };

        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0, employee.getName().indexOf(' '));
        };

        Random random = new Random();
        for(Employee employee : employees){
            if (random.nextBoolean()) {
                System.out.println(getLastName.apply(employee));
            } else {
                System.out.println(getFirstName.apply(employee));
            }
        }




//
//        printEmployeesByAge(employees, "Employees over 30", employee -> (employee.getAge() > 30));
//        printEmployeesByAge(employees, "Employees 30 or less", employee -> employee.getAge() <= 30);
//
//        printEmployeesByAge(employees, "Employees younger than 25", employee -> employee.getAge() < 25);
//
//        IntPredicate over15 = i -> i > 15;
//        IntPredicate below100 = i -> i <= 100;
//
//        System.out.println(over15.and(below100).test(16));
//        System.out.println(over15.and(below100).test(100));
//
//        Random random = new Random();
//        Supplier<Integer> supplier = () -> random.nextInt(100);
//        for(int i = 0; i < 10; i++){
//            System.out.println(supplier.get());
//        }
//
//        employees.forEach(employee -> {
//            String lastName = employee.getName().substring(employee.getName().indexOf(' '));
//            System.out.println("Employee Last Name is: " + lastName);
//        });


/*
        System.out.println();
        System.out.println("Employees below 30");
        System.out.println("====================================");

        employees.forEach(employee -> System.out.print((employee.getAge() < 30) ? (employee.getName() + " is less than 30\n") : ""));
*/
    }

    private static String getAName(Function<Employee, String> getName, Employee employee){
        return getName.apply(employee);
    }

    private static void printEmployeesByAge(List<Employee> employees, String ageText, Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("====================================");
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }


}
