package com.wayne.springboot.mapper;


import com.wayne.springboot.pojo.ProductPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ProductMapper {

    @Select("SELECT id, product_name as productName, stock, price, version, note FROM t_product where id=#{id}")
    ProductPo getProduct(Long id);

    @Update("UPDATE t_product SET stock = stock - #{quantity} WHERE id = #{id}")
    int decreaseProduct(@Param("id") Long id, @Param("quantity") int quantity);
}
