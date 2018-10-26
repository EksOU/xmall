package life.eks.xmall.api.goods;

import life.eks.xmall.pojo.Specification;

import java.util.List;
import java.util.Map;

/**
 * @author Eks OU
 */
public interface SkuService extends BaseService<Specification> {

    /**
     * 获取下拉属性列表
     *
     * @return 下拉属性列表
     */
    List<Map<String, Object>> listOptions();
}
