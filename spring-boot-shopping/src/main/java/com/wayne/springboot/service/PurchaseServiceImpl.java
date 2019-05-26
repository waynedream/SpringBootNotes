package com.wayne.springboot.service;


import com.wayne.springboot.mapper.ProductMapper;
import com.wayne.springboot.mapper.PurchaseRecordMapper;
import com.wayne.springboot.pojo.ProductPo;
import com.wayne.springboot.pojo.PurchaseRecordPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaseServiceImpl implements PurchaseService {


    @Autowired
    private ProductMapper productMapper = null;

    @Autowired
    private PurchaseRecordMapper purchaseRecordMapper = null;

     @Override
     // 启动Spring数据库事务机制
     @Transactional
     public boolean purchase(Long userId, Long productId, int quantity) {
         // 获取产品
         ProductPo product = productMapper.getProduct(productId);
         // 比较库存和购买数量
         if (product.getStock() < quantity) {
         // 库存不足
         return false;
         }
         // 扣减库存
         productMapper.decreaseProduct(productId, quantity);
         // 初始化购买记录
         PurchaseRecordPo pr = this.initPurchaseRecord(userId, product, quantity);
         // 插入购买记录
         purchaseRecordMapper.insertPurchaseRecord(pr);
         return true;
     }

    private PurchaseRecordPo initPurchaseRecord(Long userId, ProductPo product, int quantity) {
        PurchaseRecordPo pr = new PurchaseRecordPo();
        pr.setNote("购买日志，时间：" + System.currentTimeMillis());
        pr.setPrice(product.getPrice());
        pr.setProductId(product.getId());
        pr.setQuantity(quantity);
        double sum = product.getPrice() * quantity;
        pr.setSum(sum);
        pr.setUserId(userId);
        return pr;
    }
}
