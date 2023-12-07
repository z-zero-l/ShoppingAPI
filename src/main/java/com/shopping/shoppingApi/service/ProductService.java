package com.shopping.shoppingApi.service;

import com.mybatisflex.core.service.IService;
import com.shopping.shoppingApi.entity.Product;
import com.shopping.shoppingApi.vo.ProductVO;

/**
 * 商品表 服务层。
 *
 * @author wg233
 * @since 2023-12-04
 */
public interface ProductService extends IService<Product> {
    ProductVO getProductDetail(Integer productId);
}