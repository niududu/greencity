package com.greencity.website.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
/**
 *
 * 账号信息表-数据库实体对象
 * @作者 LiuZW
 * @时间 2020-04-25
 */
@Data
@TableName("greencity.ifo_user")
public class IfoUser implements Serializable  {

    private static final long serialVersionUID = 1L;



    /**
     * 用户ID
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 用户名称
     */
	private String name;
    /**
     * 用户账号
     */
	private String account;
    /**
     * 用户密码 
     */
	private String password;
    /**
     * 用户状态【0.启用 1.禁用】
     */
	private Integer userStatus;
    /**
     * 手机号
     */
	private String mobile;
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
