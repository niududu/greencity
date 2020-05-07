package com.greencity.website.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @Description:
 * @Author: LiuZW
 * @CreateDate: 2020/4/25 23:53
 * @Version: 1.0
 */
@Data
public class NewsVO {

    private Integer id;

    private String name;

    private String brief;

    private String author;

    private String content;

    private String imgSrc;
    @JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    private String date;



}
