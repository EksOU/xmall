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
     * @param brand 查询条件对象
     * @param pageNum  页码
     * @param pageSize 每页条数
     * @return 商品品牌列表
     */
    PageSerializable<Brand> listBrand(Brand brand, int pageNum, int pageSize);

    /**
     * 商品品牌保存
     *
     * @param brand 要保存的品牌
     */
    void save(Brand brand);

    /**
     * 更新品牌
     * @param brand 要更新的品牌
     */
    void update(Brand brand);

    /**
     * 根据id获取品牌
     */
    Brand findById(Long id);

    /**
     * 品牌删除
     */
    void delete(Long[] ids);

}
