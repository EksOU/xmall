package life.eks.xmall.controller.seller;

import com.alibaba.dubbo.config.annotation.Reference;
import life.eks.xmall.api.seller.SellerService;
import life.eks.xmall.common.web.Response;
import life.eks.xmall.pojo.Seller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eks OU
 */
@RestController
@RequestMapping("/seller")
public class SellerController {

    @Reference(version = "1.0.0")
    private SellerService sellerService;

    @PostMapping("/register")
    public Response register(@RequestBody Seller seller) {
        try {
            sellerService.save(seller);
            return Response.success();
        } catch (Exception e) {
            return Response.fail();
        }
    }
}
