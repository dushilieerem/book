package mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.Employee;
import utils.SqlSessionUtil;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class dynamicsSqlMapperTest {

    @Test
    void getEmpByCondition() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        dynamicsSqlMapper mapper = sqlSession.getMapper(dynamicsSqlMapper.class);

        List<Employee> lis = mapper.getEmpByCondition(new Employee(0, null, "23", null, null));
        System.out.println(lis);
    }
    @Test
    void getEmpByCondition1() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        dynamicsSqlMapper mapper = sqlSession.getMapper(dynamicsSqlMapper.class);

        List<Employee> lis = mapper.getEmpByCondition1(new Employee(0, null, "23", null, null));
        System.out.println(lis);
    }
    @Test
    void getEmpByCondition2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        dynamicsSqlMapper mapper = sqlSession.getMapper(dynamicsSqlMapper.class);

        List<Employee> lis = mapper.getEmpByCondition2(new Employee(0, null, "23", null, null));
        System.out.println(lis);
    }
    @Test
    void getEmpByCondition3() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        dynamicsSqlMapper mapper = sqlSession.getMapper(dynamicsSqlMapper.class);

        List<Employee> lis = mapper.getEmpByCondition2(new Employee(0, null, null, null, null));
        System.out.println(lis);
    }
    @Test
    void deleteMoreByArray() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        dynamicsSqlMapper mapper = sqlSession.getMapper(dynamicsSqlMapper.class);
mapper.deleteMoreByArray(new Integer[]{2,3,4,5});


    }
    @Test
    void insertMoreByList() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        dynamicsSqlMapper mapper = sqlSession.getMapper(dynamicsSqlMapper.class);
        Employee employee=new Employee(null,"1","23","","");
        Employee employee1=new Employee(null,"1","23","","");
        Employee employee2=new Employee(null,"1","23","","");
        Employee employee3=new Employee(null,"1","23","","");
        List<Employee> list=new ArrayList<>();
        list.add(employee);
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        mapper.insertMoreByList(list);


    }
}