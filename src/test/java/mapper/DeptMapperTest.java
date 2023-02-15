package mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import pojo.Department;
import utils.SqlSessionUtil;

import static org.junit.jupiter.api.Assertions.*;

class DeptMapperTest {

    @Test
    void getDeptAndEmp() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Department deptAndEmp = mapper.getDeptAndEmp(1);
        System.out.println(deptAndEmp);
    }
    @Test
    void getDeptAndEmpByStep() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Department deptAndEmp = mapper.getDeptAndEmpByStepOne(1);
        System.out.println(deptAndEmp);
    }
}