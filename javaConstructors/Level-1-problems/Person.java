public class Person {
    private String name;
    private int age;

    // Parameterized constructor
    public Person(String name, int age) {
         this.name = name;
         this.age = age;
    }
    // Copy constructor
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Method to display person's information
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        
        // Creating a person using parameterized constructor
        Person person1 = new Person("Alice", 25);
        person1.displayInfo();

        System.out.println();

        // Creating a person using copy constructor
        Person person2 = new Person(person1);
        person2.displayInfo();
      
    }
} 
