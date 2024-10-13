class Cat extends Animal {
    private static int catCount = 0;
    private boolean satiety;

    public Cat(String name) {
        super(name);
        catCount++;
        this.satiety = false;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(Bowl bowl, int foodAmount) {
        if (bowl.getFood() >= foodAmount) {
            bowl.decreaseFood(foodAmount);
            this.satiety = true;
            System.out.println(name + " покушал.");
        } else {
            System.out.println(name + " получил не достаточно еды в миске.");
        }
    }

    public boolean isSatiety() {
        return satiety;
    }

    public static int getCatCount() {
        return catCount;
    }
}
