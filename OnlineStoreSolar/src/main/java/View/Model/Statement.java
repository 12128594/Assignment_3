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
@Table(name = "statement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statement.findAll", query = "SELECT s FROM Statement s")
    , @NamedQuery(name = "Statement.findById", query = "SELECT s FROM Statement s WHERE s.id = :id")
    , @NamedQuery(name = "Statement.findByCustomerID", query = "SELECT s FROM Statement s WHERE s.customerID = :customerID")
    , @NamedQuery(name = "Statement.findByStatementDate", query = "SELECT s FROM Statement s WHERE s.statementDate = :statementDate")
    , @NamedQuery(name = "Statement.findByStatementAmount", query = "SELECT s FROM Statement s WHERE s.statementAmount = :statementAmount")
    , @NamedQuery(name = "Statement.findByStatementType", query = "SELECT s FROM Statement s WHERE s.statementType = :statementType")
    , @NamedQuery(name = "Statement.findByDescription", query = "SELECT s FROM Statement s WHERE s.description = :description")})
public class Statement implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "customer_ID")
    private Integer customerID;
    @Column(name = "statement_date")
    @Temporal(TemporalType.DATE)
    private Date statementDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "statement_amount")
    private BigDecimal statementAmount;
    @Column(name = "statement_type")
    private Character statementType;
    @Column(name = "description")
    private String description;

    public Statement() {
    }

    public Statement(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        Integer oldCustomerID = this.customerID;
        this.customerID = customerID;
        changeSupport.firePropertyChange("customerID", oldCustomerID, customerID);
    }

    public Date getStatementDate() {
        return statementDate;
    }

    public void setStatementDate(Date statementDate) {
        Date oldStatementDate = this.statementDate;
        this.statementDate = statementDate;
        changeSupport.firePropertyChange("statementDate", oldStatementDate, statementDate);
    }

    public BigDecimal getStatementAmount() {
        return statementAmount;
    }

    public void setStatementAmount(BigDecimal statementAmount) {
        BigDecimal oldStatementAmount = this.statementAmount;
        this.statementAmount = statementAmount;
        changeSupport.firePropertyChange("statementAmount", oldStatementAmount, statementAmount);
    }

    public Character getStatementType() {
        return statementType;
    }

    public void setStatementType(Character statementType) {
        Character oldStatementType = this.statementType;
        this.statementType = statementType;
        changeSupport.firePropertyChange("statementType", oldStatementType, statementType);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        String oldDescription = this.description;
        this.description = description;
        changeSupport.firePropertyChange("description", oldDescription, description);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statement)) {
            return false;
        }
        Statement other = (Statement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Model.Statement[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
