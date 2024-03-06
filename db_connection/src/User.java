import lombok.*;


// Constructor, Getter Setter, Hashcode(), Equals(), toString() 등 자동 생성
@Data
@NoArgsConstructor
@Setter
@Getter
public class User {
    private String userid;
    private String userName;
    private String userPassword;
    private int userAge;
    private String userEmail;


}
