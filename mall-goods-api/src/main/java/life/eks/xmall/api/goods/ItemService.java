package life.eks.xmall.api.goods;

import life.eks.xmall.api.BaseService;
import life.eks.xmall.pojo.Item;
import life.eks.xmall.pojo.ItemCategory;

import java.util.List;

/**
 * @author Eks OU
 */
public interface ItemService extends BaseService<Item, Long> {

    /**
     * 获取商品分类列表
     *
     * @param parentId 父级id
     * @return 商品分类列表
     */
    List<ItemCategory> listCategory(Long parentId);
}
