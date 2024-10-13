import java.text.MessageFormat;

public class Park {
    public static void main(String[] args) {
        createAndPrintAttractions();
    }

    private static void createAndPrintAttractions() {
        Attraction rollerCoaster = new Attraction("Roller Coaster", "17:00", 100);
        Attraction bigWheel = new Attraction("Big Wheel", "16:00", 150);
        Attraction funhouse = new Attraction("Funhouse", "18:00", 135);

        System.out.println(rollerCoaster);
        System.out.println(bigWheel);
        System.out.println(funhouse);
    }

    public static class Attraction {
        private final String name;
        private final String time;
        private final int price;

        public Attraction(String name, String time, int price) {
            this.name = name;
            this.time = time;
            this.price = price;
        }

        public String toString() {
            return MessageFormat.format("{0} {1} {2}", name, time, price);
        }
    }
}

