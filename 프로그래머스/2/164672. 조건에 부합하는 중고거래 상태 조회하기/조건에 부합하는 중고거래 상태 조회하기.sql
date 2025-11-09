-- 코드를 입력하세요
SELECT 
    BOARD_ID, 
    WRITER_ID, 
    TITLE, 
    PRICE,
    CASE
        WHEN STATUS = 'SALE' THEN '판매중'
        WHEN STATUS = 'DONE' THEN '거래완료'
        WHEN STATUS = 'RESERVED' THEN '예약중'
    END AS STATUS 
FROM USED_GOODS_BOARD
WHERE 
    year(CREATED_DATE) = '2022' 
    AND month(CREATED_DATE) = '10' 
    AND day(CREATED_DATE) = '05'
ORDER BY 1 DESC