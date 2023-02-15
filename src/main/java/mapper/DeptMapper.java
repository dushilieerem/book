package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Department;

public interface DeptMapper {
   /*
collection:
- collection：用来处理一对多的映射关系
- ofType：表示该属性对饮的集合中存储的数据的类型
   */
    Department getDeptAndEmp(@Param("did") Integer did);
//    分步查询
    Department getDeptAndEmpByStepOne(@Param("did") Integer did);
}
