INSERT INTO "user" (ID, PASSWORD, USER_NAME, BIO) VALUES
 ('c4f20b28-9e29-4f9e-94f7-12fd0893544b', 'vmi123', 'david', 'test bio...');

INSERT INTO ARTICLE (ID,TITLE,SLUG,DESCRIPTION,BODY,TAGS, CREATOR_ID) VALUES
 ('99f5374c-03cc-11ee-be56-0242ac120002','How to train your dragon','how-to-train-your-dragon','Ever wonder how?','You have to believe','reactjs, angularjs, dragons', 'c4f20b28-9e29-4f9e-94f7-12fd0893544b');

INSERT INTO ARTICLE (ID,TITLE,SLUG,DESCRIPTION,BODY,TAGS, CREATOR_ID) VALUES
 ('c0777a19-677f-4d81-906f-7903b719b375','Test article','test-article','asdDASDADAS?','Testbod','reactjs', 'c4f20b28-9e29-4f9e-94f7-12fd0893544b');

INSERT INTO COMMENTS (ID, CONTENT, USER_ID, ARTICLE_ID, CREATED_AT, UPDATED_AT) VALUES
 ('89577617-2e64-4f02-bee7-443bddc00f8a', 'hah..', 'c4f20b28-9e29-4f9e-94f7-12fd0893544b', '99f5374c-03cc-11ee-be56-0242ac120002', '2023-02-18T03:22:56.637Z', '2023-02-18T03:22:56.637Z'),
 ('88cef581-ff49-4334-92cd-019b00bf093b', 'interesting!', 'c4f20b28-9e29-4f9e-94f7-12fd0893544b', 'c0777a19-677f-4d81-906f-7903b719b375', '2019-11-21T03:22:58.7656', '2019-11-21T03:22:58.7656');