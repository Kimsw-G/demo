SELECT
    COUNT(
        CASE
            WHEN tp.todonum IN(
                SELECT
                    t
                FROM
                    todo AS t
                WHERE
                    t.suser = :user
            )
            AND tp.dday = :date
            AND tp.flag = 1
        ) / COUNT(
            CASE
                WHEN tp.todonum IN(
                    SELECT
                        t
                    FROM
                        todo AS t
                    WHERE
                        t.suser = :user
                )
                AND tp.dday = :date
            )
            FROM
                todo_progress as tp;

SELECT
    (
        SELECT
            COUNT(*)
        FROM
            todo_progress as tp
        WHERE
            tp.todonum = 1
            AND tp.flag = 1
    ) / (
        SELECT
            COUNT(*)
        FROM
            todo_progress as tp
        WHERE
            tp.todonum = 1
    ) AS B;

SELECT
    e
FROM
    event AS e
WHERE
    e.suser = :user
    AND e.dday BETWEEN :date
    AND LAST_DAY(:date)