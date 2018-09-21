package life.eks.xmall.service.goods;

import com.alibaba.dubbo.config.annotation.Service;
import life.eks.xmall.api.goods.BrandService;
import life.eks.xmall.dao.BrandMapper;
import life.eks.xmall.pojo.Brand;

import javax.annotation.Resource;
import java.util.List;

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
    public List<Brand> listBrand() {
        return brandMapper.selectByExample(null);
    }
}
