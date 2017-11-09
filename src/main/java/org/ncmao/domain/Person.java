package org.ncmao.domain;

import java.io.Serializable;

public class Person implements Serializable {

    private Long id;
    private String name;
    private int age;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

/**
 * @Id
 * @Column(length = 30)
 * private String cityCode;
 * @Column(length = 30, nullable = false, unique = true)
 * private String cityName;
 * @ManyToOne(fetch = FetchType.EAGER, optional = false)
 * @JoinColumn(name = "large_area_code")
 * private LargeArea largeArea;
 */

