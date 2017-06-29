
# --- !Ups
INSERT INTO store VALUES ('s1', 'store  numéro 1', 'no picture', 20, 'euro' );
INSERT INTO store  VALUES ('s2', 'store numéro 2', 'no picture', 20, 'euro' );
INSERT INTO store VALUES ('s3', 'store numéro 3', 'no picture', 20, 'euro');

INSERT INTO product VALUES ('p1', 'product  numéro 1', 'no picture', '11/05/2017');
INSERT INTO product  VALUES ('p2', 'product numéro 2', 'no picture', '12/05/2017');
INSERT INTO product VALUES ('p3', 'product numéro 3', 'no picture', '13/05/2017');


INSERT INTO stock VALUES ('on','11/05/2017','19/06/2017',10,20,100);
INSERT INTO stock VALUES ('off','11/05/2017','19/06/2017',11,20,200);
INSERT INTO stock VALUES ('idle','11/05/2017','19/06/2017',12,20,300);

# --- !Downs
delete from product; 
delete from store; 	
delete from stock;	
