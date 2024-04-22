package com.codeify.springboot01.elasticsearch;

import cn.hutool.core.io.IoUtil;
import com.alibaba.fastjson.JSON;
import com.codeify.springboot01.config.MyConfiguration;
import com.codeify.springboot01.entity.TbHotel;
import com.codeify.springboot01.mapper.TbHotelDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author codeify
 * @since 2023/09/04 23:00
 */

public class MyTest {
    public static void main(String[] args) throws FileNotFoundException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        TbHotelDao tbHotelDao = context.getBean(TbHotelDao.class);

//        insertDataToTableOfMysql(tbHotelDao);
//        List<TbHotel> tbHotels = tbHotelDao.selectAll();
//        System.out.println("tbHotels.size() = " + tbHotels.size());


    }

    private static void insertDataToTableOfMysql(TbHotelDao tbHotelDao) throws FileNotFoundException {
        String json = IoUtil.read(new FileInputStream("/Users/sunhanbing/IdeaProjects/study-springboot01/src/main/java/com/codeify/springboot01/elasticsearch/Demo.json").getChannel(),
                StandardCharsets.UTF_8);
        List<HotelDto> hotelDtos = JSON.parseArray(json, HotelDto.class);
        for (HotelDto hotelDto : hotelDtos) {
            HotelDto.BaseDTO base = hotelDto.getBase();
            HotelDto.PositionDTO position = hotelDto.getPosition();
            TbHotel tbHotel = TbHotel.builder()
                    .id((long) hotelDto.getBase().getHotelId())
                    .name(hotelDto.getBase().getHotelName())
                    .address(position.getAddress())
                    .brand("酒店")
                    .latitude(position.getLat())
                    .longitude(position.getLng())
                    .city(position.getCityName())
                    .business(position.getArea())
                    .pic(hotelDto.getPicture().getDefaultUrl())
                    .price(22)
                    .starName(base.getStar() + "星")
                    .build();
            tbHotelDao.insert(tbHotel);
        }
    }


}
