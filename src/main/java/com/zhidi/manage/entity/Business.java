package com.zhidi.manage.entity;
// default package

import com.zhidi.manage.vo.BusinessVO;
import com.zhidi.system.entity.User;
import com.zhidi.util.DateUtil;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Business entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "TB_CRM_BUSINESS"
        , schema = "NICETEAM"
)

public class Business implements java.io.Serializable {


    // Fields    

    private String businessid;
    private User userByUpdateuserid;
    private User userByCreatoruserid;
    private BusinessStatus businessStatus;
    private Contacts businessContacts;
    private User userByOwneruserid;
    private Customer customer;
    private User userByDeleteuserid;
    private String name;
    private String origin;//信息来源
    private String type;//商机类型
    private Integer estimateprice;//预计成交价
    private Short gainrate;//赢单率
    private Integer totalamount;
    private Double subtotalval;
    private Double discountprice;
    private Double salesprice;//商机金额，售价
    private String duedate;
    private Date createtime;
    private Date updatetime;
    private Double totalprice;
    private String nextstep;//下次联系内容
    private Date nextsteptime;//下次联系时间
    private Byte isdeleted;
    private Date deletetime;
    private String contractaddress;
    private String description;
    private Set<Contract> contracts = new HashSet<Contract>(0);
    private Set<Leads> leadses = new HashSet<Leads>(0);
    private Set<Customer> customers = new HashSet<Customer>(0);
    private Set<BusinessProduct> businessProducts = new HashSet<BusinessProduct>(0);
    private Set<Contract> contracts_1 = new HashSet<Contract>(0);


    // Constructors

    /**
     * default constructor
     */
    public Business() {
    }

    /**
     * minimal constructor
     */
    public Business(String name, Integer estimateprice) {
        this.name = name;
        this.estimateprice = estimateprice;
    }


    // Property accessors
    @GenericGenerator(name = "generator", strategy = "uuid")
    @Id
    @GeneratedValue(generator = "generator")

    @Column(name = "BUSINESSID", unique = true, nullable = false, length = 32)

    public String getBusinessid() {
        return this.businessid;
    }

    public void setBusinessid(String businessid) {
        this.businessid = businessid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATORUSERID")

    public User getUserByCreatoruserid() {
        return this.userByCreatoruserid;
    }

    public void setUserByCreatoruserid(User userByCreatoruserid) {
        this.userByCreatoruserid = userByCreatoruserid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUSID")

    public BusinessStatus getBusinessStatus() {
        return this.businessStatus;
    }

    public void setBusinessStatus(BusinessStatus businessStatus) {
        this.businessStatus = businessStatus;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UPDATEUSERID")

    public User getUserByUpdateuserid() {
        return this.userByUpdateuserid;
    }

    public void setUserByUpdateuserid(User userByUpdateuserid) {
        this.userByUpdateuserid = userByUpdateuserid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTACTSID")

    public Contacts getBusinessContacts() {
        return this.businessContacts;
    }

    public void setBusinessContacts(Contacts businessContacts) {
        this.businessContacts = businessContacts;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OWNERUSERID")

    public User getUserByOwneruserid() {
        return this.userByOwneruserid;
    }

    public void setUserByOwneruserid(User userByOwneruserid) {
        this.userByOwneruserid = userByOwneruserid;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMERID")

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DELETEUSERID")

    public User getUserByDeleteuserid() {
        return this.userByDeleteuserid;
    }

    public void setUserByDeleteuserid(User userByDeleteuserid) {
        this.userByDeleteuserid = userByDeleteuserid;
    }

    @Column(name = "NAME", nullable = false)

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "ORIGIN")

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Column(name = "TYPE", length = 200)

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "ESTIMATEPRICE", nullable = false, precision = 11, scale = 0)

    public Integer getEstimateprice() {
        return this.estimateprice;
    }

    public void setEstimateprice(Integer estimateprice) {
        this.estimateprice = estimateprice;
    }

    @Column(name = "GAINRATE", precision = 3, scale = 0)

    public Short getGainrate() {
        return this.gainrate;
    }

    public void setGainrate(Short gainrate) {
        this.gainrate = gainrate;
    }

    @Column(name = "TOTALAMOUNT", precision = 10, scale = 0)

    public Integer getTotalamount() {
        return this.totalamount;
    }

    public void setTotalamount(Integer totalamount) {
        this.totalamount = totalamount;
    }

    @Column(name = "SUBTOTALVAL", precision = 10)

    public Double getSubtotalval() {
        return this.subtotalval;
    }

    public void setSubtotalval(Double subtotalval) {
        this.subtotalval = subtotalval;
    }

    @Column(name = "DISCOUNTPRICE", precision = 10)

    public Double getDiscountprice() {
        return this.discountprice;
    }

    public void setDiscountprice(Double discountprice) {
        this.discountprice = discountprice;
    }

    @Column(name = "SALESPRICE", precision = 10)

    public Double getSalesprice() {
        return this.salesprice;
    }

    public void setSalesprice(Double salesprice) {
        this.salesprice = salesprice;
    }

    @Column(name = "DUEDATE")

    public String getDuedate() {
        return this.duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    @Column(name = "CREATETIME")

    public Date getCreatetime() {
        return this.createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Column(name = "UPDATETIME")

    public Date getUpdatetime() {
        return this.updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Column(name = "TOTALPRICE", precision = 10)

    public Double getTotalprice() {
        return this.totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    @Column(name = "NEXTSTEP", length = 100)

    public String getNextstep() {
        return this.nextstep;
    }

    public void setNextstep(String nextstep) {
        this.nextstep = nextstep;
    }

    @Column(name = "NEXTSTEPTIME")

    public Date getNextsteptime() {
        return this.nextsteptime;
    }

    public void setNextsteptime(Date nextsteptime) {
        this.nextsteptime = nextsteptime;
    }

    @Column(name = "ISDELETED", precision = 2, scale = 0)

    public Byte getIsdeleted() {
        return this.isdeleted;
    }

    public void setIsdeleted(Byte isdeleted) {
        this.isdeleted = isdeleted;
    }

    @Column(name = "DELETETIME")

    public Date getDeletetime() {
        return this.deletetime;
    }

    public void setDeletetime(Date deletetime) {
        this.deletetime = deletetime;
    }

    @Column(name = "CONTRACTADDRESS")

    public String getContractaddress() {
        return this.contractaddress;
    }

    public void setContractaddress(String contractaddress) {
        this.contractaddress = contractaddress;
    }

    @Column(name = "DESCRIPTION")

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "business")

    public Set<Contract> getContracts() {
        return this.contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "business")

    public Set<Leads> getLeadses() {
        return this.leadses;
    }

    public void setLeadses(Set<Leads> leadses) {
        this.leadses = leadses;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "businesses_1")

    public Set<Customer> getCustomers() {
        return this.customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "business")

    public Set<BusinessProduct> getBusinessProducts() {
        return this.businessProducts;
    }

    public void setBusinessProducts(Set<BusinessProduct> businessProducts) {
        this.businessProducts = businessProducts;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "businesses")

    public Set<Contract> getContracts_1() {
        return this.contracts_1;
    }

    public void setContracts_1(Set<Contract> contracts_1) {
        this.contracts_1 = contracts_1;
    }


    /**
     * 实体转为businessVO
     *
     * @return
  /*   *//*
    public static Business fromBusinessVO(BusinessVO businessVO, User user, Customer customer, BusinessStatus businessStatus, Contacts contacts) throws ParseException {
        if (businessVO != null) {
            Business business = new Business();
            business.setBusinessid(businessVO.getBusinessId());
            business.setUserByUpdateuserid(user);
            business.setUserByCreatoruserid(user);
            business.setBusinessStatus(businessStatus);
            business.setBusinessContacts(contacts);
            business.setUserByOwneruserid(user);
            business.setCustomer(customer);
            business.setUserByDeleteuserid(user);
            business.setName(businessVO.getBusinessName());
            business.setOrigin(businessVO.getBusinessOrgnin());
            business.setType(businessVO.getType());
            business.setEstimateprice(Integer.parseInt(businessVO.getEstimateprice()));
            business.setGainrate(new Short(businessVO.getGainrate()));
            business.setTotalamount(Integer.parseInt(businessVO.getTotalamount()));
            business.setSubtotalval(new Double(businessVO.getSubtotalval()));
            business.setDiscountprice(new Double(businessVO.getDescription()));
            business.setSalesprice(new Double(businessVO.getSalesprice()));
            business.setDuedate(businessVO.getDuedate());
            if(businessVO.getCreatetimeBusiness() != null) {
                business.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(businessVO.getCreatetimeBusiness()));
            }
            if(businessVO.getUpdatetimeBusiness() != null) {
                business.setUpdatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(businessVO.getUpdatetimeBusiness()));
            }
            business.setTotalprice(new Double(businessVO.getTotalprice()));
            business.setNextstep(businessVO.getNextstep());
            if(businessVO.getNextsteptime() != null) {
                business.setNextsteptime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(businessVO.getNextsteptime()));
            }
            business.setIsdeleted(new Byte(businessVO.getIsdeleted()));
            if(businessVO.getDeletetime() != null) {
                business.setDeletetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(businessVO.getDeletetime()));
            }
            business.setContractaddress(businessVO.getContractaddress());
            business.setDiscountprice(new Double(businessVO.getDescription()));


*/
          /*  business.setName(businessVO.getBusinessName());
            business.setOrigin(businessVO.getBusinessOrgnin());
            business.setType(businessVO.getType());
           // business.setEstimateprice(Integer.parseInt(businessVO.getEstimateprice()));
            if (user != null) {
                business.setUserByUpdateuserid(user);
                business.setUserByCreatoruserid(user);
            }
            if (customer != null) {
                business.setCustomer(customer);
            }
            business.setBusinessid(businessVO.getBusinessId());
            business.setOrigin(businessVO.getBusinessOrgnin());
            //    business.setNextsteptime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(businessVO.getNextsteptime()));
            if (businessVO.getNextstep() != null) {
                business.setNextstep(businessVO.getNextstep());
            }
            //business.setCreatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(businessVO.getCreatetimeBusiness()));
         //   business.setUpdatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(businessVO.getUpdatetimeBusiness()));
          //  business.setSalesprice((new  Double(businessVO.getSalesprice())));
          //  business.setContractaddress(businessVO.getContractaddress());
            business.setType(businessVO.getType());
            business.setGainrate(new Short(businessVO.getGainrate()));
           // business.setEstimateprice(Integer.parseInt(businessVO.getEstimateprice()));
            business.setDescription(businessVO.getDescription());
       *//*     if (businessStatus != null) {
                business.setBusinessStatus(businessStatus);
            }*//*
            business.setName(businessVO.getBusinessName());*/
  /*          return business;
        }
        return null;
    }*/


    public static Business fromBusiness(BusinessVO businessVO){
        if(businessVO != null){
            Business business=new Business();
            business.setBusinessid(businessVO.getBusinessId());
            business.setName(businessVO.getBusinessName());
            if(businessVO.getCustomerId()!=null){
                Customer customer=new Customer();
                customer.setCustomerid(businessVO.getCustomerId());
                business.setCustomer(customer);
            }
            if(businessVO.getUpdateById() != null){
                User user=new User();
                user.setId(businessVO.getUpdateById());
                business.setUserByOwneruserid(user);
            }
            if(businessVO.getContactsId()!=null){
                Contacts contacts=new Contacts();
                contacts.setContactsid(businessVO.getContactsId());
                business.setBusinessContacts(contacts);
            }
            if(businessVO.getBusinessStatusId()!=null){
                BusinessStatus statu=new BusinessStatus();
                statu.setStatusid(businessVO.getBusinessStatusId());
                business.setBusinessStatus(statu);
            }
            business.setType(businessVO.getType());
            business.setOrigin(businessVO.getBusinessOrgnin());
            business.setSalesprice(new Double( businessVO.getSalesprice()));
            business.setEstimateprice(Integer.parseInt (businessVO.getEstimateprice()));
            business.setContractaddress(businessVO.getContractaddress());
            business.setDescription(businessVO.getDescription());
            business.setNextstep(businessVO.getNextstep());
            business.setGainrate(new Short(businessVO.getGainrate()));
            if(businessVO.getCreateById() != null){
                User user=new User();
                user.setId(businessVO.getCreateById());
                business.setUserByCreatoruserid(user);
            }
            if(businessVO.getUpdateById() != null){
                User user=new User();
                user.setId(businessVO.getUpdateById());
                business.setUserByUpdateuserid(user);
            }
            if(businessVO.getCreatetimeBusiness()!=null){
                business.setCreatetime(DateUtil.parseDate(businessVO.getCreatetimeBusiness(), "yyyy-MM-dd HH:mm"));
            }
            if(businessVO.getUpdatetimeBusiness()!=null){
                business.setUpdatetime(DateUtil.parseDate(businessVO.getUpdatetimeBusiness(), "yyyy-MM-dd HH:mm"));
            }
            if(businessVO.getNextsteptime()!=null){
                business.setNextsteptime(DateUtil.parseDate(businessVO.getNextsteptime(), "yyyy-MM-dd HH:mm"));
            }
            if(businessVO.getDeletetime()!=null){
                business.setDeletetime(DateUtil.parseDate(businessVO.getDeletetime(), "yyyy-MM-dd HH:mm"));
            }
            return business;
        }
        return null;
    }














}