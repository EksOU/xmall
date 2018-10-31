package life.eks.xmall.service.goods;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageSerializable;
import life.eks.xmall.api.goods.ItemService;
import life.eks.xmall.dao.ItemCategoryMapper;
import life.eks.xmall.dao.ItemMapper;
import life.eks.xmall.pojo.Item;
import life.eks.xmall.pojo.ItemCategory;
import life.eks.xmall.pojo.ItemCategoryExample;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Eks OU
 */
@Service(version = "1.0.0")
public class ItemServiceImpl implements ItemService {

    @Resource
    private ItemCategoryMapper categoryMapper;
    @Resource
    private ItemMapper itemMapper;

    @Override
    public List<ItemCategory> listCategory(Long parentId) {
        ItemCategoryExample example = new ItemCategoryExample();
        ItemCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        return categoryMapper.selectByExample(example);
    }

    @Override
    public PageSerializable<Item> list(Item target, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public void save(Item target) {

    }

    @Override
    public void update(Item target) {

    }

    @Override
    public Item findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long[] ids) {

    }
}
