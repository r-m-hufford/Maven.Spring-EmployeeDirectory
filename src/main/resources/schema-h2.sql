CREATE TABLE EMPLOYEE (
  ID NUMBER(10,0) NOT NULL AUTO_INCREMENT,
  FIRST_NAME VARCHAR2(255) DEFAULT NULL,
  LAST_NAME VARCHAR2(255) DEFAULT NULL,
  TITLE VARCHAR(255) DEFAULT NULL,
  PHONE_NUMBER VARCHAR(255) DEFAULT NULL,
  EMAIL VARCHAR(255) DEFAULT NULL,
  HIRE_DATE VARCHAR(255) DEFAULT NULL,
  MANAGER VARCHAR(255) DEFAULT NULL,
  DEPARTMENT VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (ID));

CREATE TABLE DEPARTMENT (
  ID NUMBER(10,0) NOT NULL AUTO_INCREMENT,
  DEPT_NUM VARCHAR (6) DEFAULT NULL,
  DEPT_NAME VARCHAR(255) DEFAULT NULL,
  MANAGER VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (ID)
);

DROP SEQUENCE hibernate_sequence;

CREATE SEQUENCE hibernate_sequence;