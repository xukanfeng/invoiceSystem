package com.cane.model;

import javax.persistence.*;

/**
 * Created by xu_kanfeng on 16/7/13.
 */
@Entity
@Table(name = "invoiceContent", schema = "invoiceSystem", catalog = "")
public class InvoiceContentEntity {
    private int id;
    private String content;
    private String model;
    private String unit;
    private Integer amount;
    private Double unitPrice;
    private Double priceWithTax;
    private Double priceWithoutTax;
    private Double taxRate;
    private Double taxPrice;
    private Double totalPriceWithTax;
    private Double totalPriceWithoutTax;
    private Double totalTaxPrice;
    private String priceInChineseNumerals;
    private Integer invoiceId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 20)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "model", nullable = true, length = 20)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "unit", nullable = true, length = 5)
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
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
    @Column(name = "priceWithTax", nullable = true, precision = 0)
    public Double getPriceWithTax() {
        return priceWithTax;
    }

    public void setPriceWithTax(Double priceWithTax) {
        this.priceWithTax = priceWithTax;
    }

    @Basic
    @Column(name = "priceWithoutTax", nullable = true, precision = 0)
    public Double getPriceWithoutTax() {
        return priceWithoutTax;
    }

    public void setPriceWithoutTax(Double priceWithoutTax) {
        this.priceWithoutTax = priceWithoutTax;
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
    @Column(name = "taxPrice", nullable = true, precision = 0)
    public Double getTaxPrice() {
        return taxPrice;
    }

    public void setTaxPrice(Double taxPrice) {
        this.taxPrice = taxPrice;
    }

    @Basic
    @Column(name = "totalPriceWithTax", nullable = true, precision = 0)
    public Double getTotalPriceWithTax() {
        return totalPriceWithTax;
    }

    public void setTotalPriceWithTax(Double totalPriceWithTax) {
        this.totalPriceWithTax = totalPriceWithTax;
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
    @Column(name = "totalTaxPrice", nullable = true, precision = 0)
    public Double getTotalTaxPrice() {
        return totalTaxPrice;
    }

    public void setTotalTaxPrice(Double totalTaxPrice) {
        this.totalTaxPrice = totalTaxPrice;
    }

    @Basic
    @Column(name = "priceInChineseNumerals", nullable = true, length = 11)
    public String getPriceInChineseNumerals() {
        return priceInChineseNumerals;
    }

    public void setPriceInChineseNumerals(String priceInChineseNumerals) {
        this.priceInChineseNumerals = priceInChineseNumerals;
    }

    @Basic
    @Column(name = "invoiceId", nullable = true)
    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceContentEntity that = (InvoiceContentEntity) o;

        if (id != that.id) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (unitPrice != null ? !unitPrice.equals(that.unitPrice) : that.unitPrice != null) return false;
        if (priceWithTax != null ? !priceWithTax.equals(that.priceWithTax) : that.priceWithTax != null) return false;
        if (priceWithoutTax != null ? !priceWithoutTax.equals(that.priceWithoutTax) : that.priceWithoutTax != null)
            return false;
        if (taxRate != null ? !taxRate.equals(that.taxRate) : that.taxRate != null) return false;
        if (taxPrice != null ? !taxPrice.equals(that.taxPrice) : that.taxPrice != null) return false;
        if (totalPriceWithTax != null ? !totalPriceWithTax.equals(that.totalPriceWithTax) : that.totalPriceWithTax != null)
            return false;
        if (totalPriceWithoutTax != null ? !totalPriceWithoutTax.equals(that.totalPriceWithoutTax) : that.totalPriceWithoutTax != null)
            return false;
        if (totalTaxPrice != null ? !totalTaxPrice.equals(that.totalTaxPrice) : that.totalTaxPrice != null)
            return false;
        if (priceInChineseNumerals != null ? !priceInChineseNumerals.equals(that.priceInChineseNumerals) : that.priceInChineseNumerals != null)
            return false;
        if (invoiceId != null ? !invoiceId.equals(that.invoiceId) : that.invoiceId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (priceWithTax != null ? priceWithTax.hashCode() : 0);
        result = 31 * result + (priceWithoutTax != null ? priceWithoutTax.hashCode() : 0);
        result = 31 * result + (taxRate != null ? taxRate.hashCode() : 0);
        result = 31 * result + (taxPrice != null ? taxPrice.hashCode() : 0);
        result = 31 * result + (totalPriceWithTax != null ? totalPriceWithTax.hashCode() : 0);
        result = 31 * result + (totalPriceWithoutTax != null ? totalPriceWithoutTax.hashCode() : 0);
        result = 31 * result + (totalTaxPrice != null ? totalTaxPrice.hashCode() : 0);
        result = 31 * result + (priceInChineseNumerals != null ? priceInChineseNumerals.hashCode() : 0);
        result = 31 * result + (invoiceId != null ? invoiceId.hashCode() : 0);
        return result;
    }
}
