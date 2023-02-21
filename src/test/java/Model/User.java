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
    private String gender;
    private String dateOfBirth;
    private String subjects;
    private String hobbies;
    private String picture;
    private String stateAndCity;

    public User(String firstName, String lastName, String email, String age, String salary, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }


    public User(
            String firstName,
            String lastName,
            String email
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender =  "Male";
        this.number = "9655857796";
        this.dateOfBirth =  "08 March,1998";
        this.subjects =  "Civics, Hindi";
        this.hobbies = "Sports, Reading, Music";
        this.picture = "BaseTest.java";
        this.currentAddress = "Kazan";
        this.stateAndCity = "NCR Delhi";
        this.age = "24";
        this.salary = "0";
        this.department = "Yerevan";
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

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSubjects() {
        return subjects;
    }

    public String getHobbies() {
        return hobbies;
    }

    public String getPicture() {
        return picture;
    }

    public String getStateAndCity() {
        return stateAndCity;
    }
//        public  User  setAge(String age) {
//        this.age = age;
//        return  this;
//    }
}
