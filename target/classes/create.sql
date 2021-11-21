-- СОЗДАНИЕ ТАБЛИЦ
CREATE TABLE IF NOT EXISTS coffeemachine(
   drink_id serial PRIMARY KEY,
   drink VARCHAR (50) NOT NULL,
    price INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS buyer(
	buyer_id serial PRIMARY KEY,
	b_name VARCHAR (50) UNIQUE NOT NULL,
	purchase_date TIMESTAMP NOT NULL,
	drink_id INTEGER NOT NULL,
	CONSTRAINT drink_buyer FOREIGN KEY (drink_id)
	REFERENCES coffeemachine(drink_id)
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

INSERT INTO buyer (name, purchase_date, drink_id)
VALUES
('Pupkin', '2021-10-19 10:23', 1),
('Zubkin', '2021-03-27 16:33', 3),
('Alesha', '2021-11-12 17:10', 2),
('Alena','2021-08-07 11:55', 4),
('Ira', '2021-07-01 21:30', 1),
