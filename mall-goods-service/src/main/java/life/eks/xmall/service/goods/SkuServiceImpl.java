package life.eks.xmall.service.goods;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import life.eks.xmall.api.goods.SkuService;
import life.eks.xmall.dao.SpecificationMapper;
import life.eks.xmall.dao.SpecificationOptionMapper;
import life.eks.xmall.pojo.Specification;
import life.eks.xmall.pojo.SpecificationExample;
import life.eks.xmall.pojo.SpecificationOption;
import life.eks.xmall.pojo.SpecificationOptionExample;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author Eks OU
 */
@Service(version = "1.0.0")
public class SkuServiceImpl implements SkuService {

    @Resource
    private SpecificationMapper mapper;

    @Resource
    private SpecificationOptionMapper optionMapper;

    @Override
    public PageSerializable<Specification> list(Specification sku, int pageNum, int pageSize) {
        SpecificationExample example = new SpecificationExample();
        if (Objects.nonNull(sku)) {
            SpecificationExample.Criteria criteria = example.createCriteria();
            if (!StringUtils.isEmpty(sku.getSpecName())) {
                criteria.andSpecNameLike("%" + sku.getSpecName() + "%");
            }
        }
        Page<Specification> skuPage = PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> mapper.selectByExample(example));
        return skuPage.toPageSerializable();
    }

    @Override
    public void save(Specification sku) {
        mapper.insert(sku);

        List<SpecificationOption> specificationOptionList = sku.getOptionList();
        for (SpecificationOption option : specificationOptionList) {
            option.setSpecId(sku.getId());
            optionMapper.insert(option);
        }
    }

    @Override
    public void update(Specification sku) {
        mapper.updateByPrimaryKey(sku);

        SpecificationOptionExample example = new SpecificationOptionExample();
        SpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdEqualTo(sku.getId());
        optionMapper.deleteByExample(example);

        List<SpecificationOption> optionList = sku.getOptionList();
        for (SpecificationOption option : optionList) {
            option.setSpecId(sku.getId());
            optionMapper.insert(option);
        }
    }

    @Override
    public Specification findById(Long id) {
        Specification sku = mapper.selectByPrimaryKey(id);

        SpecificationOptionExample example = new SpecificationOptionExample();
        SpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdEqualTo(id);
        List<SpecificationOption> specificationOptionList = optionMapper.selectByExample(example);

        sku.setOptionList(specificationOptionList);
        return sku;
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            mapper.deleteByPrimaryKey(id);

            SpecificationOptionExample example = new SpecificationOptionExample();
            SpecificationOptionExample.Criteria criteria = example.createCriteria();
            criteria.andSpecIdEqualTo(id);
            optionMapper.deleteByExample(example);
        }
    }
}
