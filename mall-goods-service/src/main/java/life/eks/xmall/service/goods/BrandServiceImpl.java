package life.eks.xmall.service.goods;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import life.eks.xmall.api.goods.BrandService;
import life.eks.xmall.dao.BrandMapper;
import life.eks.xmall.pojo.Brand;
import life.eks.xmall.pojo.BrandExample;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 品牌业务
 *
 * @author Eks OU
 */
@Service(version = "1.0.0")
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;

    @Override
    public PageSerializable<Brand> list(Brand brand, int pageNum, int pageSize) {
        BrandExample example = new BrandExample();
        if (Objects.nonNull(brand)) {
            BrandExample.Criteria criteria = example.createCriteria();
            if (!StringUtils.isEmpty(brand.getName())) {
                criteria.andNameLike("%" + brand.getName() + "%");
            }
            if (!StringUtils.isEmpty(brand.getFirstChar())) {
                criteria.andFirstCharLike("%" + brand.getFirstChar() + "%");
            }
        }
        Page<Brand> brands = PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> brandMapper.selectByExample(example));
        return brands.toPageSerializable();
    }

    @Override
    public void save(Brand brand) {
        brandMapper.insert(brand);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKey(brand);
    }

    @Override
    public Brand findById(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            brandMapper.deleteByPrimaryKey(id);
        }
    }
}

