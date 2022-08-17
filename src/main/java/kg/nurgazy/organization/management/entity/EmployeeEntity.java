package kg.nurgazy.organization.management.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "employees")
public class EmployeeEntity extends BaseEntity {

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "home_tel")
    private String homeTelNumber;

    @Column(name = "mobile_tel")
    private String mobTelNumber;

    @Column(name = "working_tel")
    private String workTelNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "bank_account")
    private String bankAccount;

    @Column(name = "position")
    private String position;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private OrganizationEntity organization;

}
