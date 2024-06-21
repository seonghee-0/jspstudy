DROP TABLE book_t;
CREATE TABLE book_t (
  book_no NUMBER             NOT NULL,
  title   VARCHAR2(100 BYTE) NOT NULL,
  author  VARCHAR2(100 BYTE),
  price   NUMBER,
  CONSTRAINT pk_book PRIMARY KEY(book_no)
);

-- ��ȣǥ ��� : ������
DROP SEQUENCE book_seq;
CREATE SEQUENCE book_seq;

-- ��ȣǥ �̱� : nextval
-- SELECT book_seq.nextval FROM dual;
-- SELECT book_seq.nextval FROM dual;
-- SELECT book_seq.nextval FROM dual;

-- �ű� å �߰��ϱ�
 INSERT INTO book_t(book_no, title, author, price) VALUES(book_seq.nextval, '����1', '����1', 10);
 INSERT INTO book_t(book_no, title, author, price) VALUES(book_seq.nextval, '����2', '����2', 20);
 INSERT INTO book_t(book_no, title, author, price) VALUES(book_seq.nextval, '����3', '����3', 30);
 INSERT INTO book_t(book_no, title, author, price) VALUES(book_seq.nextval, '����4', '����4', 40);
 INSERT INTO book_t(book_no, title, author, price) VALUES(book_seq.nextval, '����5', '����5', 50);
 COMMIT;

-- ���� å �����ϱ�
-- UPDATE book_t SET title = '��������', author = '��������', price = '987' WHERE book_no = 1
-- COMMIT;

-- ���� å �����ϱ�
-- DELETE FROM book_t where book_no = 1;
-- COMMIT;

-- ��ü å ��ȸ�ϱ�
SELECT book_no, title, author, price FROM book_t;

-- Ư�� å ��ȸ�ϱ�
SELECT book_no, title, author, price FROM book_t WHERE book_no = 1;



