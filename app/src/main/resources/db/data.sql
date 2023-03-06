INSERT INTO address (id, city, street, house_number, apartment_number)
VALUES (1, 'Гомель', 'Ленина', '23', '34'),
       (2, 'Гомель', 'Советская', '34', '42'),
       (3, 'Гомель', 'Луговая', '17', '1'),
       (4, 'Гомель', 'Полевая', '67', '2');
INSERT INTO passport(id, uniq_number, passport_number)
VALUES (1, '345673uf74679', 'hb46473473'),
       (2, '647484389yf88', 'yu74746784'),
       (3, '65738ug885748', 'hb76849483'),
       (4, '8548488hg7575', 'hb57774755');
INSERT INTO client(id, name, sur_name, address_id, passport_id)
VALUES (1, 'Вася', 'Пупкин', 1, 1),
       (2, 'Петя', 'Дудкин', 2, 2),
       (3, 'Саша', 'Трубкин', 3, 3),
       (4, 'Гриша', 'Уткин', 4, 4);
INSERT INTO phone_number(id, number, active)
VALUES (1, '+375336578476', false),
       (2, '+375337587456', false),
       (3, '+375298706758', false),
       (4, '+375446578476', false),
       (5, '+375297564875', true);
INSERT INTO tariff_plan(id,name, free_minute, price, is_archive)
VALUES (1,'Отличный', 200, 40.5, false),
       (2,'Прекрасный', 300, 30, false),
       (3,'Замечательный', 150, 25, true);
INSERT INTO contract(date, number_for_contract, client_id, phone_number_id, tariff_plan_id)
VALUES ('2023-01-23 12:00:00 +00:00', '000001', 1, 1, 1),
       ('2023-02-01 14:00:00 +00:00', '000002', 2, 2, 2),
       ('2023-02-22 11:45:00 +00:00', '000003', 3, 3, 1),
       ('2023-03-01 00:00:00 +00:00', '000004', 4, 4, 2);
