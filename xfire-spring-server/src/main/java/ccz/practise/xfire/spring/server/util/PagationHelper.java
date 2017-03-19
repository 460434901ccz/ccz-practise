package ccz.practise.xfire.spring.server.util;

/**
 * ��ҳ����
 * Created by �̴��� on 2016/7/27.
 *
 */
public class PagationHelper {
    private Integer pageIndex;
    private Integer pageSize;
    private Integer totalCount;

    public PagationHelper() {
    }

    public PagationHelper(final Integer pageIndex, final Integer pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }
}
