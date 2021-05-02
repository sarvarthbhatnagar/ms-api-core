package com.ms.api.root.msapicore.tableinfo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TableInfo {

    @Id
    private String tableId;
    private String colName;
    private String colType;

    protected TableInfo() {

    }

    public TableInfo(String tableId, String colName, String colType) {
        this.tableId = tableId;
        this.colName = colName;
        this.colType = colType;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getColType() {
        return colType;
    }

    public void setColType(String colType) {
        this.colType = colType;
    }
}
