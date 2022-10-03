/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 
 */
@Entity
@Table(name = "payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p")
    , @NamedQuery(name = "Payment.findByPaymentID", query = "SELECT p FROM Payment p WHERE p.paymentID = :paymentID")
    , @NamedQuery(name = "Payment.findByCustomerName", query = "SELECT p FROM Payment p WHERE p.customerName = :customerName")
    , @NamedQuery(name = "Payment.findByInstallationDate", query = "SELECT p FROM Payment p WHERE p.installationDate = :installationDate")
    , @NamedQuery(name = "Payment.findBySystemSize", query = "SELECT p FROM Payment p WHERE p.systemSize = :systemSize")
    , @NamedQuery(name = "Payment.findByPaymentAmount", query = "SELECT p FROM Payment p WHERE p.paymentAmount = :paymentAmount")})
public class Payment implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "paymentID")
    private Integer paymentID;
    @Basic(optional = false)
    @Column(name = "customerName")
    private String customerName;
    @Basic(optional = false)
    @Column(name = "installationDate")
    @Temporal(TemporalType.DATE)
    private Date installationDate;
    @Basic(optional = false)
    @Column(name = "systemSize")
    private int systemSize;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "paymentAmount")
    private BigDecimal paymentAmount;

    public Payment() {
    }

    public Payment(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public Payment(Integer paymentID, String customerName, Date installationDate, int systemSize, BigDecimal paymentAmount) {
        this.paymentID = paymentID;
        this.customerName = customerName;
        this.installationDate = installationDate;
        this.systemSize = systemSize;
        this.paymentAmount = paymentAmount;
    }

    public Integer getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Integer paymentID) {
        Integer oldPaymentID = this.paymentID;
        this.paymentID = paymentID;
        changeSupport.firePropertyChange("paymentID", oldPaymentID, paymentID);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        String oldCustomerName = this.customerName;
        this.customerName = customerName;
        changeSupport.firePropertyChange("customerName", oldCustomerName, customerName);
    }

    public Date getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(Date installationDate) {
        Date oldInstallationDate = this.installationDate;
        this.installationDate = installationDate;
        changeSupport.firePropertyChange("installationDate", oldInstallationDate, installationDate);
    }

    public int getSystemSize() {
        return systemSize;
    }

    public void setSystemSize(int systemSize) {
        int oldSystemSize = this.systemSize;
        this.systemSize = systemSize;
        changeSupport.firePropertyChange("systemSize", oldSystemSize, systemSize);
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        BigDecimal oldPaymentAmount = this.paymentAmount;
        this.paymentAmount = paymentAmount;
        changeSupport.firePropertyChange("paymentAmount", oldPaymentAmount, paymentAmount);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentID != null ? paymentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.paymentID == null && other.paymentID != null) || (this.paymentID != null && !this.paymentID.equals(other.paymentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Model.Payment[ paymentID=" + paymentID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
