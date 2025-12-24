package net.dpwl;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/23 13:46
 */
public class User {
    private Integer id;
    private String openid;
    private String nickname;
    private Integer sex;
    private String headimg;
    private String name;
    private String tel;
    private String adr;
    private Integer logintime;
    private Integer yz;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public Integer getLogintime() {
        return logintime;
    }

    public void setLogintime(Integer logintime) {
        this.logintime = logintime;
    }

    public Integer getYz() {
        return yz;
    }

    public void setYz(Integer yz) {
        this.yz = yz;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", headimg='" + headimg + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", adr='" + adr + '\'' +
                ", logintime=" + logintime +
                ", yz=" + yz +
                '}';
    }
}
