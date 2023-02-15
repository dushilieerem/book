package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Employee;

public interface CacheMapper {
    Employee cacheone(@Param("eid") Integer id);
    Employee cacheTwo(@Param("eid")Integer id);
}
