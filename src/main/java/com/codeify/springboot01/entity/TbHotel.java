package com.codeify.springboot01.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * tb_hotel
 * @author 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(schema = "codeify", name = "tb_hotel")
public class TbHotel implements Serializable {
    /**
     * 酒店id
     */
    private Long id;

    /**
     * 酒店名称；例：7天酒店
     */
    private String name;

    /**
     * 酒店地址；例：航头路
     */
    private String address;

    /**
     * 酒店价格;例：329
     */
    private Integer price;

    /**
     * 酒店品牌；例：如家
     */
    private String brand;

    /**
     * 所在城市;例：上海
     */
    private String city;

    /**
     * 酒店星级，从低到高分
别是：1星到5星，1钻到5钻
     */
    private String starName;

    /**
     * 商園；例：虹桥
     */
    private String business;

    /**
     * 纬度;例：31.2497
     */
    private String latitude;

    /**
     * 经度；例：120.3925°
     */
    private String longitude;

    /**
     * 酒店图片；例：/img/1.jpg
     */
    private String pic;

    private static final long serialVersionUID = 1L;
}