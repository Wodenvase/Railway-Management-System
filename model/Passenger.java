```java
package model;

public class Passenger {
    private String name;
    private int age;
    private String gender;
    private String idProof;
    private String contactNumber;

    public Passenger(String name, int age, String gender, String idProof, String contactNumber) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.idProof = idProof;
        this.contactNumber = contactNumber;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    // Add remaining getters and setters
}
```