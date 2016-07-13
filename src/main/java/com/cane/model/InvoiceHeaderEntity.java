package com.cane.model;

import javax.persistence.*;

/**
 * Created by xu_kanfeng on 16/7/13.
 */
@Entity
@Table(name = "invoiceHeader", schema = "invoiceSystem", catalog = "")
public class InvoiceHeaderEntity {
    private int id;
    private String companyName;
    private String taxpayerId;
    private String companyAddress;
    private String phoneNumber;
    private String bankName;
    private String accountName;
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
    @Column(name = "companyName", nullable = true, length = 40)
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
    @Column(name = "companyAddress", nullable = true, length = 40)
    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    @Basic
    @Column(name = "phoneNumber", nullable = true, length = 20)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "bankName", nullable = true, length = 20)
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Basic
    @Column(name = "accountName", nullable = true, length = 20)
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
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

        InvoiceHeaderEntity that = (InvoiceHeaderEntity) o;

        if (id != that.id) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (taxpayerId != null ? !taxpayerId.equals(that.taxpayerId) : that.taxpayerId != null) return false;
        if (companyAddress != null ? !companyAddress.equals(that.companyAddress) : that.companyAddress != null)
            return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (bankName != null ? !bankName.equals(that.bankName) : that.bankName != null) return false;
        if (accountName != null ? !accountName.equals(that.accountName) : that.accountName != null) return false;
        if (invoiceId != null ? !invoiceId.equals(that.invoiceId) : that.invoiceId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (taxpayerId != null ? taxpayerId.hashCode() : 0);
        result = 31 * result + (companyAddress != null ? companyAddress.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (bankName != null ? bankName.hashCode() : 0);
        result = 31 * result + (accountName != null ? accountName.hashCode() : 0);
        result = 31 * result + (invoiceId != null ? invoiceId.hashCode() : 0);
        return result;
    }
}
