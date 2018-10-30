package life.eks.xmall.dto;

/**
 * @author Eks OU
 */
public class SellerDto {
    /**
     * 未审核
     */
    public static final String STATUS_INIT = "0";
    /**
     * 审核通过
     */
    public static final String STATUS_PAST = "1";
    /**
     * 审核不通过
     */
    public static final String STATUS_REJECTED = "2";
    /**
     * 已关店
     */
    public static final String STATUS_CLOSED = "3";
}
