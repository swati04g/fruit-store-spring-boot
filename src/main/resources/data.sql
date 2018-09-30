INSERT INTO category(id, name) VALUES (0,'berry');
INSERT INTO category(id, name) VALUES (1,'citrus');

insert into item (id, name, price, description, category_id) values (1, 'strawberry', 5.00, 'strawberry is a berry fruit.', (select id from category where name='berry'));
insert into item (id, name, price, description, category_id) values (2, 'blueberry', 4.00, 'blueberry is a berry fruit.', (select id from category where name='berry'));
insert into item (id, name, price, description, category_id) values (3, 'cranberry', 6.00, 'cranberry is a berry fruit.', (select id from category where name='berry'));
insert into item (id, name, price, description, category_id) values (4, 'grapefruit', 3.00, 'grapefruit is a citrus fruit.', (select id from category where name='citrus'));
insert into item (id, name, price, description, category_id) values (5, 'orange',2.00, 'orange is a citrus fruit.', (select id from category where name='citrus'));
