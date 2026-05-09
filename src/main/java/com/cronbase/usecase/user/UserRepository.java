package com.cronbase.usecase.user;

import com.cronbase.common.Database;
import com.cronbase.schema.tables.pojos.User;
import org.jooq.DSLContext;

import java.util.List;
import java.util.Optional;

import static com.cronbase.schema.tables.User.USER;

public class UserRepository {

    private final DSLContext dsl = Database.dsl();

    public List<User> findAll() {
        return dsl.selectFrom(USER).fetchInto(User.class);
    }

    public Optional<User> findById(Long id) {
        return dsl.selectFrom(USER)
                .where(USER.ID.eq(id))
                .fetchOptionalInto(User.class);
    }

    public User save(User user) {
        return dsl.insertInto(USER)
                .set(dsl.newRecord(USER, user))
                .returning()
                .fetchOne()
                .into(User.class);
    }

    public void deleteById(Long id) {
        dsl.deleteFrom(USER)
                .where(USER.ID.eq(id))
                .execute();
    }
}
