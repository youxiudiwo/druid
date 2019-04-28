package com.zuoshao.springboot.mapper;

import com.zuoshao.springboot.bean.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * @author zuoshao
 * @date 2019/3/25 - 19:13
 */
@Component
@Mapper
public interface Departmentmapper {

    @Select("select * from department where id=#{id}")
    public Department getbydeptId(Integer id);

    @Delete("delet from department where id=#{id}")
    public int deletedept(Integer id);

    @Insert("insert into department(departmentname) values(#{departmentName})")
    public int insertdept(Department department);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    public  int delete(Department department);
}
