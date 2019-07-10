package com.lx.springboot_stu_privoder.mapper;

import com.lx.bean.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * create by hekai  2019-07-10
 *
 * @desc  stu 的mapper 接口
 */
@Mapper
public interface StuMapper {

    /**
     *  查询所有的学生
     * @return
     */
    public List<Student> queryStus();

    /**
     *  插入 一个 stu
     * @param stu
     * @return
     */
    public int insertStu(Student stu);

    /**
     *   通过 id 删除  stu
     * @param id
     * @return
     */
    public int delStu(int id);


}
