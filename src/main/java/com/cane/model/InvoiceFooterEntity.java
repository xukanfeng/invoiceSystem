package com.cane.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by xu_kanfeng on 16/7/13.
 */
@Entity
@Table(name = "invoiceFooter", schema = "invoiceSystem", catalog = "")
public class InvoiceFooterEntity {
    private int id;
    private String companyName;
    private String taxpayerId;
    private String companyAddress;
    private String phoneNumber;
    private String bankName;
    private String accountName;
    private String receiver;
    private String reviewer;
    private String drawer;
    private String comment;
    private Integer invoiceId;
    private Integer machineId;
    private Date invoiceDate;

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
    @Column(name = "bankName", nullable = true, length = 40)
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
    @Column(name = "receiver", nullable = true, length = 40)
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @Basic
    @Column(name = "reviewer", nullable = true, length = 40)
    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    @Basic
    @Column(name = "drawer", nullable = true, length = 20)
    public String getDrawer() {
        return drawer;
    }

    public void setDrawer(String drawer) {
        this.drawer = drawer;
    }

    @Basic
    @Column(name = "comment", nullable = true, length = 100)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "invoiceId", nullable = true)
    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Basic
    @Column(name = "machineId", nullable = true)
    public Integer getMachineId() {
        return machineId;
    }

    public void setMachineId(Integer machineId) {
        this.machineId = machineId;
    }

    @Basic
    @Column(name = "invoiceDate", nullable = true)
    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InvoiceFooterEntity that = (InvoiceFooterEntity) o;

        if (id != that.id) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (taxpayerId != null ? !taxpayerId.equals(that.taxpayerId) : that.taxpayerId != null) return false;
        if (companyAddress != null ? !companyAddress.equals(that.companyAddress) : that.companyAddress != null)
            return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (bankName != null ? !bankName.equals(that.bankName) : that.bankName != null) return false;
        if (accountName != null ? !accountName.equals(that.accountName) : that.accountName != null) return false;
        if (receiver != null ? !receiver.equals(that.receiver) : that.receiver != null) return false;
        if (reviewer != null ? !reviewer.equals(that.reviewer) : that.reviewer != null) return false;
        if (drawer != null ? !drawer.equals(that.drawer) : that.drawer != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (invoiceId != null ? !invoiceId.equals(that.invoiceId) : that.invoiceId != null) return false;
        if (machineId != null ? !machineId.equals(that.machineId) : that.machineId != null) return false;
        if (invoiceDate != null ? !invoiceDate.equals(that.invoiceDate) : that.invoiceDate != null) return false;

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
        result = 31 * result + (receiver != null ? receiver.hashCode() : 0);
        result = 31 * result + (reviewer != null ? reviewer.hashCode() : 0);
        result = 31 * result + (drawer != null ? drawer.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (invoiceId != null ? invoiceId.hashCode() : 0);
        result = 31 * result + (machineId != null ? machineId.hashCode() : 0);
        result = 31 * result + (invoiceDate != null ? invoiceDate.hashCode() : 0);
        return result;
    }
}
