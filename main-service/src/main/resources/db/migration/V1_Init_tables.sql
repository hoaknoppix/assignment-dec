create table token (
   id INT NOT NULL,
   phone_number VARCHAR(50) NOT NULL,
   encrypted_token VARCHAR(20) NOT NULL,
   expiration_date DATE
   );

create table voucher (
    id INT NOT NULL,
    phone_number VARCHAR(50) NOT NULL,
    voucher VARCHAR(20) NOT NULL,
    expiration_date DATE
    );