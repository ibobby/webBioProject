import ru.bobby.web.model.BaseEntity;
import ru.bobby.web.model.UserProcedures;

import java.time.LocalDateTime;

/**
 * Created by b.istomin on 20.07.2015.
 */
public class ProcedureTestData {

    public final static int PROCEDURE1_ID = BaseEntity.START_SEQ + 2;

    public static final UserProcedures PROC1 = new UserProcedures(PROCEDURE1_ID, LocalDateTime.of(2015, 1, 6, 9, 0), "жим", 500);
    public static final UserProcedures PROC2 = new UserProcedures(PROCEDURE1_ID + 1, LocalDateTime.of(2015, 1, 6, 13, 0), "присед", 1000);
    public static final UserProcedures PROC3 = new UserProcedures(PROCEDURE1_ID + 2, LocalDateTime.of(2015, 1, 7, 0, 0), "становая", 600);
    public static final UserProcedures PROC4 = new UserProcedures(PROCEDURE1_ID + 3, LocalDateTime.of(2015, 1, 7, 13, 0), "жим", 1300);
    public static final UserProcedures ADMIN_PROC = new UserProcedures(PROCEDURE1_ID + 4, LocalDateTime.of(2015, 1, 6, 14, 0), "другое", 2000);

    public static UserProcedures getCreated() {
        return new UserProcedures(null, LocalDateTime.of(2015, 1, 8, 18, 0), "created", 300);
    }

    public UserProcedures getUpdated() {
        UserProcedures updated =
    }


}
