package cn.cj.model;

import java.io.Serializable;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cj on 2018/7/26.
 * ¼òÀú
 */
public class Resumes implements Serializable{
    private int r_id;
    private User r_user;
    private String r_name;
    private int r_age;
    private String r_sex;
    private String r_school;
    private String r_major;
    private int r_phone;
    private String r_workingYears;
    private String r_workExperience;
    private String r_introduce;
    private List<RecruManage> recruManages=new ArrayList<RecruManage>();
    public Resumes() {
    }

    public Resumes(User r_user, String r_name, int r_age, String r_sex, String r_school, String r_major, int r_phone, String r_workingYears, String r_workExperience, String r_introduce) {
        this.r_user = r_user;
        this.r_name = r_name;
        this.r_age = r_age;
        this.r_sex = r_sex;
        this.r_school = r_school;
        this.r_major = r_major;
        this.r_phone = r_phone;
        this.r_workingYears = r_workingYears;
        this.r_workExperience = r_workExperience;
        this.r_introduce = r_introduce;
    }

    public Resumes(String r_name, int r_age, String r_sex, String r_school, String r_major, int r_phone, String r_workingYears, String r_workExperience, String r_introduce) {
        this.r_name = r_name;
        this.r_age = r_age;
        this.r_sex = r_sex;
        this.r_school = r_school;
        this.r_major = r_major;
        this.r_phone = r_phone;
        this.r_workingYears = r_workingYears;
        this.r_workExperience = r_workExperience;
        this.r_introduce = r_introduce;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public User getR_user() {
        return r_user;
    }

    public void setR_user(User r_user) {
        this.r_user = r_user;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public int getR_age() {
        return r_age;
    }

    public void setR_age(int r_age) {
        this.r_age = r_age;
    }

    public String getR_sex() {
        return r_sex;
    }

    public void setR_sex(String r_sex) {
        this.r_sex = r_sex;
    }

    public String getR_school() {
        return r_school;
    }

    public void setR_school(String r_school) {
        this.r_school = r_school;
    }

    public String getR_major() {
        return r_major;
    }

    public void setR_major(String r_major) {
        this.r_major = r_major;
    }

    public int getR_phone() {
        return r_phone;
    }

    public void setR_phone(int r_phone) {
        this.r_phone = r_phone;
    }

    public String getR_workingYears() {
        return r_workingYears;
    }

    public void setR_workingYears(String r_workingYears) {
        this.r_workingYears = r_workingYears;
    }

    public String getR_workExperience() {
        return r_workExperience;
    }

    public void setR_workExperience(String r_workExperience) {
        this.r_workExperience = r_workExperience;
    }

    public String getR_introduce() {
        return r_introduce;
    }

    public void setR_introduce(String r_introduce) {
        this.r_introduce = r_introduce;
    }

    public List<RecruManage> getRecruManages() {
        return recruManages;
    }

    public void setRecruManages(List<RecruManage> recruManages) {
        this.recruManages = recruManages;
    }

    @Override
    public String toString() {
        return "Resumes{" +
                "r_id=" + r_id +
                ", r_name='" + r_name + '\'' +
                ", r_age=" + r_age +
                ", r_sex='" + r_sex + '\'' +
                ", r_school='" + r_school + '\'' +
                ", r_major='" + r_major + '\'' +
                ", r_phone=" + r_phone +
                ", r_workingYears='" + r_workingYears + '\'' +
                ", r_workExperience='" + r_workExperience + '\'' +
                ", r_introduce='" + r_introduce + '\'' +
                '}';
    }
}
