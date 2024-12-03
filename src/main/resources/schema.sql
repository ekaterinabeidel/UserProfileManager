DROP TABLE IF EXISTS interest;
DROP TABLE IF EXISTS user_profile;
CREATE TABLE IF NOT EXISTS user_profile (
                                            id SERIAL PRIMARY KEY,
                                            name VARCHAR(50) NOT NULL,
                                            surname VARCHAR(50) NOT NULL,
                                            job_title VARCHAR(100),
                                            phone VARCHAR(15) NOT NULL,
                                            address VARCHAR(200),
                                            visibility VARCHAR(10) NOT NULL DEFAULT 'PRIVATE',
                                            avatar_url VARCHAR(200),
                                            profile_link VARCHAR(200),
                                            version INTEGER DEFAULT 0
);

CREATE TABLE IF NOT EXISTS interest (
                                        id SERIAL PRIMARY KEY,
                                        title VARCHAR(30) NOT NULL,
                                        user_profile_id INT NOT NULL,
                                        CONSTRAINT fk_user_profile FOREIGN KEY (user_profile_id) REFERENCES user_profile (id) ON DELETE CASCADE
);