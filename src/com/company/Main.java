package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public static int chose_circuit(int age){
        Scanner scan = new Scanner(System.in);
        String circuit = null;
        int registration_fee = 0;

        System.out.println("Qual circuito deseja se inscrever?\n" +
                "a - Circuirto pequeno\n" +
                "b - Circuito Médio\n" +
                "c - Circuito Avançado\n" +
                "d - Não se inscrever.");

        circuit = scan.next();

        do {
            switch (circuit) {
                case "a":
                    if (age < 18) {
                        registration_fee = 1300;
                    } else {
                        registration_fee = 1500;
                    }
                    break;
                case "b":
                    if (age < 18) {
                        registration_fee = 2000;
                    } else {
                        registration_fee = 2300;
                    }
                    break;
                case "c":
                    if (age < 18) {
                        System.out.println("Não se qualifica!");
                    } else {
                        registration_fee = 2800;
                    }
                    break;
                case "d":
                    System.out.println("Saindo...");
                default:
                    System.out.println("Opção Inválida!");
            }
        }while(circuit != "d");

        return registration_fee;
    }

    public static Person create_person(){
        Scanner scan = new Scanner(System.in);
        String rg = null, first_name = null, last_name = null, phone_number = null,
                emergency_number = null, blood_type = null;
        int age = 0, registration_fee = 0;

        System.out.println("Digite seu rg: ");
        rg = scan.next();
        System.out.println("Digite seu nome:");
        first_name = scan.next();
        System.out.println("Digite seu sobrenome: ");
        last_name = scan.next();
        System.out.println("Digite sua idade: ");
        age = scan.nextInt();
        System.out.println("Digite seu numero celular: ");
        phone_number = scan.next();
        System.out.println("Digite seu número de emergência: ");
        emergency_number = scan.next();
        System.out.println("Digite seu tipo sanguineo: ");
        blood_type = scan.next();
        registration_fee = chose_circuit(age);

        Person new_person = new Person(rg, first_name, last_name, age, phone_number, emergency_number,
                blood_type, registration_fee);

        return new_person;
    }

    public static void remove_person(Map records){
        Scanner scan = new Scanner(System.in);
        int id = 0;

        System.out.println("Informe o id da pessoa a ter a inscrição cancelado.");
        id = scan.nextInt();

        records.remove(id);
    }

    public static void menu() {
        Scanner scan = new Scanner(System.in);
        int option, sequence = 1;
        Map<Integer, Person> records = new HashMap<>();

        do {
            System.out.println("Escolha uma das opções a seguir:");
            System.out.println("1 - criar e inscrever novo participante.");
            System.out.println("2 - Mostrar todos os cadastrados.");
            System.out.println("3 - Cancelar a inscrição de um participante.");
            System.out.println("4 - Inscrever participante.");
            System.out.println("5 - Sair");

            option = scan.nextInt();
            switch (option) {
                case 1:
                    records.put(sequence, create_person());
                    sequence++;
                    break;
                case 2:
                    records.forEach((key, value) -> {
                        System.out.println("key: "+key+" Nome completo: "+value.first_name.concat(value.last_name)+
                                " | RG: "+value.rg+" | idade: "+value.age+" | Número celular: "+value.phone_number+
                                " | Número de emergêngia: "+value.emergency_number+" | Grupo sanguíneo: "
                                +value.blood_type+" | Taxa de inscrição: "+value.registration_fee);
                    });
                    break;
                case 3:
                    remove_person(records);
                    break;
                case 4:
                    int id = 0;
                    System.out.println("Digite o id da pessoa.");
                    id = scan.nextInt();
                    chose_circuit(records.get(id).age);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }while(option != 5);
    }
}
