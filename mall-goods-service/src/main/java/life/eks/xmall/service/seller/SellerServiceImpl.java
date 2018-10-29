package life.eks.xmall.service.seller;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import life.eks.xmall.api.seller.SellerService;
import life.eks.xmall.dao.SellerMapper;
import life.eks.xmall.pojo.Seller;
import life.eks.xmall.pojo.SellerExample;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Objects;

/**
 * @author Eks OU
 */
@Service(version = "1.0.0")
public class SellerServiceImpl implements SellerService {

    @Resource
    private SellerMapper sellerMapper;

    @Override
    public PageSerializable<Seller> list(Seller target, int pageNum, int pageSize) {
        SellerExample example = new SellerExample();
        if (Objects.nonNull(target)) {
            SellerExample.Criteria criteria = example.createCriteria();
            if (!StringUtils.isEmpty(target.getName())) {
                criteria.andNameLike("%" + target.getName() + "%");
            }
            if (!StringUtils.isEmpty(target.getNickName())) {
                criteria.andNickNameLike("%" + target.getNickName() + "%");
            }
        }
        Page<Seller> targets = PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> sellerMapper.selectByExample(example));
        return targets.toPageSerializable();
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

    @Override
    public void updateStatus(String id, String status) {
        Seller seller = sellerMapper.selectByPrimaryKey(id);
        seller.setStatus(status);
        sellerMapper.updateByPrimaryKey(seller);
    }
}
