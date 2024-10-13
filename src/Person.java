public class Person {
    public static class Persons {
        String name;
        String position;
        String email;
        int phone;
        int salary;
        int age;

        public Persons(String name, String position, String email, int phone, int salary, int age) {
            this.name = name;
            this.position = position;
            this.email = email;
            this.phone = phone;
            this.salary = salary;
            this.age = age;
        }
        public String toString() {
            return "ФИО: " + name + ", Должность: " + position + ", Email: " + email + ", Телефон: " + phone + ", Зарплата: " + salary + ", Возраст: " + age;
        }
    }

    public static class Main {
        public static void main(String[] args) {
            Persons[] persArray = new Persons[5];
            persArray[0] = new Persons("Иванов Иван", "Директор", "Ivanov.mail.ru", 333333, 30000, 30);
            persArray[1] = new Persons("Петров Петр", "Менеджер", "Petrov.mail.ru", 322222, 25000, 23);
            persArray[2] = new Persons("Смирнов Андрей", "Бухгалтер", "Smirnov.mail.ru", 333321, 20000, 27);
            persArray[3] = new Persons("Романов Роман", "Кладовщик", "Roman.mail.ru", 333334, 18000, 28);
            persArray[4] = new Persons("Любимова Любовь", "Менеджер", "Love.mail.ru", 333321, 15000, 32);
            printPersonsInfo(persArray);
        }
        public static void printPersonsInfo(Persons[] persons) {
            for (Persons person : persons) {
                System.out.println(person);
            }
        }
    }
}

