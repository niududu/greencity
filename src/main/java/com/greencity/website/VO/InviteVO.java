package com.greencity.website.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @Description:
 * @Author: LiuZW
 * @CreateDate: 2020/4/25 23:14
 * @Version: 1.0
 */
@Data
public class InviteVO {

    private Integer id;

    private String name;

    private Integer number;

    private String requirement;
    @JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    private String time;

}
