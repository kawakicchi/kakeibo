

SELECT
    MAX(no) as no
FROM
    td_receipt_item
WHERE
    receipt_id  = /* receiptId */''
