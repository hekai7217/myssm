package com.lx.mapper;

import com.lx.bean.User;
import org.apache.ibatis.annotations.*;

/**
 * 注解测试
 */
public interface UserDao {

    /**
     * 添加的操作
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    @ResultType(User.class)
    public User queryUserById(@Param("id") int id);

    /**
     * 插入操作
     * @param
     */
//    @Insert("insert into user(username,address) values (#{username},#{address})")
//    public void saveUser(@Param("username") String username,@Param("address")String address);

    @Insert("insert into user(username,address) values (#{user.username},#{user.address})")
    public void saveUser(@Param("user") User user);

    /**
     * 更新操作
     * @param id
     */
    @Update("update user set username = #{username} where id = #{id}")
    public void updateUser(@Param("id") int id,@Param("username") String username);

    /**
     * 删除操作
     * @param id
     */
    @Delete("delete from user where id = #{id}")
    public void deleteUser(@Param("id")int id);


}
