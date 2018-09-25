package life.eks.xmall.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageSerializable;
import life.eks.xmall.api.goods.SkuService;
import life.eks.xmall.common.web.Response;
import life.eks.xmall.pojo.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Eks OU
 */
@RestController
@RequestMapping("/sku")
public class SkuController {

    @Reference(version = "1.0.0")
    private SkuService service;

    @PostMapping("/list")
    public PageSerializable<Specification> list(@RequestParam(defaultValue = "1") int pageNum,
                                                @RequestParam(defaultValue = "10") int pageSize,
                                                @RequestBody Specification sku) {
        return service.list(sku, pageNum, pageSize);
    }

    @PostMapping("/save")
    public Response save(@RequestBody Specification sku) {
        try {
            service.save(sku);
        } catch (Exception e) {
            return Response.fail();
        }
        return Response.success();
    }

    @PostMapping("/update")
    public Response update(@RequestBody Specification sku) {
        try {
            service.update(sku);
        } catch (Exception e) {
            return Response.fail();
        }
        return Response.success();
    }

    @GetMapping("/findById")
    public Specification findById(Long id) {
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
