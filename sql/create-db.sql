create database whmgu;
create user whmgu with encrypted password 'A123456b';
grant all privileges on database whmgu to whmgu;
commit;