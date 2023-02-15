package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Department;
import pojo.Employee;

public interface resultMapper {
//    级联方式处理映射关系
    Employee getEmpAndDept(@Param("empid") Integer empid);
//    使用association处理映射关系
    Employee getEmpAndDept1(@Param("eid")Integer eid);
//    分步查询
    Employee getEmpAndDeptByStepOne(@Param("eid")Integer eid);
    Department getEmpAndDeptByStepTwo(@Param("did")Integer id);
}
