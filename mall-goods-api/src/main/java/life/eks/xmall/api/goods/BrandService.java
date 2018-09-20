package life.eks.xmall.api.goods;

import life.eks.xmall.pojo.Brand;

import java.util.List;

/**
 * 商品品牌服务接口
 *
 * @author Eks OU
 */
public interface BrandService {

    /**
     * 获取商品品牌列表
     *
     * @return 商品品牌列表
     */
    List<Brand> listBrand();
}
