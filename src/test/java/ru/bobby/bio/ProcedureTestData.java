package ru.bobby.bio;

import ru.bobby.bio.matcher.ModelMatcher;
import ru.bobby.bio.model.BaseEntity;
import ru.bobby.bio.model.UserProcedures;

import java.time.LocalDateTime;

/**
 * Created by b.istomin on 20.07.2015.
 */
public class ProcedureTestData {

    public final static int PROCEDURE1_ID = BaseEntity.START_SEQ + 2;

    public static final UserProcedures PROC1 = new UserProcedures(PROCEDURE1_ID, LocalDateTime.of(2015, 1, 6, 9, 0), "gym", 500);
    public static final UserProcedures PROC2 = new UserProcedures(PROCEDURE1_ID + 1, LocalDateTime.of(2015, 1, 6, 13, 0), "sit", 1000);
    public static final UserProcedures PROC3 = new UserProcedures(PROCEDURE1_ID + 2, LocalDateTime.of(2015, 1, 7, 0, 0), "stan", 600);
    public static final UserProcedures PROC4 = new UserProcedures(PROCEDURE1_ID + 3, LocalDateTime.of(2015, 1, 7, 13, 0), "gym", 1300);
    public static final UserProcedures ADMIN_PROC = new UserProcedures(PROCEDURE1_ID + 4, LocalDateTime.of(2015, 1, 6, 14, 0), "another", 2000);

    public static UserProcedures getCreated() {
        return new UserProcedures(null, LocalDateTime.of(2015, 1, 8, 18, 0), "created", 300);
    }

    public static UserProcedures getUpdated() {
        UserProcedures updated = new UserProcedures(PROC1);
        updated.setDescription("Updated procedure");
        return updated;
    }


    public static final ModelMatcher<UserProcedures, String> MATCHER = new ModelMatcher<>(
            (procedure) -> (procedure.toString()));

}
