CREATE TABLE PARENT_CLIENT_PROPERTIES(
    PARENT_CLIENT_ID BIGSERIAL NOT NULL PRIMARY KEY,
    IS_CELEBRITY BOOLEAN DEFAULT FALSE,
    EVENT_ID BIGINT NOT NULL,
    HONOREE_ID SMALLINT NOT NULL,
    IS_ACTIVE BOOLEAN NOT NULL DEFAULT FALSE,
    PHONE VARCHAR(30) NOT NULL,
    EMAIL VARCHAR(50) NOT NULL,
    IS_LEGACY BOOLEAN NOT NULL DEFAULT FALSE,
    UPDATED_AT TIMESTAMP WITH TIME ZONE,
    CREATED_AT TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE CLIENTS_WITH_EVENT_ACCESS(
    EVENT_ACCESS_ID BIGSERIAL NOT NULL PRIMARY KEY,
    OWNER_ID BIGINT NOT NULL,
    PROFILE_ID BIGINT NOT NULL,
    IS_COOWNER BOOLEAN NOT NULL DEFAULT FALSE
) INHERITS (PARENT_CLIENT_PROPERTIES);

CREATE TABLE CLIENT_CANDIDATES(
    USER_ID BIGSERIAL NOT NULL PRIMARY KEY,
    NAME VARCHAR(50) NOT NULL,
    LAST_NAME VARCHAR(50) NOT NULL,
    MOTHER_NAME VARCHAR(50),
    IS_MINOR BOOLEAN NOT NULL DEFAULT FALSE,
    HAS_INVITATION BOOLEAN NOT NULL DEFAULT FALSE
) INHERITS (PARENT_CLIENT_PROPERTIES);
