drop database if exists homesideFinancial;
create database homesideFinancial;

use homesideFinancial;

create table loan_sales_data (
branchName varchar(50) not null,
loanNumber varchar(50) not null,
loanAmount varchar(50) not null
) engine=InnoDB default charset=utf8;

select branchName, count(*) as units, sum(loanAmount) as branchTotal
from homesideFinancial.loan_sales_data 
group by branchName asc;

select * from loan_sales_data;

select *
from homesideFinancial.loan_sales_data 
where branchName = 'Columbus';

