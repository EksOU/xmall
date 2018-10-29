package life.eks.xmall.api.seller;

import life.eks.xmall.api.BaseService;
import life.eks.xmall.pojo.Seller;

/**
 * @author Eks OU
 */
public interface SellerService extends BaseService<Seller, String> {


    /**
     * 更改商家状态
     *
     * @param id     商家ids
     * @param status 要设置成的商家状态
     */
    void updateStatus(String id, String status);
}
