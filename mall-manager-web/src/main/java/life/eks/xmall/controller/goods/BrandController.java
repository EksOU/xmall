package life.eks.xmall.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import life.eks.xmall.api.goods.BrandService;
import life.eks.xmall.pojo.Brand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 品牌请求
 *
 * @author Eks OU
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference(version = "1.0.0")
    private BrandService service;

    @RequestMapping("/list")
    public List<Brand> listBrand() {
        return service.listBrand();
    }
}
