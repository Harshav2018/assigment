INSERT INTO users (username, password, role, email) VALUES 
('admin', 'password', 'admin', 'admin@example.com'),
('user', 'password', 'customer', 'user@example.com');

INSERT INTO products (name, price, stock, category) VALUES 
('Laptop', 999.99, 10, 'Electronics'),
('Mouse', 25.50, 50, 'Electronics');

INSERT INTO carts (user_id, total_amount) VALUES 
(1, 0.0),
(2, 0.0);
