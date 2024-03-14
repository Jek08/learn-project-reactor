package dev.jakapw;

public class Person {
    private String id;
    private String name;
    private Integer stat;

    public Person(String id, String name, Integer stat) {
        this.id = id;
        this.name = name;
        this.stat = stat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }
}
