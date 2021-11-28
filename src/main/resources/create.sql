-- СОЗДАНИЕ ТАБЛИЦ
CREATE TABLE IF NOT EXISTS coffeemachine(
   drink_id serial PRIMARY KEY,
   drink VARCHAR (50) NOT NULL,
    price INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS buyer(
	buyer_id serial PRIMARY KEY,
	b_name VARCHAR (50) UNIQUE NOT NULL,
);
CREATE TABLE IF NOT EXISTS drink_buyer
(
  drink_id integer NOT NULL,
  buyer_id integer NOT NULL,
  PRIMARY KEY (drink_id, buyer_id),
  CONSTRAINT drink_fk FOREIGN KEY (drink_id)
      REFERENCES coffeemachine (drink_id) MATCH FULL
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT buyer_fk FOREIGN KEY (buyer_id)
      REFERENCES buyer (buyer_id) MATCH FULL
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
-- ВСТАВКА ДАННЫХ В ТАБЛИЦУ
INSERT INTO coffeemachine (drink, price)
VALUES
('cappuchino', 100),
('americano', 120),
('irish coffee', 150),
('decaff', 200),
('espresso', 100);

INSERT INTO buyer (name)
VALUES
('Pupkin'),
('Zubkin'),
('Alesha'),
('Alena'),
('Ira');

INSERT INTO drink_buyer (buyer_id, drink_id)
VALUES
(1, 2),
(1, 3),
(2, 2),
(2, 4),
(3, 5),
(4, 1),
(1, 2),
(5, 1);