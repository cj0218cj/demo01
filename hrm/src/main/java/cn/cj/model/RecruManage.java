package cn.cj.model;

import java.io.Serializable;

/**
 * Created by cj on 2018/7/29.
 * 投递简历后的简历和职位管理类
 */
public class RecruManage implements Serializable{
    private int rm_id;
    private Recruitment recruitment;
    private Resumes resumes;
    private int state;
    //state=0   投递简历    state=1 面试邀请    state=2 确认面试    state=3 面试合格
    private User user;

    public RecruManage() {
    }

    public RecruManage(int state, User user) {
        this.state = state;
        this.user = user;
    }

    public RecruManage(Recruitment recruitment, Resumes resumes, User user) {
        this.recruitment = recruitment;
        this.resumes = resumes;
        this.user = user;
    }

    public RecruManage(Recruitment recruitment, Resumes resumes, int state) {
        this.recruitment = recruitment;
        this.resumes = resumes;
        this.state = state;
    }

    public RecruManage(int rm_id, Recruitment recruitment, Resumes resumes, int state) {
        this.rm_id = rm_id;
        this.recruitment = recruitment;
        this.resumes = resumes;
        this.state = state;
    }

    public int getRm_id() {
        return rm_id;
    }

    public void setRm_id(int rm_id) {
        this.rm_id = rm_id;
    }

    public Recruitment getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(Recruitment recruitment) {
        this.recruitment = recruitment;
    }

    public Resumes getResumes() {
        return resumes;
    }

    public void setResumes(Resumes resumes) {
        this.resumes = resumes;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "RecruManage{" +
                "rm_id=" + rm_id +
                ", recruitment=" + recruitment +
                ", resumes=" + resumes +
                ", state=" + state +
                '}';
    }
}
