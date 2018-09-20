package life.eks.xmall.dao;

import life.eks.xmall.pojo.Specification;

public interface SpecificationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Specification record);

    int insertSelective(Specification record);

    Specification selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Specification record);

    int updateByPrimaryKey(Specification record);
}