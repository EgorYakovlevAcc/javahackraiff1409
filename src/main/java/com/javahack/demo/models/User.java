package com.javahack.demo.models;

import com.javahack.demo.models.bankoperation.CreditRequest;
import com.javahack.demo.models.bankoperation.CreditResponse;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
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
    private Integer age;
    private String sex;
    private String role;
    @OneToMany(mappedBy = "holder", cascade = CascadeType.ALL)
    private List<Bill> bills;
    @OneToMany(mappedBy = "user_req", cascade = CascadeType.ALL)
    private List<CreditRequest> creditRequests;
    @OneToMany(mappedBy = "user_resp", cascade = CascadeType.ALL)
    private List<CreditResponse> creditResponses;

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

    public User(Integer id, String login, String password, String email, Integer age, String sex, String role, List<Bill> bills, List<CreditRequest> creditRequests, List<CreditResponse> creditResponses) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.age = age;
        this.sex = sex;
        this.id = id;
        this.role = role;
        this.bills = bills;
        this.creditRequests = creditRequests;
        this.creditResponses = creditResponses;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
