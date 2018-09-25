package life.eks.xmall.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author Eks OU
 */
public class Specification implements Serializable {
    private Long id;

    private String specName;

    private List<SpecificationOption> optionList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }

    public List<SpecificationOption> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<SpecificationOption> optionList) {
        this.optionList = optionList;
    }
}