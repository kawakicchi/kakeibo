
SELECT
    /*%expand*/*
FROM
    td_receipt
WHERE
    kakeibo_id  = /* kakeiboId */''
AND date >= /* fromDate */'2017/01/01 00:00:00'
AND date <  /* toDate */'2017/01/31 00:00:00'
AND delete_flag = false
ORDER BY
    date
