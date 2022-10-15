-- экспорт в Excel для работы
WbExport -type=xlsx
         -file='C:/tmp/whmgu.xlsx'
         -sourceTable=wh_*
         -nullString=NULL;

-- импорт из Excel в БД
WbImport -type=xlsx
         -mode=INSERT,UPDATE
         -file='C:/tmp/whmgu.xlsx'
         -sheetNumber=*
         -ignoreIdentityColumns
         -nullString=NULL;

