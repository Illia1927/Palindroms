package com.akhambir.model;

import com.akhambir.controller.external.model.UserRegistrationPayload;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "USERS")
@NamedEntityGraph(name = "User.roles", attributeNodes = @NamedAttributeNode("roles"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "USERS_TO_ROLES",
            joinColumns = @JoinColumn(name = "FK_USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "FK_ROLE_ID"))
    private List<Role> roles = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Palindromes> palindromes;
    public List<Palindromes> getPalindromes() {
        return palindromes;
    }

    public void setPalindromes(List<Palindromes> palindromes) {
        this.palindromes = palindromes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getFirstName(), user.getFirstName()) &&
                Objects.equals(getLastName(), user.getLastName()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getRoles(), user.getRoles()) &&
                Objects.equals(getPalindromes(), user.getPalindromes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(),
                getLastName(),
                getEmail(),
                getPassword(),
                getRoles(),
                getPalindromes());
    }

    public static User of(UserRegistrationPayload urp) {
        User result = new User();
        result.setFirstName(urp.getFirstName());
        result.setLastName(urp.getLastName());
        result.setEmail(urp.getEmail());
        result.setPassword(urp.getPassword());
        return result;
    }
}
