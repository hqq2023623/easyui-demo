package zj.ui;

import java.util.List;

/**
 * Jquery easyui datagrid
 * Created by lzj on 2017/1/18.
 */
public class DataGrid {

    private int total;

    private List<Object> rows;

    public DataGrid(int total, List<Object> rows) {
        this.total = total;
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Object> getRows() {
        return rows;
    }

    public void setRows(List<Object> rows) {
        this.rows = rows;
    }
}
