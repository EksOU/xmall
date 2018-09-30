package life.eks.xmall.service.goods;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import life.eks.xmall.api.goods.TypeTemplateService;
import life.eks.xmall.dao.TypeTemplateMapper;
import life.eks.xmall.pojo.TypeTemplate;
import life.eks.xmall.pojo.TypeTemplateExample;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author Eks OU
 */
@Service(version = "1.0.0")
public class TypeTemplateServiceImpl implements TypeTemplateService {

    @Resource
    private TypeTemplateMapper typeTemplateMapper;

    @Override
    public PageSerializable<TypeTemplate> list(TypeTemplate typeTemplate, int pageNum, int pageSize) {
        TypeTemplateExample example = new TypeTemplateExample();
        if (Objects.nonNull(typeTemplate)) {
            TypeTemplateExample.Criteria criteria = example.createCriteria();
            if (!StringUtils.isEmpty(typeTemplate.getName())) {
                criteria.andNameLike("%" + typeTemplate.getName() + "%");
            }
        }
        Page<TypeTemplate> typeTemplates = PageHelper.startPage(pageNum, pageSize).doSelectPage(() -> typeTemplateMapper.selectByExample(example));
        return typeTemplates.toPageSerializable();
    }

    @Override
    public void save(TypeTemplate typeTemplate) {
        typeTemplateMapper.insert(typeTemplate);
    }

    @Override
    public void update(TypeTemplate typeTemplate) {
        typeTemplateMapper.updateByPrimaryKey(typeTemplate);
    }

    @Override
    public TypeTemplate findById(Long id) {
        return typeTemplateMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            typeTemplateMapper.deleteByPrimaryKey(id);
        }
    }
}
