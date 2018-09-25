package life.eks.xmall.api.goods;

import com.github.pagehelper.PageSerializable;

import java.io.Serializable;

/**
 * 增删改查通用接口
 *
 * @author Eks OU
 */
public interface BaseService<T extends Serializable> {

    /**
     * 获取列表
     *
     * @param goods    查询条件对象
     * @param pageNum  页码
     * @param pageSize 每页条数
     * @return 列表
     */
    PageSerializable<T> list(T goods, int pageNum, int pageSize);

    /**
     * 保存
     *
     * @param goods 要保存的对象
     */
    void save(T goods);

    /**
     * 更新
     *
     * @param goods 要更新的对象
     */
    void update(T goods);

    /**
     * 根据id获取对象
     *
     * @param id 对象id
     * @return 对象
     */
    T findById(Long id);

    /**
     * 对象删除
     *
     * @param ids 要删除的多少对象id列表
     */
    void delete(Long[] ids);

}
