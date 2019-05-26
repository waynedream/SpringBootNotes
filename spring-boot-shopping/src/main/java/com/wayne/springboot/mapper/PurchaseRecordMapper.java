package com.wayne.springboot.mapper;

import com.wayne.springboot.pojo.PurchaseRecordPo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface PurchaseRecordMapper {

    @Insert("insert into t_purchase_record(\n" +
            "        user_id,product_id,price,quantity,sum,purchase_date,note)\n" +
            "        values(#{userId},#{productId},#{price},#{quantity},#{sum},now(),#{note})")
    int insertPurchaseRecord(PurchaseRecordPo pr);
}
