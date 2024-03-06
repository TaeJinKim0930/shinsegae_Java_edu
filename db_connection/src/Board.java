import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
public class Board {
    private int bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private Date bdate;
    private String bfilename;
    private Blob bfiledata;
}
