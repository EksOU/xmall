package life.eks.xmall.dao;

import life.eks.xmall.pojo.GoodsDesc;

public interface GoodsDescMapper {
    int deleteByPrimaryKey(Long goodsId);

    int insert(GoodsDesc record);

    int insertSelective(GoodsDesc record);

    GoodsDesc selectByPrimaryKey(Long goodsId);

    int updateByPrimaryKeySelective(GoodsDesc record);

    int updateByPrimaryKey(GoodsDesc record);
}