INSERT INTO EMPLOYEE (FIRST_NAME, LAST_NAME, TITLE, PHONE_NUMBER, EMAIL, HIRE_DATE, MANAGER_ID, DEPT_NUM)
VALUES ('Big', 'Bird', 'Bird', '111-555-2222', 'weirdBird@seasamail.com', '11/10/1969', null, 1),
       ('Elmo', 'Tickles', 'Child', '111-555-2223', 'elmo@seasamail.com', '11/10/1969', 1, 1),
       ('Oscar', 'DGrouch', 'Grump', '111-555-2224', 'grump@seasamail.com', '11/10/1969', 2, 1),
       ('Bert', 'Nernie', 'Tall', '111-555-2225', 'tall_guy@seasamail.com', '11/10/1969', 2, 2),
       ('Ernie', 'Nernie', 'Short', '111-555-2226', 'short_guy@seasamail.com', '11/10/1969', 4, 2),
       ('Snuffle', 'Ufflegus', 'Kind Monster', '111-555-2227', 'gentleGiant@seasamail.com', '11/10/1969', 4, 2),
       ('Cookie', 'Monster', 'Kind Monster', '111-555-2228', 'cookies@seasamail.com', '11/10/1969', 2, 3),
       ('Kermit', 'DFrog', 'Frog', '111-555-2229', 'seeingGreen@seasamail.com', '11/10/1969', 7, 3),
       ('Miss', 'Piggy', 'pig', '111-555-2230', 'kermitsBae@seasamail.com', '11/10/1969', 7, 3),
       ('Count', 'VonCount', 'Accountant', '111-555-2231', 'numberz@seasamail.com', '11/10/1969', 7, 3);

INSERT INTO DEPARTMENT (DEPT_NAME, MANAGER_ID)
VALUES ('Board of Directors', 1),
       ('Marketing', 4),
       ('Accounting', 7);