INSERT INTO categories (display_name) VALUES ('Áo thun');
INSERT INTO categories (display_name) VALUES ('Áo Phông');
INSERT INTO categories (display_name) VALUES ('Áo dài tay');
INSERT INTO categories (display_name) VALUES ('Quần jeans');
INSERT INTO categories (display_name) VALUES ('Chân váy');


INSERT INTO products (display_name, quantity, status, description, currency, price, category_id) VALUES ('Áo thun in logo', 20, 'instock', 'description', 'VND', 150000, 1);
INSERT INTO products (display_name, quantity, status, description, currency, price, category_id) VALUES ('Áo thun in logo', 20, 'instock', 'description', 'VND', 50000, 1);
INSERT INTO products (display_name, quantity, status, description, currency, price, category_id) VALUES ('Quần jean S2', 20, 'instock', 'description', 'VND', 450000, 4);
INSERT INTO products (display_name, quantity, status, description, currency, price, category_id) VALUES ('Chân váy kẻ caro', 20, 'instock', 'description', 'VND', 150000, 5);
INSERT INTO products (display_name, quantity, status, description, currency, price, category_id) VALUES ('Áo phông in logo', 20, 'instock', 'description', 'VND', 150000, 2);
INSERT INTO products (display_name, quantity, status, description, currency, price, category_id) VALUES ('Áo thun in logo', 20, 'instock', 'description', 'VND', 350000, 1);
INSERT INTO products (display_name, quantity, status, description, currency, price, category_id) VALUES ('Áo thun in logo', 20, 'instock', 'description', 'VND', 250000, 1);


INSERT INTO accounts (display_name, email, password, roles, status) VALUES ('NgocDinh', 'ngokhoghat@gmail.com', '$2y$12$dYzMqs8k7dpqmFyNfK3vP.QNv3xON9rfke3cxPowuy52e6BqVr9rK', 'ADMIN', 1);
INSERT INTO accounts (display_name, email, password, roles, status) VALUES ('NgocDinh1', 'ngokhoghat1@gmail.com', '8832310', 'employee', 1);
INSERT INTO accounts (display_name, email, password, roles, status) VALUES ('NgocDinh2', 'ngokhoghat2@gmail.com', '8832310', 'customer', 1);
INSERT INTO accounts (display_name, email, password, roles, status) VALUES ('NgocDinh3', 'ngokhoghat3@gmail.com', '8832310', 'customer', 0);
INSERT INTO accounts (display_name, email, password, roles, status) VALUES ('NgocDinh4', 'ngokhoghat4@gmail.com', '8832310', 'customer', 1);

INSERT INTO payments (payment_type, allowed) VALUES ('Thanh toán khi giao hàng', 1);
INSERT INTO payments (payment_type, allowed) VALUES ('Chuyển khoản', 0);

