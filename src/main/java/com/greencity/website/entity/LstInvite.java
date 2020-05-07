package com.greencity.website.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
/**
 *
 * 招聘信息表-数据库实体对象
 * @作者 LiuZW
 * @时间 2020-04-25
 */
@Data
@TableName("greencity.lst_invite")
public class LstInvite implements Serializable  {

    private static final long serialVersionUID = 1L;



    /**
     * 主键ID
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 岗位名称
     */
	private String jobName;
    /**
     * 岗位招聘数量
     */
	private Integer jobNumber;
    /**
     * 岗位详情
     */
	private String inviteDetail;
    /**
     * 岗位详情
     */
	private Date publishDate;
    /**
     * 是否删除 
     */
	private Integer isDelete;
    /**
     * 更新时间
     */
	private Date updateTime;
    /**
     * 创建时间
     */
	private Date createTime;
    /**
     * 创建人
     */
	private Integer createId;


}
