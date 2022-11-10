-- 코드를 입력하세요
SELECT PT_NAME, PT_NO, GEND_CD, AGE, ifnull(tlno, 'NONE') as TLNO from PATIENT where AGE <=12 and gend_cd LIKE 'W' order by age desc, pt_name asc