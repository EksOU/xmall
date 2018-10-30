package life.eks.xmall.controller.seller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageSerializable;
import life.eks.xmall.api.seller.SellerService;
import life.eks.xmall.common.web.Response;
import life.eks.xmall.pojo.Seller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Eks OU
 */
@RestController
@RequestMapping("/seller")
public class SellerController {

    @Reference(version = "1.0.0")
    private SellerService sellerService;

    @PostMapping("/list")
    public PageSerializable<Seller> list(@RequestParam(defaultValue = "1") int pageNum,
                                         @RequestParam(defaultValue = "10") int pageSize,
                                         @RequestBody Seller seller) {
        return sellerService.list(seller, pageNum, pageSize);
    }

    @GetMapping("findById")
    public Seller findById(String id) {
        return sellerService.findById(id);
    }

    @PostMapping("/updateStatus")
    public Response updateStatus(String id, String status) {
        try {
            sellerService.updateStatus(id, status);
            return Response.success();
        } catch (Exception e) {
            return Response.fail();
        }
    }
}
