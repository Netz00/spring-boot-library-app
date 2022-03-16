INSERT INTO author
(id, name,family_name,birth_year,death_year,genre,note)
VALUES
(author_sequence.nextval, 'Vlado','Nazor','1965','2022','proza','poznati pisac ...'),
(author_sequence.nextval, 'Vlado','Nazor','1965','2022','proza','poznati pisac ...'),
(author_sequence.nextval, 'Vlado','Nazor','1965','2022','proza','poznati pisac ...'),
(author_sequence.nextval, 'Vlado','Nazor','1965','2022','proza','poznati pisac ...'),
(author_sequence.nextval, 'Vlado','Nazor','1965','2022','proza','poznati pisac ...'),
(author_sequence.nextval, 'Vlado','Nazor','1965','2022','proza','poznati pisac ...'),
(author_sequence.nextval, 'Vlado','Nazor','1965','2022','proza','poznati pisac ...'),
(author_sequence.nextval, 'Vlado','Nazor','1965','2022','proza','poznati pisac ...'),
(author_sequence.nextval, 'Vlado','Nazor','1965','2022','proza','poznati pisac ...'),
(author_sequence.nextval, 'Vlado','Nazor','1965','2022','proza','poznati pisac ...');


INSERT INTO user
(id, name, family_name, date_birth, date_joining, email, mobile, address, note, last_modified_date)
VALUES
(user_sequence.nextval, 'Vlado', 'Nazor', '2022-03-15', '2022-03-15', 'pruioz@pporooza.hr', '+385 254 2548 154', 'Zagreb', 'nekakav zapis', '2022-03-15'),
(user_sequence.nextval, 'Vlado', 'Nazor', '2022-03-15', '2022-03-15', 'proz@prooza.hr', '+385 254 2548 154', 'Zagreb', 'nekakav zapis', '2022-03-15'),
(user_sequence.nextval, 'Vlado', 'Nazor', '2022-03-15', '2022-03-15', 'prozl@prozoia.hr', '+385 254 2548 154', 'Zagreb', 'nekakav zapis', '2022-03-15'),
(user_sequence.nextval, 'Vlado', 'Nazor', '2022-03-15', '2022-03-15', 'prozi@prozoa.hr', '+385 254 2548 154', 'Zagreb', 'nekakav zapis', '2022-03-15'),
(user_sequence.nextval, 'Vlado', 'Nazor', '2022-03-15', '2022-03-15', 'proopz@priiuoza.hr', '+385 254 2548 154', 'Zagreb', 'nekakav zapis', '2022-03-15'),
(user_sequence.nextval, 'Vlado', 'Nazor', '2022-03-15', '2022-03-15', 'propz@oprouza.hr', '+385 254 2548 154', 'Zagreb', 'nekakav zapis', '2022-03-15'),
(user_sequence.nextval, 'Vlado', 'Nazor', '2022-03-15', '2022-03-15', 'przoz@prozoa.hr', '+385 254 2548 154', 'Zagreb', 'nekakav zapis', '2022-03-15');


INSERT INTO book
(id, isbn, name, publisher, year, note, created_date, last_modified_date,author_id)
VALUES
(book_sequence.nextval, '978-3-16-148410-0', 'Bajka', 'Gutenberg LLT', '1453', 'book about other books',  '2002-03-15',  '2022-03-15',1 ),
(book_sequence.nextval, '978-3-16-148411-0', 'Basna', 'Gutenberg LLT', '1453', 'book about other books',  '2002-03-15',  '2022-03-15',1 ),
(book_sequence.nextval, '978-3-16-148412-0', 'Bajka', 'Gutenberg LLT', '1453', 'book about other books',  '2002-03-15',  '2022-03-15',1 ),
(book_sequence.nextval, '978-3-16-148413-0', 'Bajka', 'Gutenberg LLT', '1453', 'book about other books',  '2002-03-15',  '2022-03-15',2 ),
(book_sequence.nextval, '978-3-16-148414-0', 'Bajka', 'Gutenberg LLT', '1453', 'book about other books',  '2002-03-15',  '2022-03-15',2 ),
(book_sequence.nextval, '978-3-16-148415-0', 'Bajka', 'Gutenberg LLT', '1453', 'book about other books',  '2002-03-15',  '2022-03-15',3 ),
(book_sequence.nextval, '978-3-16-148416-0', 'Bajka', 'Gutenberg LLT', '1453', 'book about other books',  '2002-03-15',  '2022-03-15',4 ),
(book_sequence.nextval, '978-3-16-148417-0', 'Bajka', 'Gutenberg LLT', '1453', 'book about other books',  '2002-03-15',  '2022-03-15',5 ),
(book_sequence.nextval, '978-3-16-148418-0', 'Bajka', 'Gutenberg LLT', '1453', 'book about other books',  '2002-03-15',  '2022-03-15',6 );


INSERT INTO lending
(id, date_lending, date_returning, status, note, last_modified_date, user_id, book_id)
VALUES
(lending_sequence.nextval,  '1996-03-15', '2000-03-15', 'returned', 'no damage', '2000-03-15', 1,1 ),
(lending_sequence.nextval,  '1996-03-15', null, 'lended', null, '1996-03-15', 1,2 ),
(lending_sequence.nextval,  '2000-03-15', '2001-03-15', 'returned', 'no damage', '2000-03-15', 2,3 ),
(lending_sequence.nextval,  '2010-03-15', '2011-03-15', 'returned', 'no damage', '2000-03-15', 3,4 );
