public class Person {
    public static class Persons {
        static String name;
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

        public Persons() {

        }

        void info() {
            System.out.println("ФИО:" + name + " Должность:" + position + " email:" + email + " Телефон:" + phone + " Зарплата:" + salary + " Возраст:" + age);
        }
    }

    public void main(String[] args) {
        Persons person1 = new Persons();
        Persons person2 = new Persons();
        person1.name = "Иванов Иван Иванович";
        person1.position = "Директор";
        person1.email = "Ivanov.mail.ru";
        person1.phone = 343464;
        person1.salary = 30000;
        person1.age = 20;
        person2.name = "Петров Петр Петрович";
        person2.position = "Менеджер";
        person2.email = "Petrov.mail.ru";
        person2.phone = 343463;
        person2.salary = 20000;
        person2.age = 35;
        person1.info();
        person2.info();
    }

    public static class ArrayPersons {
        public static void main(String[] args) {
            Persons[] persArray = new Persons[5];
            persArray[0] = new Persons("Иванов Иван", "Директор", "Ivanov.mail.ru", 333333, 30000, 30);
            persArray[1] = new Persons("Петров Петр", "Менеджер", "Petrov.mail.ru", 322222, 25000, 23);
            persArray[2] = new Persons("Смирнов Андрей", "Бухгалтер", "Smirnov.mail.ru", 333321, 20000, 27);
            persArray[3] = new Persons("Романов Роман", "Кладовщик", "Roman.mail.ru", 333334, 18000, 28);
            persArray[4] = new Persons("Любимова Любовь", "Менеджер", "Love.mail.ru", 333321, 15000, 32);
        }
    }
}





