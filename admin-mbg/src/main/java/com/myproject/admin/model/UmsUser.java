package com.myproject.admin.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class UmsUser implements Serializable {
    private Long id;

    @ApiModelProperty(value = "账号")
    private String userName;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "用户真实名字")
    private String realName;

    @ApiModelProperty(value = "手机号码")
    private String number;

    @ApiModelProperty(value = "头像")
    private String icon;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "出生日期")
    private Integer birthDate;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "学校")
    private String school;

    @ApiModelProperty(value = "年级")
    private String grade;

    @ApiModelProperty(value = "身份证号码")
    private String idNumber;

    @ApiModelProperty(value = "母亲信息")
    private String montherInfo;

    @ApiModelProperty(value = "父亲信息")
    private String fatherInfo;

    @ApiModelProperty(value = "注册日期")
    private Date registerTime;

    @ApiModelProperty(value = "状态: 0->禁用 1->正常")
    private Byte status;

    @ApiModelProperty(value = "所属学校id")
    private Long schoolId;

    @ApiModelProperty(value = "所属年级id")
    private Long gradeId;

    @ApiModelProperty(value = "所属班级id")
    private Long classId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Integer birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getMontherInfo() {
        return montherInfo;
    }

    public void setMontherInfo(String montherInfo) {
        this.montherInfo = montherInfo;
    }

    public String getFatherInfo() {
        return fatherInfo;
    }

    public void setFatherInfo(String fatherInfo) {
        this.fatherInfo = fatherInfo;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", nickName=").append(nickName);
        sb.append(", password=").append(password);
        sb.append(", realName=").append(realName);
        sb.append(", number=").append(number);
        sb.append(", icon=").append(icon);
        sb.append(", sex=").append(sex);
        sb.append(", birthDate=").append(birthDate);
        sb.append(", address=").append(address);
        sb.append(", school=").append(school);
        sb.append(", grade=").append(grade);
        sb.append(", idNumber=").append(idNumber);
        sb.append(", montherInfo=").append(montherInfo);
        sb.append(", fatherInfo=").append(fatherInfo);
        sb.append(", registerTime=").append(registerTime);
        sb.append(", status=").append(status);
        sb.append(", schoolId=").append(schoolId);
        sb.append(", gradeId=").append(gradeId);
        sb.append(", classId=").append(classId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}