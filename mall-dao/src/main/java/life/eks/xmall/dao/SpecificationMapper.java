package life.eks.xmall.dao;

import java.util.List;
import java.util.Map;

import life.eks.xmall.pojo.Specification;
import life.eks.xmall.pojo.SpecificationExample;
import org.apache.ibatis.annotations.Param;

public interface SpecificationMapper {
    long countByExample(SpecificationExample example);

    int deleteByExample(SpecificationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Specification record);

    int insertSelective(Specification record);

    List<Specification> selectByExample(SpecificationExample example);

    Specification selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Specification record, @Param("example") SpecificationExample example);

    int updateByExample(@Param("record") Specification record, @Param("example") SpecificationExample example);

    int updateByPrimaryKeySelective(Specification record);

    int updateByPrimaryKey(Specification record);

    List<Map<String, Object>> listOptions();
}