INSERT INTO user_profile (name, surname, job_title, phone, address, visibility, avatar_url, profile_link)
VALUES
    ('Albert', 'Einstein', 'Theoretical Physicist', '+79991234567', 'Princeton', 'PUBLIC', 'https://example.com/avatar1.jpg', 'https://example.com/profiles/einstein'),
    ('Isaac', 'Newton', 'Mathematician and Physicist', '+79991234568', 'Cambridge', 'PUBLIC', 'https://example.com/avatar2.jpg', 'https://example.com/profiles/newton'),
    ('Marie', 'Curie', 'Physicist and Chemist', '+79991234569', 'Paris', 'PUBLIC', 'https://example.com/avatar3.jpg', 'https://example.com/profiles/curie'),
    ('Niels', 'Bohr', 'Quantum Physicist', '+79991234570', 'Copenhagen', 'PUBLIC', NULL, 'https://example.com/profiles/bohr'),
    ('Richard', 'Feynman', 'Theoretical Physicist', '+79991234571', 'Pasadena', 'PUBLIC', 'https://example.com/avatar4.jpg', 'https://example.com/profiles/feynman'),
    ('Galileo', 'Galilei', 'Astronomer and Physicist', '+79991234572', 'Florence', 'PRIVATE', 'https://example.com/avatar5.jpg', 'https://example.com/profiles/galilei'),
    ('James', 'Clerk Maxwell', 'Physicist', '+79991234573', 'Edinburgh', 'PRIVATE', 'https://example.com/avatar6.jpg', 'https://example.com/profiles/maxwell'),
    ('Michael', 'Faraday', 'Experimental Physicist', '+79991234574', 'London', 'PRIVATE', NULL, 'https://example.com/profiles/faraday'),
    ('Erwin', 'Schrodinger', 'Quantum Physicist', '+79991234575', 'Vienna', 'PRIVATE', 'https://example.com/avatar7.jpg', 'https://example.com/profiles/schrodinger'),
    ('Werner', 'Heisenberg', 'Theoretical Physicist', '+79991234576', 'Munich', 'PRIVATE', 'https://example.com/avatar8.jpg', 'https://example.com/profiles/heisenberg');

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
