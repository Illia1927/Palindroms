CREATE TABLE USERS (
  USER_ID        BIGINT PRIMARY KEY AUTO_INCREMENT,
  FIRST_NAME VARCHAR(30),
  LAST_NAME  VARCHAR(30),
  EMAIL      VARCHAR(100)  NOT NULL,
  PASSWORD   VARCHAR(255)  NOT NULL
);

CREATE TABLE ROLES (
  ID          BIGINT PRIMARY KEY AUTO_INCREMENT,
  NAME        VARCHAR(50)  NOT NULL
);

CREATE TABLE USERS_TO_ROLES (
  ID         BIGINT PRIMARY KEY AUTO_INCREMENT,
  FK_USER_ID BIGINT        NOT NULL,
  FK_ROLE_ID BIGINT        NOT NULL,
    CONSTRAINT FK_UTR_TO_USERS FOREIGN KEY (FK_USER_ID)
      REFERENCES USERS(ID),
    CONSTRAINT FK_UTR_TO_ROLES FOREIGN KEY (FK_ROLE_ID)
      REFERENCES ROLES(ID)
);
CREATE TABLE PALINDROM (
 PALINDROM_ID BIGINT(10)  NOT NULL AUTO_INCREMENT,
NUMBERS BIGINT NOT NULL,
FK_USER_ID BIGINT        NOT NULL,
    CONSTRAINT FK_USERS FOREIGN KEY (FK_USER_ID)
      REFERENCES USERS(USER_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
