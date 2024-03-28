package com.codeify.springboot01.mapper;

import com.codeify.springboot01.entity.TbHotel;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface TbHotelDao extends Mapper<TbHotel> {

}