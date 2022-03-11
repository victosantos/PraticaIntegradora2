package com.company;

public class Person {
    public String rg;
    public String first_name;
    public String last_name;
    public int age;
    public String phone_number;
    public String emergency_number;
    public String blood_type;
    public int registration_fee;

    public Person(String rg, String first_name, String last_name, int age, String phone_number,
                  String emergency_number, String blood_type, int registration_fee){
        this.rg = rg;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.phone_number = phone_number;
        this.emergency_number = emergency_number;
        this.blood_type = blood_type;
        this.registration_fee = registration_fee;
    };
}
