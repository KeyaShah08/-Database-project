-- Team 15
-- Members: Urmi Sheth 1002064934, 
--          Yash Patel 1002084351,
--          Keya Shah  1002079489 

--- 1 ---
CREATE TABLE F22_S004_15_PERSON(
          PERSON_ID NUMBER(25) NOT NULL,
          FIRST_NAME VARCHAR2(30) NOT NULL,
          LAST_NAME VARCHAR2(30) NOT NULL,
          DOB DATE NOT NULL,
          EMAIL VARCHAR2(50) NOT NULL,
          APARTMENT VARCHAR2(25) NOT NULL,
          STREET VARCHAR2(25) NOT NULL,
          ZIP NUMBER(10) NOT NULL,
          GENDER VARCHAR2(1), 
          PRIMARY KEY(PERSON_ID),
          CHECK(GENDER='F' OR GENDER='M')
          );

--- 2 ---
CREATE TABLE F22_S004_15_CUSTOMER(
          CUSTOMER_ID NUMBER(25) NOT NULL,
          PERSON_ID NUMBER(25) NOT NULL,
          TYPE_OF_ART VARCHAR2(50) NOT NULL,
          PRIMARY KEY(CUSTOMER_ID),
          FOREIGN KEY(PERSON_ID) REFERENCES F22_S004_15_PERSON(PERSON_ID)ON DELETE CASCADE
          );
         
--- 3 ---
CREATE TABLE  F22_S004_15_PHONE(
          PERSON_ID NUMBER(25) NOT NULL,
          PHONE_NUM NUMBER(10) NOT NULL UNIQUE,
          PRIMARY KEY(PERSON_ID,PHONE_NUM),
          FOREIGN KEY(PERSON_ID)REFERENCES F22_S004_15_PERSON(PERSON_ID)ON DELETE CASCADE
          );
          
--- 4 ---
CREATE TABLE F22_S004_15_ARTIST(
          ARTIST_ID NUMBER(25) NOT NULL,
          PERSON_ID NUMBER(25) NOT NULL,
          NO_OF_SALES NUMBER(10),
          EXPERTISE VARCHAR2(100) NOT NULL,
          PRIMARY KEY(ARTIST_ID),
          FOREIGN KEY(PERSON_ID)REFERENCES F22_S004_15_PERSON(PERSON_ID)ON DELETE CASCADE
          );
 
--- 5 ---
CREATE TABLE F22_S004_15_STAFF(
          STAFF_ID NUMBER(25) NOT NULL,
          PERSON_ID NUMBER(25) NOT NULL,
          PRIMARY KEY(STAFF_ID),
          FOREIGN KEY(PERSON_ID)REFERENCES F22_S004_15_PERSON(PERSON_ID)ON DELETE CASCADE
          );
       
--- 6 ---
CREATE TABLE F22_S004_15_ORGANIZATION(
          ORGANIZATION_ID NUMBER(25) NOT NULL,
          EMAIL VARCHAR2(25) NOT NULL,
          ORGANIZATION_NAME VARCHAR2(50) NOT NULL, 
          APARTMENT VARCHAR2(25) NOT NULL,
          STREET VARCHAR2(25) NOT NULL,
          ZIP NUMBER(5) NOT NULL,
          PHONE_NUM NUMBER(10) NOT NULL UNIQUE,
          PRIMARY KEY(ORGANIZATION_ID)
          );
          
--- 7 ---
CREATE TABLE F22_S004_15_ORGANIZATION_TYPE_OF_ART(
          ORGANIZATION_ID NUMBER(25) NOT NULL,
          TYPE_OF_ART VARCHAR2(50),
          PRIMARY KEY(ORGANIZATION_ID,TYPE_OF_ART),
          FOREIGN KEY(ORGANIZATION_ID) REFERENCES F22_S004_15_ORGANIZATION(ORGANIZATION_ID) ON DELETE CASCADE
          );
          
--- 8 ---          
CREATE TABLE F22_S004_15_FEEDBACK(
          FEEDBACK_ID NUMBER(25) NOT NULL,
          FEEDBACK_DATE DATE NOT NULL,
          TYPE_OF_ART VARCHAR2(50) NOT NULL,
          TITLE VARCHAR2(50)NOT NULL,
          DESCRIPTION VARCHAR2(250),
          PRIMARY KEY(FEEDBACK_ID)
          );
          
--- 9 ---
CREATE TABLE F22_S004_15_ART_GALLERY(
          ART_GALLERY_ID NUMBER(25) NOT NULL,
          ART_GALLERY_NAME VARCHAR2(50) NOT NULL,
          APARTMENT VARCHAR2(25) NOT NULL,
          STREET VARCHAR2(25) NOT NULL,
          ZIP NUMBER(5) NOT NULL,
          PRIMARY KEY(ART_GALLERY_ID)
          );

--- 10 ---         
CREATE TABLE F22_S004_15_ART(
          ART_ID NUMBER(25) NOT NULL,
          ART_GALLERY_ID NUMBER(25) NOT NULL,
          ART_TYPE VARCHAR2(25) NOT NULL,
          CREATED_DATE DATE NOT NULL,
          PRICE NUMBER(37) NOT NULL,
          STATUS VARCHAR2(20),
          CHECK(STATUS='SOLD' OR STATUS='UNSOLD'),
          PRIMARY KEY(ART_ID),
          FOREIGN KEY(ART_GALLERY_ID) REFERENCES F22_S004_15_ART_GALLERY(ART_GALLERY_ID) ON DELETE CASCADE
          );

--- 11 ---
CREATE TABLE F22_S004_15_CUSTOMER_GIVES(
          FEEDBACK_ID NUMBER(25) NOT NULL,
          CUSTOMER_ID NUMBER(25) NOT NULL,
          FOREIGN KEY(FEEDBACK_ID) REFERENCES F22_S004_15_FEEDBACK(FEEDBACK_ID) ON DELETE CASCADE,
          FOREIGN KEY(CUSTOMER_ID) REFERENCES F22_S004_15_CUSTOMER(CUSTOMER_ID) ON DELETE CASCADE
          );

--- 12 ---
CREATE TABLE F22_S004_15_ORG_GIVES(
          ORGANIZATION_ID NUMBER(25) NOT NULL,
          FEEDBACK_ID NUMBER(25) NOT NULL,
          FOREIGN KEY(ORGANIZATION_ID) REFERENCES F22_S004_15_ORGANIZATION(ORGANIZATION_ID) ON DELETE CASCADE,
          FOREIGN KEY(FEEDBACK_ID) REFERENCES F22_S004_15_FEEDBACK(FEEDBACK_ID) ON DELETE CASCADE
          );

--- 13 ---
CREATE TABLE F22_S004_15_CUSTOMER_BUYS(
          ART_ID NUMBER(25) NOT NULL,
          CUSTOMER_ID NUMBER(25) NOT NULL,
          BUY_DATE DATE NOT NULL,
          FOREIGN KEY(ART_ID )REFERENCES F22_S004_15_ART(ART_ID) ON DELETE CASCADE,
          FOREIGN KEY(CUSTOMER_ID) REFERENCES F22_S004_15_CUSTOMER(CUSTOMER_ID) ON DELETE CASCADE
          );
      
--- 14 ---   
CREATE TABLE F22_S004_15_ORG_BUYS(
          ART_ID NUMBER(25) NOT NULL,
          ORGANIZATION_ID NUMBER(25) NOT NULL,
          BUY_DATE DATE NOT NULL,
          FOREIGN KEY(ART_ID )REFERENCES F22_S004_15_ART(ART_ID) ON DELETE CASCADE,
          FOREIGN KEY(ORGANIZATION_ID) REFERENCES F22_S004_15_ORGANIZATION(ORGANIZATION_ID) ON DELETE CASCADE
          );

--- 15 ---
CREATE TABLE F22_S004_15_CREATES(
          ART_ID NUMBER(25) NOT NULL,
          ARTIST_ID NUMBER(25) NOT NULL,
          FOREIGN KEY(ART_ID )REFERENCES F22_S004_15_ART(ART_ID) ON DELETE CASCADE,
          FOREIGN KEY(ARTIST_ID )REFERENCES F22_S004_15_ARTIST(ARTIST_ID) ON DELETE CASCADE
          );
          
--- 16 ---
CREATE TABLE F22_S004_15_MANAGES(
          STAFF_ID NUMBER(25) NOT NULL,
          ART_GALLERY_ID NUMBER(25) NOT NULL,
          FOREIGN KEY(STAFF_ID )REFERENCES F22_S004_15_STAFF(STAFF_ID) ON DELETE CASCADE,
          FOREIGN KEY(ART_GALLERY_ID )REFERENCES F22_S004_15_ART_GALLERY(ART_GALLERY_ID) ON DELETE CASCADE
          );



