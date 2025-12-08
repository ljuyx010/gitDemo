import java.io.Serializable;

/**
 * @author 混江龙
 * @version 1.0
 * @time 2025/12/8 11:56
 */
public class Common implements Serializable {
    private static final long serialVersionUID = 1L; // 为了类在tcp中传输的兼容性
    private int lid;
    private int cid;
    private int uid;
    private String title;
    private String info;
    private String date;
    private int time_stamp;
    private int leixing;

    public Common() {
    }
    public Common(int lid, int cid, int uid, String title, String info, String date, int time_stamp, int leixing) {
        this.lid = lid;
        this.cid = cid;
        this.uid = uid;
        this.title = title;
        this.info = info;
        this.date = date;
        this.time_stamp = time_stamp;
        this.leixing = leixing;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(int time_stamp) {
        this.time_stamp = time_stamp;
    }

    public int getLeixing() {
        return leixing;
    }

    public void setLeixing(int leixing) {
        this.leixing = leixing;
    }

    @Override
    public String toString() {
        return "\nCommon{" +
                "lid=" + lid +
                ", cid=" + cid +
                ", uid=" + uid +
                ", title='" + title + '\'' +
                ", info='" + info + '\'' +
                ", date='" + date + '\'' +
                ", time_stamp=" + time_stamp +
                ", leixing=" + leixing +
                '}';
    }
}
