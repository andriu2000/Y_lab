class Batman extends MovieHero {
    String name() {
        return "Batman";
    }
    public static void main(String[] args) {
        MovieHero hero = new Batman();
        Batman hero1 = new Batman();
        hero.introduce();
        hero1.introduce();
    }
}
