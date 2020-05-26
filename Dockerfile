
FROM mysql

ENV MYSQL_DATABASE reservations
COPY ./bin/*.sql /docker-entrypoint-initdb.d/