package life.eks.xmall.dao;

import life.eks.xmall.pojo.SpecificationOption;

public interface SpecificationOptionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SpecificationOption record);

    int insertSelective(SpecificationOption record);

    SpecificationOption selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SpecificationOption record);

    int updateByPrimaryKey(SpecificationOption record);
}