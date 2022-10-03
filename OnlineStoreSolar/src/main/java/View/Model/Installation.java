/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
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
 * @author Kavya
 */
@Entity
@Table(name = "installation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Installation.findAll", query = "SELECT i FROM Installation i")
    , @NamedQuery(name = "Installation.findByInstallationID", query = "SELECT i FROM Installation i WHERE i.installationID = :installationID")
    , @NamedQuery(name = "Installation.findByStaffID", query = "SELECT i FROM Installation i WHERE i.staffID = :staffID")
    , @NamedQuery(name = "Installation.findByCustomerName", query = "SELECT i FROM Installation i WHERE i.customerName = :customerName")
    , @NamedQuery(name = "Installation.findByInstallationDate", query = "SELECT i FROM Installation i WHERE i.installationDate = :installationDate")
    , @NamedQuery(name = "Installation.findBySystemSize", query = "SELECT i FROM Installation i WHERE i.systemSize = :systemSize")
    , @NamedQuery(name = "Installation.findByAddress", query = "SELECT i FROM Installation i WHERE i.address = :address")})
public class Installation implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "InstallationID")
    private Integer installationID;
    @Basic(optional = false)
    @Column(name = "StaffID")
    private int staffID;
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
    @Basic(optional = false)
    @Column(name = "Address")
    private String address;

    public Installation() {
    }

    public Installation(Integer installationID) {
        this.installationID = installationID;
    }

    public Installation(Integer installationID, int staffID, String customerName, Date installationDate, int systemSize, String address) {
        this.installationID = installationID;
        this.staffID = staffID;
        this.customerName = customerName;
        this.installationDate = installationDate;
        this.systemSize = systemSize;
        this.address = address;
    }

    public Integer getInstallationID() {
        return installationID;
    }

    public void setInstallationID(Integer installationID) {
        Integer oldInstallationID = this.installationID;
        this.installationID = installationID;
        changeSupport.firePropertyChange("installationID", oldInstallationID, installationID);
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        int oldStaffID = this.staffID;
        this.staffID = staffID;
        changeSupport.firePropertyChange("staffID", oldStaffID, staffID);
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (installationID != null ? installationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Installation)) {
            return false;
        }
        Installation other = (Installation) object;
        if ((this.installationID == null && other.installationID != null) || (this.installationID != null && !this.installationID.equals(other.installationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Model.Installation[ installationID=" + installationID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
