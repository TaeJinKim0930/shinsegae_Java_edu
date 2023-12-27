package oop.day1;

public class NutritionFactsMain {
    public static void main(String[] args) {
        NutritionFacts coke =
                new NutritionFacts
                        .Builder(240, 8)
                        .calories(100)
                        .sodium(50)
                        .fat(20)
                        .carbonhydrate(30)
                        .build();


    }
}
