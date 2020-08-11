package com.greencity.website.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
/**
 *
 * 反馈意见表-数据库实体对象
 * @作者 LiuZW
 * @时间 2020-05-08
 */
@Data
@TableName("greencity.lst_advice")
public class LstAdvice implements Serializable  {

    private static final long serialVersionUID = 1L;



    /**
     * 主键ID
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 客户名称
     */
	private String name;
    /**
     * 客户手机
     */
	private String mobile;
    /**
     * 邮箱
     */
	private String email;
    /**
     * 反馈意见
     */
	private String detail;
    /**
     * 是否删除 
     */
	private Integer isDelete;
    /**
     * 更新时间
     */
	private LocalDateTime updateTime;
    /**
     * 创建时间
     */
	private LocalDateTime createTime;
    /**
     * 创建人
     */
	private Integer createId;


}
