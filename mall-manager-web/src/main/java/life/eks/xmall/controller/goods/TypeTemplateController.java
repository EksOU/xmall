package life.eks.xmall.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageSerializable;
import life.eks.xmall.api.goods.TypeTemplateService;
import life.eks.xmall.common.web.Response;
import life.eks.xmall.pojo.TypeTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {

    @Reference(version = "1.0.0")
    private TypeTemplateService service;

    @PostMapping("/list")
    public PageSerializable<TypeTemplate> list(@RequestParam(defaultValue = "1") int pageNum,
                                               @RequestParam(defaultValue = "10") int pageSize,
                                               @RequestBody TypeTemplate typeTemplate) {
        return service.list(typeTemplate, pageNum, pageSize);
    }

    @PostMapping("/save")
    public Response save(@RequestBody TypeTemplate typeTemplate) {
        try {
            service.save(typeTemplate);
        } catch (Exception e) {
            return Response.fail();
        }
        return Response.success();
    }

    @PostMapping("/update")
    public Response update(@RequestBody TypeTemplate typeTemplate) {
        try {
            service.update(typeTemplate);
        } catch (Exception e) {
            return Response.fail();
        }
        return Response.success();
    }

    @GetMapping("/findById")
    public TypeTemplate findById(Long id) {
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
