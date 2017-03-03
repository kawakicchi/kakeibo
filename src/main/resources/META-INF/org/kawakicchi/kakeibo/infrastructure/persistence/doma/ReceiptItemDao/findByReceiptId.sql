
SELECT
    /*%expand*/*
FROM
    td_receipt_item
WHERE
    receipt_id  = /* receiptId */''
AND delete_flag = false
ORDER BY
    no
