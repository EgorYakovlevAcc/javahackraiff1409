package com.javahack.demo.models;

import com.javahack.demo.models.bankoperation.CreditRequest;
import com.javahack.demo.models.bankoperation.CreditResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
    private String email;
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
    private Date age;
    private String mobilePhone;
    private String role;
    @OneToMany(mappedBy = "holder", cascade = CascadeType.ALL)
    private List<Bill> bills;
    @OneToMany(mappedBy = "user_req", cascade = CascadeType.ALL)
    private List<CreditRequest> creditRequests;
    @OneToMany(mappedBy = "user_resp", cascade = CascadeType.ALL)
    private List<CreditResponse> creditResponses;
    private UserType userType;
    private BuisnessArea buisnessArea;
    @OneToOne(fetch = FetchType.EAGER,
            cascade =  CascadeType.ALL,
            mappedBy = "user")
    private ProductCatalog productCatalog;
    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public BuisnessArea getBuisnessArea() {
        return buisnessArea;
    }

    public void setBuisnessArea(BuisnessArea buisnessArea) {
        this.buisnessArea = buisnessArea;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public List<CreditRequest> getCreditRequests() {
        return creditRequests;
    }

    public void setCreditRequests(List<CreditRequest> creditRequests) {
        this.creditRequests = creditRequests;
    }

    public List<CreditResponse> getCreditResponses() {
        return creditResponses;
    }

    public void setCreditResponses(List<CreditResponse> creditResponses) {
        this.creditResponses = creditResponses;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String  role) {
        this.role = role;
    }

    public User () {

    }

    public User(UserType userType, BuisnessArea buisnessArea, Integer id, String login, String password, String email, Date age, String role, List<Bill> bills, List<CreditRequest> creditRequests, List<CreditResponse> creditResponses, String mobilePhone) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.age = age;
        this.id = id;
        this.role = role;
        this.bills = bills;
        this.creditRequests = creditRequests;
        this.creditResponses = creditResponses;
        this.mobilePhone = mobilePhone;
        this.buisnessArea = buisnessArea;
        this.userType = userType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> authorities = new ArrayList<>();
        authorities.add(Role.USER);
        return authorities;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            System.out.println("EXIT 1");
            return true;
        }
        if (obj == null) {
            System.out.println("EXIT 2");
            return false;
        }
        if (getClass() != obj.getClass()) {
            System.out.println("EXIT 3");
            return false;
        }

        User other = (User) obj;
//        if (other.getUsername().equals(username)) {
//            System.out.println("EXIT 4");
//            return false;
//        }

        if (other.getId() != id) {
            System.out.println("EXIT 5");
            return false;
        }
        return true;
    }
}
