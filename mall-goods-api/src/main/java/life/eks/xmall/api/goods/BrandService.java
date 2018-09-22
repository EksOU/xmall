package life.eks.xmall.api.goods;

import com.github.pagehelper.PageSerializable;
import life.eks.xmall.pojo.Brand;

/**
 * 商品品牌服务接口
 *
 * @author Eks OU
 */
public interface BrandService {

    /**
     * 获取商品品牌列表
     *
     * @param pageNum 页码
     * @param pageSize 每页条数
     * @return 商品品牌列表
     */
    PageSerializable<Brand> listBrand(int pageNum, int pageSize);
}
