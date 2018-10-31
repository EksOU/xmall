package life.eks.xmall.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import life.eks.xmall.api.goods.ItemService;
import life.eks.xmall.pojo.ItemCategory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Eks OU
 */
@RestController
@RequestMapping("/item")
public class ItemController {

    @Reference(version = "1.0.0")
    private ItemService itemService;

    @GetMapping("/listCategory")
    public List<ItemCategory> listCategory(Long parentId) {
        return itemService.listCategory(parentId);
    }
}
