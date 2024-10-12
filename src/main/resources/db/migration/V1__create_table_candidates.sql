CREATE TABLE candidates (
     id INT PRIMARY KEY AUTO_INCREMENT,
     name VARCHAR(100) NOT NULL,
     email VARCHAR(100) NOT NULL,
     gender VARCHAR(10) NOT NULL,
     expected_salary DECIMAL(10, 2),
     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     active BOOLEAN DEFAULT TRUE,
     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
     type_of_contract VARCHAR(50)
);

INSERT INTO candidates (name, email, gender, expected_salary, active, updated_at, type_of_contract) VALUES
                                                                                                        ('Luis Ventocilla', 'lvsmix@gmail.com', 'Male', 20000, TRUE, CURRENT_TIMESTAMP, 'Full-time'),
                                                                                                        ('Maxi Soria', 'maxsoria@example.com', 'Female', 35000, TRUE, CURRENT_TIMESTAMP, 'Part-time'),
                                                                                                        ('Gonzalo Smith', 'gsmith@example.com', 'Female', 50000, TRUE, CURRENT_TIMESTAMP, 'Contractor'),
                                                                                                        ('Marcelo Carmona', 'mcarmona@example.com', 'Male', 55000, TRUE, CURRENT_TIMESTAMP, 'Intern'),
                                                                                                        ('Miguel Black', 'miguel.black@example.com', 'Male', 60000, TRUE, CURRENT_TIMESTAMP, 'Freelance');