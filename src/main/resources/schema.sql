CREATE TABLE IF NOT EXISTS translation_details (
    id BIGINT NOT NULL AUTO_INCREMENT,
    source_text VARCHAR NOT NULL,
    translated_text VARCHAR NOT NULL,
    to_language CHAR(5) NOT NULL,
    ip CHAR(15),
    request_date TIMESTAMP NOT NULL,
    PRIMARY KEY (id)
);