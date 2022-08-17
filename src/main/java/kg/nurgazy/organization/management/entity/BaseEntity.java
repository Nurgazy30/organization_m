package kg.nurgazy.organization.management.entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public boolean equals(Object obj) {
        if (null == obj || !(obj instanceof BaseEntity)) return false;

        BaseEntity other = (BaseEntity) obj;

        if (this == other) return true;


        return this.id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        if (null == this.id) return -1;
        return this.id.intValue() * 97;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
