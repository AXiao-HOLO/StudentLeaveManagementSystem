package com.student.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 课表主表
 * @TableName timetable
 */
@TableName(value ="timetable")
@Data
public class Timetable {
    /**
     * 课表ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 班级ID
     */
    private Long classId;

    /**
     * 课程ID
     */
    private Long courseId;

    /**
     * 星期几：1-周一，2-周二，…7-周日
     */
    private Integer weekDay;

    /**
     * 节次：1-第一二节，2-第三四节，…
     */
    private Integer classPeriod;

    /**
     * 上课周次（如：1-18周，3,5,7周）
     */
    private String weekRange;

    /**
     * 上课教室
     */
    private String classroom;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

     /**
     * 课程名称
     */
    @TableField(exist = false)
    private String courseName;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Timetable other = (Timetable) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getClassId() == null ? other.getClassId() == null : this.getClassId().equals(other.getClassId()))
            && (this.getCourseId() == null ? other.getCourseId() == null : this.getCourseId().equals(other.getCourseId()))
            && (this.getWeekDay() == null ? other.getWeekDay() == null : this.getWeekDay().equals(other.getWeekDay()))
            && (this.getClassPeriod() == null ? other.getClassPeriod() == null : this.getClassPeriod().equals(other.getClassPeriod()))
            && (this.getWeekRange() == null ? other.getWeekRange() == null : this.getWeekRange().equals(other.getWeekRange()))
            && (this.getClassroom() == null ? other.getClassroom() == null : this.getClassroom().equals(other.getClassroom()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getClassId() == null) ? 0 : getClassId().hashCode());
        result = prime * result + ((getCourseId() == null) ? 0 : getCourseId().hashCode());
        result = prime * result + ((getWeekDay() == null) ? 0 : getWeekDay().hashCode());
        result = prime * result + ((getClassPeriod() == null) ? 0 : getClassPeriod().hashCode());
        result = prime * result + ((getWeekRange() == null) ? 0 : getWeekRange().hashCode());
        result = prime * result + ((getClassroom() == null) ? 0 : getClassroom().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", classId=").append(classId);
        sb.append(", courseId=").append(courseId);
        sb.append(", weekDay=").append(weekDay);
        sb.append(", classPeriod=").append(classPeriod);
        sb.append(", weekRange=").append(weekRange);
        sb.append(", classroom=").append(classroom);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}