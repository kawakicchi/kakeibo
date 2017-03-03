
SELECT
    A.kakeibo_id
  , A.title
  , A.memo
  , A.group_id
  , A.account_id
  , A.delete_flag
FROM
    td_kakeibo       A
  , tr_group_account B
  , tm_account       C
WHERE
    A.kakeibo_id  = /* kakeiboId */''
AND A.delete_flag = false
AND A.group_id    = B.group_id
AND C.account_id  = B.account_id
AND C.account_id  = /* accountId */''
AND C.delete_flag = false
