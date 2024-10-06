import java.text.MessageFormat;

public class Park {
    String name;
    String time;
    int price;

    static class infoPark {
        public static void main(String[] args) {
            Park rollerCoaster = new Park();
            Park bigWheel = new Park();
            Park funhouse = new Park();
            rollerCoaster.name = "Roller Coaster";
            rollerCoaster.time = "17:00";
            rollerCoaster.price = 100;
            bigWheel.name = "Big Wheel";
            bigWheel.time = "16:00";
            bigWheel.price = 150;
            funhouse.name = "Funhouse";
            funhouse.time = "18:00";
            funhouse.price = 135;
            System.out.println(MessageFormat.format("{0} {1} {2}", rollerCoaster.name, rollerCoaster.time, rollerCoaster.price));
            System.out.println(MessageFormat.format("{0} {1} {2}", bigWheel.name, bigWheel.time, bigWheel.price));
            System.out.println(MessageFormat.format("{0} {1} {2}", funhouse.name, funhouse.time, funhouse.price));
        }
    }
}

