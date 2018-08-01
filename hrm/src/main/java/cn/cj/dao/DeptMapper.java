package cn.cj.dao;

import cn.cj.model.Dept;

import java.util.List;

/**
 * Created by cj on 2018/7/31.
 */
public interface DeptMapper {
    Dept getDeptById(int d_id);
    Dept getDeptByName(String d_name);
    List<Dept> getAllDept();
    int addDept(Dept dept);
    int deleteDept(Dept dept);
    int updateDept(Dept dept);
    List<Dept> getCurrentPageDepts(int begin,int end);
}
