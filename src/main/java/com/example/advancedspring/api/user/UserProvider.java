package com.example.advancedspring.api.user;

import org.apache.ibatis.jdbc.SQL;

public class UserProvider {
    private static final String tableName = "students";

    public String buildUserInsertSql(){
        return new SQL(){{
            INSERT_INTO(tableName);
            VALUES("name","#{u.name}");
            VALUES("gender","#{u.gender}");
            VALUES("age","#{u.age}");
        }}.toString();

    }

    public String buildSelectUserByIdSql(){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
            WHERE("id=#{id}");
        }}.toString();
    }
    public String buildSelectAllUserSql(){
        return new SQL(){{
            SELECT("*");
            FROM(tableName);
            WHERE("is_deleted=FALSE");
        }}.toString();
    }
    public String buildDeletedUserSql(){
        return new SQL(){{
            DELETE_FROM(tableName);
            WHERE("id=#{id}");
        }}.toString();
    }
}
