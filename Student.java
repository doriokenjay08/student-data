/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author drinc
 */
public class Student {

    private int StudentId;
    private String firstName;
    private String lastName;
    private int age;
    private String course;
    private int ContactNo;
    private String email;
    private int YearLevel;
    private String FavoriteColor;
    private String address;

    private Student(StudentBuilder builder) {
        this.StudentId = builder.StudentId;
        this.firstName = builder.FirstName;
        this.lastName = builder.LastName;
        this.age = builder.age;
        this.course = builder.course;
        this.ContactNo = builder.ContactNo;
        this.email = builder.email;
        this.YearLevel = builder.YearLevel;
        this.FavoriteColor = builder.FavoriteColor;
        this.address = builder.address;
    }

    public int getStudentId() { return StudentId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public String getCourse() { return course; }
    public int getContactNo() { return ContactNo; }
    public String getEmail() { return email; }
    public int getYearLevel() { return YearLevel; }
    public String getFavoriteColor() { return FavoriteColor; }
    public String getAddress() { return address; }

    // ✅ STATIC NESTED BUILDER (ayon sa UML)
    public static class StudentBuilder {

        private int StudentId;
        private String FirstName;
        private String LastName;
        private int age;
        private String course;
        private int ContactNo;
        private String email;
        private int YearLevel;
        private String FavoriteColor;
        private String address;

        public StudentBuilder setStudentId(int StudentId) {
            this.StudentId = StudentId;
            return this;
        }

        public StudentBuilder setFirstName(String FirstName) {
            this.FirstName = FirstName;
            return this;
        }

        public StudentBuilder setLastName(String LastName) {
            this.LastName = LastName;
            return this;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder setCourse(String course) {
            this.course = course;
            return this;
        }

        public StudentBuilder setContactNo(int ContactNo) {
            this.ContactNo = ContactNo;
            return this;
        }

        public StudentBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public StudentBuilder setYearLevel(int YearLevel) {
            this.YearLevel = YearLevel;
            return this;
        }

        public StudentBuilder setFavoriteColor(String FavoriteColor) {
            this.FavoriteColor = FavoriteColor;
            return this;
        }

        public StudentBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
