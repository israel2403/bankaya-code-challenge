CREATE TABLE request_log (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    request VARCHAR(255),
    response VARCHAR(255),
    timestamp TIMESTAMP
);
