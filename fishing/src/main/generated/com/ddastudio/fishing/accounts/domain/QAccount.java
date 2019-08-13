package com.ddastudio.fishing.accounts.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAccount is a Querydsl query type for Account
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAccount extends EntityPathBase<Account> {

    private static final long serialVersionUID = 572383587L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAccount account = new QAccount("account");

    public final StringPath accountStatus = createString("accountStatus");

    public final NumberPath<Integer> appId = createNumber("appId", Integer.class);

    public final com.ddastudio.fishing.common.audit.QAudit audit;

    public final StringPath avatar = createString("avatar");

    public final DatePath<java.time.LocalDate> cancelDate = createDate("cancelDate", java.time.LocalDate.class);

    public final StringPath captainYn = createString("captainYn");

    public final StringPath email = createString("email");

    public final StringPath emailCheck = createString("emailCheck");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath phoneNo = createString("phoneNo");

    public final StringPath provider = createString("provider");

    public final StringPath providerUid = createString("providerUid");

    public final StringPath pw = createString("pw");

    public final StringPath role = createString("role");

    public final DateTimePath<java.time.LocalDateTime> smsPublishDateTime = createDateTime("smsPublishDateTime", java.time.LocalDateTime.class);

    public final StringPath smsVerifyNo = createString("smsVerifyNo");

    public QAccount(String variable) {
        this(Account.class, forVariable(variable), INITS);
    }

    public QAccount(Path<? extends Account> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAccount(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAccount(PathMetadata metadata, PathInits inits) {
        this(Account.class, metadata, inits);
    }

    public QAccount(Class<? extends Account> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.audit = inits.isInitialized("audit") ? new com.ddastudio.fishing.common.audit.QAudit(forProperty("audit")) : null;
    }

}

