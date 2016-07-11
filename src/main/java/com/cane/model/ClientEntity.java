package com.cane.model;

import javax.persistence.*;

/**
 * Created by xu_kanfeng on 16/1/22.
 */
@Entity
@Table(name = "client", schema = "demo_1", catalog = "")
public class ClientEntity {
    private int id;
    private String name;
    private String phoneNumber;
    private Byte drawCash;
    private Integer cashValue;
    private Byte drawIphone;
    private Integer phoneType;
    private Byte hasDrawed;
    private Byte hasDrawedIphone;
    private Byte hasDrawedCash;

    public void setCashValue(int cashValue) {
        this.cashValue = cashValue;
    }

    public void setPhoneType(int phoneType) {
        this.phoneType = phoneType;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    @Column(name = "drawCash", nullable = true)
    public Byte getDrawCash() {
        return drawCash;
    }

    public void setDrawCash(Byte drawCash) {
        this.drawCash = drawCash;
    }

    @Basic
    @Column(name = "cashValue", nullable = false)
    public Integer getCashValue() {
        return cashValue;
    }

    public void setCashValue(Integer cashValue) {
        this.cashValue = cashValue;
    }

    @Basic
    @Column(name = "drawIphone", nullable = true)
    public Byte getDrawIphone() {
        return drawIphone;
    }

    public void setDrawIphone(Byte drawIphone) {
        this.drawIphone = drawIphone;
    }

    @Basic
    @Column(name = "phoneType", nullable = false)
    public Integer getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(Integer phoneType) {
        this.phoneType = phoneType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEntity that = (ClientEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (drawCash != null ? !drawCash.equals(that.drawCash) : that.drawCash != null) return false;
        if (cashValue != null ? !cashValue.equals(that.cashValue) : that.cashValue != null) return false;
        if (drawIphone != null ? !drawIphone.equals(that.drawIphone) : that.drawIphone != null) return false;
        if (phoneType != null ? !phoneType.equals(that.phoneType) : that.phoneType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (drawCash != null ? drawCash.hashCode() : 0);
        result = 31 * result + (cashValue != null ? cashValue.hashCode() : 0);
        result = 31 * result + (drawIphone != null ? drawIphone.hashCode() : 0);
        result = 31 * result + (phoneType != null ? phoneType.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "hasDrawed", nullable = true)
    public Byte getHasDrawed() {
        return hasDrawed;
    }

    public void setHasDrawed(Byte hasDrawed) {
        this.hasDrawed = hasDrawed;
    }

    @Basic
    @Column(name = "hasDrawedIphone", nullable = true)
    public Byte getHasDrawedIphone() {
        return hasDrawedIphone;
    }

    public void setHasDrawedIphone(Byte hasDrawedIphone) {
        this.hasDrawedIphone = hasDrawedIphone;
    }

    @Basic
    @Column(name = "hasDrawedCash", nullable = true)
    public Byte getHasDrawedCash() {
        return hasDrawedCash;
    }

    public void setHasDrawedCash(Byte hasDrawedCash) {
        this.hasDrawedCash = hasDrawedCash;
    }
}
