package com.ddastudio.fishing.boats;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoat is a Querydsl query type for Boat
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBoat extends EntityPathBase<Boat> {

    private static final long serialVersionUID = 1352052931L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoat boat = new QBoat("boat");

    public final NumberPath<Integer> appId = createNumber("appId", Integer.class);

    public final com.ddastudio.fishing.common.audit.QAudit audit;

    public final DateTimePath<java.time.LocalDateTime> cancelDate = createDateTime("cancelDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> capacity = createNumber("capacity", Integer.class);

    public final NumberPath<Integer> captainId = createNumber("captainId", Integer.class);

    public final ListPath<com.fasterxml.jackson.databind.JsonNode, SimplePath<com.fasterxml.jackson.databind.JsonNode>> fishType = this.<com.fasterxml.jackson.databind.JsonNode, SimplePath<com.fasterxml.jackson.databind.JsonNode>>createList("fishType", com.fasterxml.jackson.databind.JsonNode.class, SimplePath.class, PathInits.DIRECT2);

    public final StringPath fromTime = createString("fromTime");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final ListPath<com.fasterxml.jackson.databind.JsonNode, SimplePath<com.fasterxml.jackson.databind.JsonNode>> images = this.<com.fasterxml.jackson.databind.JsonNode, SimplePath<com.fasterxml.jackson.databind.JsonNode>>createList("images", com.fasterxml.jackson.databind.JsonNode.class, SimplePath.class, PathInits.DIRECT2);

    public final StringPath info = createString("info");

    public final SimplePath<com.fasterxml.jackson.databind.JsonNode> location = createSimple("location", com.fasterxml.jackson.databind.JsonNode.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final StringPath toTime = createString("toTime");

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public QBoat(String variable) {
        this(Boat.class, forVariable(variable), INITS);
    }

    public QBoat(Path<? extends Boat> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoat(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoat(PathMetadata metadata, PathInits inits) {
        this(Boat.class, metadata, inits);
    }

    public QBoat(Class<? extends Boat> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.audit = inits.isInitialized("audit") ? new com.ddastudio.fishing.common.audit.QAudit(forProperty("audit")) : null;
    }

}

