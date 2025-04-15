CREATE DATABASE logger_db_server;
GO

USE [logger_db];
GO

CREATE LOGIN admin WITH PASSWORD = 'admin123', CHECK_POLICY=OFF;
GO

CREATE USER admin FOR LOGIN admin;
GO

ALTER ROLE db_owner ADD MEMBER admin;
GO
