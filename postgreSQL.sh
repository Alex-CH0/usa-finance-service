#! /bin/zsh

echo "Initializing PostgreSQL setting"

docker pull postgres:17.2-alpine
docker volume create pgdata
docker run -p 5432:5432 --name postgres_db -e POSTGRES_PASSWORD=1231 -d -v pgdata:/var/lib/postgresql/data postgres:17.2-alpine

# db bash 접속 후

# 기본 계정 접속
# psql -U postgres
# CREATE DATABASE devalex;

# 계정 생성 및 권한 부여
# CREATE USER admin_alex WITH PASSWORD '1231';
# GRANT ALL PRIVILEGES ON DATABASE devalex TO admin_alex;

# 스키마 생성
# \c devalex
# \dn 스키마 목록조회
# CREATE SCHEMA finance

