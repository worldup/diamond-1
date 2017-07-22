package com.opc.freshness.service.integration.impl;

import com.opc.freshness.service.integration.ProductService;
import com.wormpex.biz.BizException;
import com.wormpex.cvs.product.api.bean.BeeProduct;
import com.wormpex.cvs.product.api.bean.BeeProductDetail;
import com.wormpex.cvs.product.api.bean.BeeShopProduct;
import com.wormpex.cvs.product.api.remote.ProductRemote;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * AUTHOR: qishang DATE: 2017/7/12.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductRemote productRemote;

    @Override
    public Map<Integer, BeeProduct> queryProductMap(Integer shopId, Set<Integer> skuIds) {
        List<BeeProduct> list = productRemote.queryProductList(shopId, skuIds);
        return list.stream().collect(
                Collectors.toMap(BeeProduct::getId, beeProduct -> beeProduct, (key1, key2) -> key1, HashMap::new));
    }

    @Override
    public BeeProductDetail queryProductDetail(int productId) {
        return productRemote.queryProductDetail(productId);
    }

    @Override
    public Map<Integer, BeeShopProduct> queryShopProductMap(Integer shopId, Set<Integer> skuIds) {
        List<BeeShopProduct> list = productRemote.queryShopProductList(shopId, skuIds);
        return list.stream().collect(Collectors.toMap(BeeShopProduct::getProductId, beeShopProduct -> beeShopProduct,
                (key1, key2) -> key1, HashMap::new));
    }

    @Override
    public BeeProductDetail queryProductDetailByBarcode(String barcode) {
        try {
            return productRemote.queryProductDetailByBarcode(barcode);
        } catch (RuntimeException e) {
            throw new BizException("未查找到产品");
        }
    }

}
