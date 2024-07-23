ALTER TABLE request_log 
    DROP COLUMN timestamp,
    MODIFY request TEXT,
    MODIFY response TEXT;
