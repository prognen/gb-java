package sems.sem_3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Application {
    private static String data = null;
    public static void main(String[] args) {
        int rc = getData();
        if (rc == -1) {
            System.out.println("Некорректный ввод. Вы ввели неправильное количество данных");
        } else {
            try {
                Person person = parseData();
                writeData(person);
                System.out.println("Запись произошла успешно");
            } catch (IOPersonException e) {
                System.out.println("Строка " + e.getMessage() + " не является ни одним из перечисленных параметров, которые нужно ввести");
            } catch (IOException e) {
                System.out.println("Не удалось осуществить запись в файл");
                e.printStackTrace();
            }
        }
    }

    public static int getData() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите данные в следующем виде в произвольном порядке(Фамилия Имя Отчество датарождения номертелефона пол)");
            data = scanner.nextLine();
            if (data.split(" ").length != 6) {
                return -1;
            }
        } catch (NoSuchElementException e) {
            return -1;
        }

        return 0;
    }
    public static Person parseData() throws IOException {
        String[] arrData = data.split(" ");
        Person person = new Person();
        for (String elem : arrData) {
            if (elem.matches("^[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}")) {
                person.setBirthDate(elem);
            } else if (elem.length() == 1 && (elem.equals("f") || elem.equals("m"))) {
                person.setSex(elem.charAt(0));
            } else if (elem.matches("[0-9]+")) {
                person.setPhoneNum(Long.parseLong(elem));
            } else if (person.getSurname() == null && elem.matches("[a-zA-z]+")) {
                person.setSurname(elem);
            } else if (person.getName() == null && elem.matches("[a-zA-z]+")) {
                person.setName(elem);
            } else if (person.getPatronymic() == null && elem.matches("[a-zA-z]+")) {
                person.setPatronymic(elem);
            } else {
                throw new IOPersonException(elem);
            }
        }

        return person;
    }

    public static void writeData(Person person) throws IOException {
        try (FileWriter fw = new FileWriter(person.getSurname() + ".txt", true)) {
            fw.write(person.getInfo() + "\n");
        } catch (IOException e) {
            throw new IOException();
        }
    }
}
