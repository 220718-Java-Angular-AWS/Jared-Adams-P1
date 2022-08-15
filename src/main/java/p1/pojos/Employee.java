package p1.pojos;

import java.util.Objects;

public class Employee {

    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private boolean admin;


    public Employee() {
    }

    public Employee(Integer employeeId, String firstName, String lastName, String username, String email, String password, boolean admin) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.admin = admin;
    }

    public Employee(String firstName, String lastName, String email, String username, String password, boolean admin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.admin = admin;
    }

    public Employee(Integer employeeId, String firstName, String lastName, String username, String email, String password) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;

    }

    public Employee(String credentials, String password) {
        this.email = credentials;
        this.username = credentials;
        this.password = password;
    }

    public Integer getEmployeeId() {

        return employeeId;
    }


    public void setEmployeeId(Integer employeeId) {

        this.employeeId = employeeId;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) && Objects.equals(username, employee.username) &&
                Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) &&
                Objects.equals(email, employee.email) && Objects.equals(password, employee.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, username, firstName, lastName, email, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + employeeId +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}