-- 코드를 입력하세요
SELECT i.INGREDIENT_TYPE, SUM(f.TOTAL_ORDER) as 'TOTAL_ORDER' from first_half f, icecream_info i where f.flavor = i.flavor group by i.ingredient_type order by (f.total_order)