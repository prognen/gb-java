package sems.sem_3;

public class Person {
    private String surname;
    private String name;
    private String patronymic;
    private String birthDate;
    private long phoneNum;
    private char sex;

    public Person() {
        this.surname = null;
        this.name = null;
        this.patronymic = null;
        this.birthDate = null;
        this.phoneNum = 0;
        this.sex = '\0';
    }
    public Person(String surname, String name, String patronymic, String birthDate, int phoneNum, char sex) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNum = phoneNum;
        this.sex = sex;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getInfo() {
        return String.format("%s %s %s %s %d %c", this.surname, this.name, this.patronymic, this.birthDate, this.phoneNum, this.sex);
    }
}
