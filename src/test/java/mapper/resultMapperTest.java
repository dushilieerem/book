package mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.Employee;
import utils.SqlSessionUtil;

import static org.junit.jupiter.api.Assertions.*;

class resultMapperTest {

    @Test
    void getEmpAndDept() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        resultMapper mapper = sqlSession.getMapper(resultMapper.class);
        Employee empAndDept = mapper.getEmpAndDept(1);
        System.out.println(empAndDept);
    }
    @Test
    void getEmpAndDept1() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        resultMapper mapper = sqlSession.getMapper(resultMapper.class);
        Employee empAndDept = mapper.getEmpAndDept1(1);
        System.out.println(empAndDept);
    }
    @Test
    void getEmpAndDeptByStep() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        resultMapper mapper = sqlSession.getMapper(resultMapper.class);
        Employee empAndDeptByStepOne = mapper.getEmpAndDeptByStepOne(1);
        System.out.println(empAndDeptByStepOne);
    }
}