/*
	Springboot 연동 쿼리
*/

-- 테이블 저장을 위한 데이터베이스 생성
create database hrdb_spring;

-- 데이터베이스 확인
use hrdb_spring;
select database();

-- 모든 테이블 확인
show tables;

-- Employee 테이블 생성 및 삭제
DROP TABLE employee;
CREATE TABLE employee(
	sno		int		PRIMARY KEY,
    name	varchar(10),
    address varchar(30),
    edate date
);

-- 테이블 생성 확인
DESC employee;

/*
	C(Creata): 데이터 추가
    R(Read): 데이터 조회
    U(Update): 데이터 수정
    D(Delete): 데이터 삭제
*/

-- C(Creata): 데이터 추가
-- now(): 현재 시스템이 가지고 있는 날짜를 가져옴.
INSERT INTO employee(sno, name, address, edate)
VALUES(2345, '김유신', '경기도 구리시', now());

-- R(Read): 데이터 조회
select * from employee;

-- U(Update): 데이터 수정
UPDATE employee SET name='홍길순' WHERE sno=1234;
UPDATE employee SET name='홍길동', address='부산시 해운대구' WHERE sno=1234;
UPDATE employee SET department = 'sales' WHERE department IS NULL;

-- D(Delete): 데이터 삭제
DELETE from employee WHERE sno=2345;

-- 테이블에 컬럼 추가
ALTER TABLE employee ADD column department varchar(20);

-- mysql에서 update/delete 실행 제어 명렁어
SET sql_safe_updates = 0;