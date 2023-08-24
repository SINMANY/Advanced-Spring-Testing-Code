package com.example.advancedspring.api.user;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface UserMapper {

    @InsertProvider(type = UserProvider.class, method = "buildUserInsertSql")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(@Param("u") User user);

    @SelectProvider(type = UserProvider.class, method = "buildSelectUserByIdSql")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    @Results(id = "resultsMap", value = {
            @Result(column = "name", property = "name"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "age", property = "age"),
    })
    Optional<User> selectUserById(@Param("id") Integer id);

    @SelectProvider(type = UserProvider.class, method = "buildSelectAllUserSql")
    List<User> select();

    @Select("SELECT EXISTS(SELECT * FROM students WHERE id=#{id})")
    boolean isExistedById(@Param("id") Integer id);

    @DeleteProvider(type = UserProvider.class, method = "buildDeletedUserSql")
    void deletedById(@Param("id") Integer id);

}
