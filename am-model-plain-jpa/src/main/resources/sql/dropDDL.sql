ALTER TABLE TRANSACTION DROP FOREIGN KEY FK_TRANSACTION_PRODUCT_ID
ALTER TABLE TRANSACTION DROP FOREIGN KEY FK_TRANSACTION_CURRENCY_ID
ALTER TABLE PRODUCT DROP FOREIGN KEY FK_PRODUCT_UNDERLYING_ID
ALTER TABLE PRODUCT DROP FOREIGN KEY FK_PRODUCT_CURRENCY_ID
ALTER TABLE EXCHANGE_RATE DROP FOREIGN KEY FK_EXCHANGE_RATE_FROM_CURRENCY_ID
ALTER TABLE EXCHANGE_RATE DROP FOREIGN KEY FK_EXCHANGE_RATE_TO_CURRENCY_ID
DROP TABLE PROPERTY
DROP TABLE CURRENCY
DROP TABLE TRANSACTION
DROP TABLE PRODUCT
DROP TABLE EXCHANGE_RATE
