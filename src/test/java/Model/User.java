package Model;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private String salary;
    private String department;
    private String number;
    private String currentAddress;

    public User(String firstName, String lastName, String email, String age, String salary, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public User(String firstName, String lastName, String email, String number, String currentAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.number = number;
        this.currentAddress = currentAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public String getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getNumber() {
        return number;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

//    public  User  setNumber(String number) {
//        this.number = number;
//        return  this;
//    }
}
