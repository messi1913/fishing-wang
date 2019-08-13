package com.ddastudio.fishing.common.env;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import static com.ddastudio.fishing.common.Constants.USE;

@Repository
@RequiredArgsConstructor
public class EnvDAO {

    private final JPAQueryFactory query;

    private final QFishingEnvironment ENV = QFishingEnvironment.fishingEnvironment;


    public Optional<String> getProperty(String key) {
        return Optional.ofNullable(
                query.select(ENV.property)
                .from(ENV)
                .where(ENV.id.eq(key)
                    .and(ENV.audit.useYn.eq(USE)))
                 .fetchOne());
    }

}
