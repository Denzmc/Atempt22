package com.example.attemptnumber22;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(unique = true, nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String password;
    private Float allMoney;
    private Float freeMoney;
    private Integer amazon;
    private Integer apple;
    private Integer nvidia;
    private Integer tesla;

    public User() {}

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.allMoney = 1000000.00f;
        this.freeMoney = 1000000.00f;
        this.amazon = 0;
        this.apple = 0;
        this.nvidia = 0;
        this.tesla = 0;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Float getAllMoney() {
        return allMoney;
    }

    public void setAllMoney(Float allMoney) {
        this.allMoney = allMoney;
    }

    public Float getFreeMoney() {
        return freeMoney;
    }

    public void setFreeMoney(Float freeMoney) {
        this.freeMoney = freeMoney;
    }

    public Integer getAmazon() {
        return amazon;
    }

    public void setAmazon(Integer amazon) {
        this.amazon = amazon;
    }

    public Integer getApple() {
        return apple;
    }

    public void setApple(Integer apple) {
        this.apple = apple;
    }

    public Integer getNvidia() {
        return nvidia;
    }

    public void setNvidia(Integer nvidia) {
        this.nvidia = nvidia;
    }

    public Integer getTesla() {
        return tesla;
    }

    public void setTesla(Integer tesla) {
        this.tesla = tesla;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", allMoney=" + allMoney +
                ", freeMoney=" + freeMoney +
                ", amazon=" + amazon +
                ", apple=" + apple +
                ", nvidia=" + nvidia +
                ", tesla=" + tesla +
                '}';
    }
}
