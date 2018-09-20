package life.eks.xmall.dao;

import life.eks.xmall.pojo.ItemCategory;

public interface ItemCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItemCategory record);

    int insertSelective(ItemCategory record);

    ItemCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItemCategory record);

    int updateByPrimaryKey(ItemCategory record);
}