# Overview

� ���������� ���������� ���������� ������������ ������� ���������� �������. 

����������� 2 ���������:
- ��������� @TrackTime - ������ ���������� ���� ���������� ���������� ���������, � ����������� ����������� � �� ������
� ������� ���������� ������.
- ��������� @TrackAsyncTime - ��������� �������� � ���� ��������� @Async. ������ ���������� ���� ���������� ���������� ����������, 
� ����������� ����������� � �� ������ � ������� ���������� ������.

��� ������ ���������� ��� ������������ ����������� 10 ������� � ���������� @TrackTime. ����� �� ���������� �����������
50 ������� � ���������� @TrackAsyncTime. ���������� �� ���������� ����������� � ��. 

�������� ������ ������� � ��� ���������� � ������ ������, ������������� ����� �� 1 �������, 
����� ������� ���������� �� ��������� ���������� ������.

������������ ����������� �������������� � �����������:
- �������� ���������� �� ���� �������, �������������� � ��
- �������� ���������� �� ����������� ������
- ����� ������������ ���������� ������ � ���������� @TrackTime;
- ����� ���������� ������ � ���������� @TrackTime N ���;
- ����� ������������ ���������� ������ � ���������� @TrackAsyncTime;
- ����� ���������� ������ � ���������� @TrackAsyncTime N ���.

### Open-API: src/main/resources/openapi/api-docs.json

## ������ ����������

������ ���������� � �� ���������� � ���������� � ������� docker-compose. ��������� ��������� ����������.

1. ���������� �����������

2. � ��������� ��������� � ����� � ��������.

3. � ��������� ��������� �������� �������
    ```
    docker-compose up
    ```

4. ����� ������ ���������� �� ��������� ���������� �� ����� 8080, Swagger UI ����������� �� ������ /swagger-ui/index.html

## ����������

��� ���������� ����������� ��������� ���� ����������:
- Java 17
- Spring Boot 3.2.4
- Spring Data JPA
- Spring AOP
- PostgreSQL
- Liquibase
- Lombok
- MasStruct
- OpenAPI