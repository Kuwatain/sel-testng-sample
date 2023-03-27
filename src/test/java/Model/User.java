package Model;

import org.apache.commons.lang3.RandomStringUtils;

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
    private String userName;
    private String password;
    private String userId;
    private String token;

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
        this.userName = RandomStringUtils.randomAlphabetic(15);
        this.password = RandomStringUtils.randomAlphanumeric(15) + "8Aa!";
        this.userId = null;
        this.token = null;
        this.gender = "Male";
        this.number = "9655857796";
        this.dateOfBirth = "08 March,1998";
        this.subjects = "Civics, Hindi";
        this.hobbies = "Sports, Reading, Music";
        this.picture = "BaseTest.java";
        this.currentAddress = "Kazan";
        this.stateAndCity = "NCR Delhi";
        this.age = "24";
        this.salary = "0";
        this.department = "Yerevan";
    }

    public User(
            String userName,
            String password
    ) {
        this.userName = userName;
        this.password = password;
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

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }

    public String getUserId() {
        return userId;
    }

    public User setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public User setToken(String token) {
        this.token = token;
        return this;
    }
//        public  User  setAge(String age) {
//        this.age = age;
//        return  this;
//    }
}
