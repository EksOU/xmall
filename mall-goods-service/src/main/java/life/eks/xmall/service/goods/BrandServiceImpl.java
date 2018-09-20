package life.eks.xmall.service.goods;

import com.alibaba.dubbo.config.annotation.Service;
import life.eks.xmall.api.goods.BrandService;
import life.eks.xmall.dao.BrandMapper;
import life.eks.xmall.pojo.Brand;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 品牌业务
 *
 * @author Eks OU
 */
@Service(version = "1.0.0")
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper mapper;

    @Override
    public List<Brand> listBrand() {
        ArrayList<Brand> brands = new ArrayList<>();
        brands.add(mapper.selectByPrimaryKey(1L));
        return brands;
    }
}
