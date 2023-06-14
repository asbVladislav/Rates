CREATE TABLE Rate (
                      ID BIGINT AUTO_INCREMENT primary key ,
                      Cur_ID INTEGER,
                      Cur_Name VARCHAR(255),
                      cur_official_rate double,
                      Cur_Abbreviation VARCHAR(255),
                      Date TIMESTAMP,
                      Cur_Scale INTEGER
);
CREATE TABLE currency (
                          Cur_ID INT primary key ,
                          Cur_ParentID INT,
                          Cur_Code INT,
                          Cur_Abbreviation VARCHAR(10),
                          Cur_Name VARCHAR(100),
                          Cur_Name_Bel VARCHAR(100),
                          Cur_Name_Eng VARCHAR(100),
                          Cur_QuotName VARCHAR(100),
                          Cur_QuotName_Bel VARCHAR(100),
                          Cur_QuotName_Eng VARCHAR(100),
                          Cur_NameMulti VARCHAR(100),
                          Cur_Name_BelMulti VARCHAR(100),
                          Cur_Name_EngMulti VARCHAR(100),
                          Cur_Scale INT,
                          Cur_Periodicity INT,
                          Cur_DateStart DATE,
                          Cur_DateEnd DATE
);
INSERT INTO Rate (Cur_ID, Cur_Name, cur_official_rate, Cur_Abbreviation, Date, Cur_Scale) VALUES (441, 'Болгарский лев', 1.6101, 'BGN', '2023-06-09T00:00:00', 1);

ALTER TABLE Rate ADD COLUMN ID BIGINT AUTO_INCREMENT;

Drop table Rate;


ALTER TABLE Rate ADD PRIMARY KEY (ID);

select distinct  currency.Cur_Id,currency.Cur_Abbreviation,R.cur_official_rate from currency right join Rate R on currency.Cur_ID = R.Cur_ID
