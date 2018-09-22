package life.eks.xmall.service.goods;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import life.eks.xmall.api.goods.BrandService;
import life.eks.xmall.dao.BrandMapper;
import life.eks.xmall.pojo.Brand;

import javax.annotation.Resource;

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
    public PageSerializable<Brand> listBrand(int pageNum, int pageSize) {
        Page<Brand> brands = PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> brandMapper.selectByExample(null));
        return brands.toPageSerializable();
    }
}

