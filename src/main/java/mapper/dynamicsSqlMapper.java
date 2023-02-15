package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Employee;

import java.util.List;

public interface dynamicsSqlMapper {

//    动态sql

    List<Employee> getEmpByCondition(Employee employee);
// where标签
    /*
    *- where和if一般结合使用：
    -    若where标签中的if条件都不满足，则where标签没有任何功能，即不会添加where关键字
   - 若where标签中的if条件满足，则where标签会自动添加where关键字，并将条件最前方多余的and/or去掉
    */
    List<Employee> getEmpByCondition1(Employee employee);
    /*
    *- trim用于去掉或添加标签中的内容
- 常用属性
 - prefix：在trim标签中的内容的前面添加某些内容
   - suffix：在trim标签中的内容的后面添加某些内容
   - prefixOverrides：在trim标签中的内容的前面去掉某些内容
   - suffixOverrides：在trim标签中的内容的后面去掉某些内容
- 若trim中的标签都不满足条件，则trim标签没有任何效果，也就是只剩下`select * from t_emp`
    * */
    List<Employee> getEmpByCondition2(Employee employee);
    /*- `choose、when、otherwise`相当于`if...else if..else`
- when至少要有一个，otherwise至多只有一个
*/
    List<Employee> getEmpByCondition3(Employee employee);
    /*- 属性：
 - collection：设置要循环的数组或集合
   - item：表示集合或数组中的每一个数据
   - separator：设置循环体之间的分隔符，分隔符前后默认有一个空格，如` , `
   - open：设置foreach标签中的内容的开始符
   - close：设置foreach标签中的内容的结束符*/
    int deleteMoreByArray(@Param("eids") Integer[] eids);
    int insertMoreByList(@Param("eids") List<Employee> employeeList);
}
