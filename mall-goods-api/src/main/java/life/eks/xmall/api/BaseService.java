package life.eks.xmall.api;

import com.github.pagehelper.PageSerializable;

import java.io.Serializable;

/**
 * 增删改查通用接口
 *
 * @author Eks OU
 */
public interface BaseService<T extends Serializable, I> {

    /**
     * 获取列表
     *
     * @param target   查询条件对象
     * @param pageNum  页码
     * @param pageSize 每页条数
     * @return 列表
     */
    PageSerializable<T> list(T target, int pageNum, int pageSize);

    /**
     * 保存
     *
     * @param target 要保存的对象
     */
    void save(T target);

    /**
     * 更新
     *
     * @param target 要更新的对象
     */
    void update(T target);

    /**
     * 根据id获取对象
     *
     * @param id 对象id
     * @return 对象
     */
    T findById(I id);

    /**
     * 对象删除
     *
     * @param ids 要删除的多少对象id列表
     */
    void delete(I[] ids);

}
