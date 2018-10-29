package life.eks.xmall.service.seller;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageSerializable;
import life.eks.xmall.api.seller.SellerService;
import life.eks.xmall.dao.SellerMapper;
import life.eks.xmall.pojo.Seller;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Eks OU
 */
@Service(version = "1.0.0")
public class SellerServiceImpl implements SellerService {

    @Resource
    private SellerMapper sellerMapper;

    @Override
    public PageSerializable<Seller> list(Seller target, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public void save(Seller target) {
        target.setCreateTime(new Date());
        sellerMapper.insert(target);
    }

    @Override
    public void update(Seller target) {
        sellerMapper.updateByPrimaryKey(target);
    }

    @Override
    public Seller findById(String id) {
        return sellerMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(String[] ids) {
        for (String id : ids) {
            sellerMapper.deleteByPrimaryKey(id);
        }
    }
}
