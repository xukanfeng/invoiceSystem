package com.cane.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by xu_kanfeng on 16/6/29.
 */
@Entity
@Table(name = "invoiceRecord", schema = "invoiceSystem", catalog = "")
public class InvoiceRecordEntity {
    private int id;
    private String shopName;
    private String wechatId;
    private Date invoiceDate;
    private String invoiceContent;
    private Integer amount;
    private Double unitPrice;
    private Double taxRate;
    private Double totalPriceWithoutTax;
    private Double taxPrice;
    private Double totalPrice;
    private String machineId;
    private Byte status;
    private String companyName;
    private String taxpayerId;
    private Integer model;
private Integer unit;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "shopName", nullable = true, length = 45)
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Basic
    @Column(name = "wechatId", nullable = true, length = 45)
    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    @Basic
    @Column(name = "invoiceDate", nullable = true)
    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @Basic
    @Column(name = "invoiceContent", nullable = true, length = 45)
    public String getInvoiceContent() {
        return invoiceContent;
    }

    public void setInvoiceContent(String invoiceContent) {
        this.invoiceContent = invoiceContent;
    }

    @Basic
    @Column(name = "amount", nullable = true)
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "unitPrice", nullable = true, precision = 0)
    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Basic
    @Column(name = "taxRate", nullable = true, precision = 0)
    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    @Basic
    @Column(name = "totalPriceWithoutTax", nullable = true, precision = 0)
    public Double getTotalPriceWithoutTax() {
        return totalPriceWithoutTax;
    }

    public void setTotalPriceWithoutTax(Double totalPriceWithoutTax) {
        this.totalPriceWithoutTax = totalPriceWithoutTax;
    }

    @Basic
    @Column(name = "taxPrice", nullable = true, precision = 0)
    public Double getTaxPrice() {
        return taxPrice;
    }

    public void setTaxPrice(Double taxPrice) {
        this.taxPrice = taxPrice;
    }

    @Basic
    @Column(name = "totalPrice", nullable = true, precision = 0)
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceRecordEntity that = (InvoiceRecordEntity) o;

        if (id != that.id) return false;
        if (shopName != null ? !shopName.equals(that.shopName) : that.shopName != null) return false;
        if (wechatId != null ? !wechatId.equals(that.wechatId) : that.wechatId != null) return false;
        if (taxpayerId != null ? !taxpayerId.equals(that.taxpayerId) : that.taxpayerId != null) return false;
        if (invoiceDate != null ? !invoiceDate.equals(that.invoiceDate) : that.invoiceDate != null) return false;
        if (invoiceContent != null ? !invoiceContent.equals(that.invoiceContent) : that.invoiceContent != null)
            return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (unitPrice != null ? !unitPrice.equals(that.unitPrice) : that.unitPrice != null) return false;
        if (taxRate != null ? !taxRate.equals(that.taxRate) : that.taxRate != null) return false;
        if (totalPriceWithoutTax != null ? !totalPriceWithoutTax.equals(that.totalPriceWithoutTax) : that.totalPriceWithoutTax != null)
            return false;
        if (taxPrice != null ? !taxPrice.equals(that.taxPrice) : that.taxPrice != null) return false;
        if (totalPrice != null ? !totalPrice.equals(that.totalPrice) : that.totalPrice != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (shopName != null ? shopName.hashCode() : 0);
        result = 31 * result + (wechatId != null ? wechatId.hashCode() : 0);
        result = 31 * result + (taxpayerId != null ? taxpayerId.hashCode() : 0);
        result = 31 * result + (invoiceDate != null ? invoiceDate.hashCode() : 0);
        result = 31 * result + (invoiceContent != null ? invoiceContent.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (taxRate != null ? taxRate.hashCode() : 0);
        result = 31 * result + (totalPriceWithoutTax != null ? totalPriceWithoutTax.hashCode() : 0);
        result = 31 * result + (taxPrice != null ? taxPrice.hashCode() : 0);
        result = 31 * result + (totalPrice != null ? totalPrice.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "machineId", nullable = true, length = 20)
    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Basic
    @Column(name = "companyName", nullable = true, length = 45)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "taxpayerId", nullable = true, length = 30)
    public String getTaxpayerId() {
        return taxpayerId;
    }

    public void setTaxpayerId(String taxpayerId) {
        this.taxpayerId = taxpayerId;
    }

        @Basic
    @Column(name = "model", nullable = true)
    public Integer getModel() {
        return model;
    }
public void setModel(Integer model) {
        this.model = model;
    }

    @Basic
    @Column(name = "unit", nullable = true)
    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }
}
