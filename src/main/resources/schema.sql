CREATE TABLE IF NOT EXISTS user_profile (
                                            id SERIAL PRIMARY KEY,
                                            name VARCHAR(50) NOT NULL,
                                            surname VARCHAR(50) NOT NULL,
                                            job_title VARCHAR(100),
                                            phone VARCHAR(15) NOT NULL,
                                            address VARCHAR(200),
                                            is_public BOOLEAN NOT NULL DEFAULT FALSE,
                                            avatar_url VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS interest (
                                        id SERIAL PRIMARY KEY,
                                        title VARCHAR(30) NOT NULL,
                                        user_profile_id INT NOT NULL,
                                        CONSTRAINT fk_user_profile FOREIGN KEY (user_profile_id) REFERENCES user_profile (id) ON DELETE CASCADE
);