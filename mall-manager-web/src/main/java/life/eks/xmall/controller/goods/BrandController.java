package life.eks.xmall.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageSerializable;
import life.eks.xmall.api.goods.BrandService;
import life.eks.xmall.pojo.Brand;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
        return service.listBrand(brand, pageNum, pageSize);
    }

    @PostMapping("/save")
    public Map<String, Object> save(@RequestBody Brand brand) {
        Map<String, Object> result = new HashMap<>();
        try {
            service.save(brand);
            result.put("code", 200);
            result.put("message", "保存成功");
        } catch (Exception e) {
            result.put("code", 5001);
            result.put("message", "保存失败");
        }
        return result;
    }

    @PostMapping("/update")
    public Map<String, Object> update(@RequestBody Brand brand) {
        Map<String, Object> result = new HashMap<>();
        try {
            service.update(brand);
            result.put("code", 200);
            result.put("message", "更新成功");
        } catch (Exception e) {
            result.put("code", 5001);
            result.put("message", "更新失败");
        }
        return result;
    }

    @GetMapping("/findById")
    public Brand findById(Long id) {
        return service.findById(id);
    }

    @PostMapping("/delete")
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        Map<String, Object> result = new HashMap<>();
        try {
            service.delete(ids);
            result.put("code", 200);
            result.put("message", "删除成功");
        } catch (Exception e) {
            result.put("code", 5001);
            result.put("message", "删除失败");
        }
        return result;
    }
}
