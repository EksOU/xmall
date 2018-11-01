package life.eks.xmall.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import life.eks.xmall.api.goods.GoodsService;
import life.eks.xmall.common.web.Response;
import life.eks.xmall.pojo.Goods;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Eks OU
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Reference(version = "1.0.0")
    private GoodsService goodsService;

    @PostMapping("/save")
    public Response save(@RequestBody Goods goods) {
        try {
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            goods.setSellerId(name);
            goodsService.save(goods);
            return Response.success();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.fail();
        }
    }
}
