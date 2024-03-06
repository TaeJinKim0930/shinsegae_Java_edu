package hello.hellospirng.controller;

public class MemberForm {
    /**
     * this.name and name from name="name" from createMemberForm.html will match and receive value
     *      <input type="text" id="name" name="name" placeholder="이름을 입력하세요">
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
