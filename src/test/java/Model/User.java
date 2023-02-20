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


    public User
            (
                    String firstName,
                    String lastName,
                    String email,
                    String gender,
                    String number,
                    String dateOfBirth,
                    String subjects,
                    String hobbies,
                    String picture,
                    String currentAddress,
                    String stateAndCity,
                    String age,
                    String salary,
                    String department
            ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.number = number;
        this.dateOfBirth = dateOfBirth;
        this.subjects = subjects;
        this.hobbies = hobbies;
        this.picture = picture;
        this.currentAddress = currentAddress;
        this.stateAndCity = stateAndCity;
        this.age = age;
        this.salary = salary;
        this.department = department;
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
    //    public  User  setNumber(String number) {
//        this.number = number;
//        return  this;
//    }
}
