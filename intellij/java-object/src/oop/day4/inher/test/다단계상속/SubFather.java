package oop.day4.inher.test.다단계상속;

public class SubFather extends GrandFather {
    private String father;
    private String familyName;
    private String houseAddress;

    public String getFather() {
        return father;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public void printFather() {
        System.out.println("나의 집은 " + getHouseAddress());
        System.out.println("나는 " + getFather() + "입니다! 나는 " + getGrandFather() + "로부터 상속받습니다.");
        printGrandFather();
    }
}
