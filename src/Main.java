public class Main {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобик");
        Cat catMurzik = new Cat("Мурзик");
        Cat catBarsik = new Cat("Барсик");

        dogBobik.run(150);
        dogBobik.swim(5);

        catMurzik.run(100);
        catMurzik.swim(5);

        catBarsik.run(300);
        catBarsik.swim(1);

        Bowl bowl = new Bowl(30);
        Cat[] cats = {catMurzik, catBarsik};

        for (Cat cat : cats) {
            cat.eat(bowl, 20);
        }

        for (Cat cat : cats) {
            System.out.println(cat.name + " покушал: " + cat.isSatiety());
        }

        bowl.addFood(10);

        System.out.println("Всего животных: " + Animal.animalCount);
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
    }
}
