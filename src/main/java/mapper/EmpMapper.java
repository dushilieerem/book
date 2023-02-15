package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Employee;

public interface EmpMapper {
    Employee getDeptAndEmpByStepTwo(@Param("did") Integer did);
}
