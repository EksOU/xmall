package life.eks.xmall.dao;

import life.eks.xmall.pojo.TypeTemplate;

public interface TypeTemplateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TypeTemplate record);

    int insertSelective(TypeTemplate record);

    TypeTemplate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TypeTemplate record);

    int updateByPrimaryKey(TypeTemplate record);
}