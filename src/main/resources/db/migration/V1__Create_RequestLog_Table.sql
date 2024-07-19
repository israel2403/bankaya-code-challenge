CREATE TABLE request_log (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    ip VARCHAR(255),
    request_date TIMESTAMP,
    method VARCHAR(255),
    duration BIGINT,
    request TEXT,
    response TEXT
);
