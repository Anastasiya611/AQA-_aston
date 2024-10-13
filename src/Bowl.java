class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
        } else {
            System.out.println("Недостаточно еды в миске.");
        }
    }

    public void addFood(int amount) {
        food += amount;
        System.out.println("Добавлено " + amount + " еды в миску.");
    }
}

