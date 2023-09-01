CREATE TABLE goods_tbl(
                          gno int(4) not null PRIMARY KEY AUTO_INCREMENT,
                          ggoods varchar(100),
                          gcontent varchar(200),
                          gprice int(4),
                          gquan int(4),
                          gimgfile varchar(200)
);

SELECT * FROM goods_tbl

INSERT INTO goods_tbl (gno, ggoods, gcontent, gprice, gquan, gimgfile)
VALUES (NULL, '연습1', '연습1', '1000', '100', 'a.jpg');

DELETE FROM goods_tbl WHERE goods_tbl.gno = 1

UPDATE goods_tbl SET ggoods = '연습11',
                     gcontent = '연습11',
                     gprice = '10001',
                     gquan = '1001',
                     gimgfile = 'a.jpg1'
WHERE goods_tbl.gno = 1;