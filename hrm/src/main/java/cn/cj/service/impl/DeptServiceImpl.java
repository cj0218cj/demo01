package cn.cj.service.impl;

import cn.cj.dao.DeptMapper;
import cn.cj.model.Dept;
import cn.cj.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cj on 2018/7/31.
 */
@Service
public class DeptServiceImpl implements DeptService{
    @Resource
    private DeptMapper deptMapper;
    public Dept getDeptById(int d_id) {
        return deptMapper.getDeptById(d_id);
    }

    public Dept getDeptByName(String d_name) {
        return deptMapper.getDeptByName(d_name);
    }

    public List<Dept> getAllDept() {
        return deptMapper.getAllDept();
    }

    public int addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    public int deleteDept(Dept dept) {
        return deptMapper.deleteDept(dept);
    }

    public int updateDept(Dept dept) {
        return deptMapper.updateDept(dept);
    }

    public List<Dept> getCurrentPageDepts(int begin, int end) {
        return deptMapper.getCurrentPageDepts(begin,end);
    }
}
