
SELECT
    /*%expand*/*
FROM
    tm_account
WHERE
    email = /* email */''
AND password = /* password */''
AND delete_flag = false
