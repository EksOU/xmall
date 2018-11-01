package life.eks.xmall.service.goods;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageSerializable;
import life.eks.xmall.api.goods.GoodsService;
import life.eks.xmall.dao.GoodsDescMapper;
import life.eks.xmall.dao.GoodsMapper;
import life.eks.xmall.pojo.Goods;
import life.eks.xmall.pojo.GoodsDesc;

import javax.annotation.Resource;

/**
 * @author Eks OU
 */
@Service(version = "1.0.0")
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private GoodsDescMapper goodsDescMapper;

    @Override
    public PageSerializable<Goods> list(Goods target, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public void save(Goods target) {
        target.setAuditStatus("0");
        goodsMapper.insert(target);

        GoodsDesc desc = target.getDesc();
        desc.setGoodsId(target.getId());
        goodsDescMapper.insert(desc);
    }

    @Override
    public void update(Goods target) {

    }

    @Override
    public Goods findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long[] ids) {

    }
}
