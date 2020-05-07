package com.greencity.website.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: LiuZW
 * @CreateDate: 2020/4/25 20:30
 * @Version: 1.0
 */
@AllArgsConstructor
public enum CaseTypeNameEnum {

    ZERO(0, "市政"),
    ONE(1, "公园"),
    TWO(2, "学校"),
    THREE(3, "绿化"),
    FOUR(4, "保洁"),
    OTHER(5, "其它"),
    ;

    @Getter
    @Setter
    private int index;

    @Getter
    @Setter
    private String name;

    public static String getNameById(int index) {
        for (CaseTypeNameEnum item : values()) {
            if (item.getIndex() == index) {
                return item.getName();
            }
        }
        return "未知";
    }

    public static Integer getIdByName(String name) {
        for (CaseTypeNameEnum item : values()) {
            if (item.getName().equals(name)) {
                return item.getIndex();
            }
        }
        return -1;
    }

    public static Map<Integer, String> getEnumMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(ZERO.getIndex(), ZERO.getName());
        map.put(ONE.getIndex(), ONE.getName());
        map.put(TWO.getIndex(), TWO.getName());
        map.put(THREE.getIndex(), THREE.getName());
        map.put(FOUR.getIndex(), FOUR.getName());
        map.put(OTHER.getIndex(), OTHER.getName());
        return map;
    }

}
