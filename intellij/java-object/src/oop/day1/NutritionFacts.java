package oop.day1;

// Method Chaining
public class NutritionFacts {
    private final int servingSize; // (m1, 1회 제공량) 필수
    private final int servings; // (m1, n회 제공량) 필수
    private final int calories; // (1회 제공량당 영량) 선택
    private final int fat; // (g, 1회 제공량) 선택
    private final int sodium; // 선택
    private final int carbonhydrate; // 선택

    /**
     * Builder Pattern. 중첩 클래스 builder 삽입.
     * 성능 업
     * 필수와 선택 영역 나누어야 됨
     * Method Chaining 방식으로 운영이 가능
     * 클라이언트의 편의성을 위함
     */
    public static class Builder {
        // 필수 매개변수(parameter): 외부에서는 보이지 않음. 기본값을 설정 할 필요 없음.
        private final int servingSize; // 필수
        private final int servings; // 필수


        // 선택 매개변수(parameter) : 기본값을 설정 해야 됨
        private int calories = 0; // (1회 제공량당 영량) 선택
        private int fat = 0; // (g, 1회 제공량) 선택
        private int sodium = 0; // 선택
        private int carbonhydrate = 0; // 선택

        // 필수 값
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        // 선택 값
        // 칼로리의 값을 바꿈: setter method
        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public Builder carbonhydrate(int val) {
            carbonhydrate = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbonhydrate = builder.carbonhydrate;
    }


}// nutritionFacts
