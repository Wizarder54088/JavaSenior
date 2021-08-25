package com.atnjupt.java;

/**
 * @author Wizarder
 * @create 2021-02-28 23:01
 */
public class User implements Comparable {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof User) {
            User u1 = (User) o;
            //按照姓名从大到小排列,年龄从小到大排列
            if (this.name == u1.getName()) {
                return Integer.compare(this.age, u1.age);

            } else {
                return this.name.compareTo(u1.getName());
            }
        } else {
            throw new RuntimeException("输入数据不匹配");
        }
    }
}
