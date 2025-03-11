package jm.task.core.jdbc.model;

import javax.persistence.*;

@Table( schema = "JDBC_Schema", name = "Users1")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", unique=false, length=50)
    private String name;

    @Column(name = "lastname", unique = false, length = 50)
    private String lastname;

    @Column(name = "age", unique = false, length = 100)
    private Byte age;

    public User() {

    }

    public User( String name, String lastname, Byte age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;

    }

    public Long getId() {return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }
}
