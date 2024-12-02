INSERT INTO user_profile (name, surname, job_title, phone, address, is_public, avatar_url)
VALUES
    ('Albert', 'Einstein', 'Theoretical Physicist', '+79991234567', 'Princeton', true, 'https://example.com/avatar1.jpg'),
    ('Isaac', 'Newton', 'Mathematician and Physicist', '+79991234568', 'Cambridge', true, 'https://example.com/avatar2.jpg'),
    ('Marie', 'Curie', 'Physicist and Chemist', '+79991234569', 'Paris', false, 'https://example.com/avatar3.jpg'),
    ('Niels', 'Bohr', 'Quantum Physicist', '+79991234570', 'Copenhagen', true, NULL),
    ('Richard', 'Feynman', 'Theoretical Physicist', '+79991234571', 'Pasadena', false, 'https://example.com/avatar4.jpg'),
    ('Galileo', 'Galilei', 'Astronomer and Physicist', '+79991234572', 'Florence', true, 'https://example.com/avatar5.jpg'),
    ('James', 'Clerk Maxwell', 'Physicist', '+79991234573', 'Edinburgh', false, 'https://example.com/avatar6.jpg'),
    ('Michael', 'Faraday', 'Experimental Physicist', '+79991234574', 'London', true, NULL),
    ('Erwin', 'Schrodinger', 'Quantum Physicist', '+79991234575', 'Vienna', false, 'https://example.com/avatar7.jpg'),
    ('Werner', 'Heisenberg', 'Theoretical Physicist', '+79991234576', 'Munich', true, 'https://example.com/avatar8.jpg');

INSERT INTO interest (title, user_profile_id)
VALUES
    ('Relativity', 1),
    ('Quantum Mechanics', 1),
    ('Classical Mechanics', 2),
    ('Calculus', 2),
    ('Radioactivity', 3),
    ('Chemistry', 3),
    ('Quantum Theory', 4),
    ('Atomic Structure', 4),
    ('Path Integrals', 5),
    ('Electrodynamics', 5),
    ('Astronomy', 6),
    ('Motion', 6),
    ('Electromagnetism', 7),
    ('Field Theory', 7),
    ('Electricity', 8),
    ('Magnetism', 8),
    ('Wave Mechanics', 9),
    ('Quantum Theory', 9),
    ('Uncertainty Principle', 10),
    ('Nuclear Physics', 10);
