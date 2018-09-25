package life.eks.xmall.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageSerializable;
import life.eks.xmall.api.goods.BrandService;
import life.eks.xmall.common.web.Response;
import life.eks.xmall.pojo.Brand;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/list")
    public PageSerializable<Brand> list(@RequestParam(defaultValue = "1") int pageNum,
                                        @RequestParam(defaultValue = "10") int pageSize,
                                        @RequestBody Brand brand) {
        return service.list(brand, pageNum, pageSize);
    }

    @PostMapping("/save")
    public Response save(@RequestBody Brand brand) {
        try {
            service.save(brand);
        } catch (Exception e) {
            return Response.fail();
        }
        return Response.success();
    }

    @PostMapping("/update")
    public Response update(@RequestBody Brand brand) {
        try {
            service.update(brand);
        } catch (Exception e) {
            return Response.fail();
        }
        return Response.success();
    }

    @GetMapping("/findById")
    public Brand findById(Long id) {
        return service.findById(id);
    }

    @PostMapping("/delete")
    public Response delete(@RequestBody Long[] ids) {
        try {
            service.delete(ids);
        } catch (Exception e) {
            return Response.fail();
        }
        return Response.success();
    }
}
