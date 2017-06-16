package org.ncmao.domain;

//@XmlRootElement(name = "student")
public class Student {

    private String name;
    private int age;



    public String getName() {
        return name;
    }

//    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

//    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }
}
