package com.freshness.api.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by qishang on 2017/7/13. sku 数据传输对象
 */
@Getter
@Setter
public class SkuDto {
    /**
     * 商品SkuId
     */
    private Integer skuId;
    /**
     * 商品Sku名称
     */
    private String skuName;
    /**
     * 图片地址
     */
    private String imgUrl;
    /**
     * 数量
     */
    private Integer quantity;
}