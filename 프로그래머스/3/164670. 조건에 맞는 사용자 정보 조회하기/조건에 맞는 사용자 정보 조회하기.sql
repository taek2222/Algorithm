-- 코드를 입력하세요
SELECT 
    USER_ID, 
    NICKNAME, 
    CONCAT_WS(" ", CITY, STREET_ADDRESS1, STREET_ADDRESS2) AS 전체주소,
    CONCAT_WS("-",
        substring(TLNO, 1, 3),
        substring(TLNO, 4, 4),
        substring(TLNO, 8)
    ) AS 전화번호
FROM USED_GOODS_BOARD b JOIN USED_GOODS_USER u
    ON b.WRITER_ID = u.USER_ID
GROUP BY b.WRITER_ID HAVING COUNT(WRITER_ID) >= 3
ORDER BY u.USER_ID DESC