package kg.nurgazy.organization.management.repository;

import kg.nurgazy.organization.management.config.CopyUtil;
import kg.nurgazy.organization.management.config.HibernateUtil;
import kg.nurgazy.organization.management.entity.OrganizationEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class OrganizationDAO{

    public OrganizationEntity getByID(Long id) {
        Transaction transaction = null;
        OrganizationEntity entity = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession() ){
            transaction = session.beginTransaction();
            entity = session.get(OrganizationEntity.class, id);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return entity;
    }

    public Long getIdByOrganizationName(String value) {
        Transaction transaction = null;
        Long entityId = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession() ){
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM OrganizationEntity WHERE organizationName = :name");
            query.setParameter("name", value );
            var obj = (OrganizationEntity) query.uniqueResult();
            entityId = obj.getId();
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return entityId;
    }

    @SuppressWarnings("unchecked")
    public List<OrganizationEntity> getAll(){
        Transaction transaction = null;
        List<OrganizationEntity> entityList = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession() ){
            transaction = session.beginTransaction();
            entityList = session.createQuery("from OrganizationEntity").list();
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return entityList;
    }

    public Serializable saveOrganization(OrganizationEntity entity) {
        Transaction transaction = null;
        Serializable id = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            id = session.save(entity);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
        }
        return id;
    }

    public void updateOrganization(OrganizationEntity entity) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            var entity1 = session.get(OrganizationEntity.class, entity.getId());
            CopyUtil.updateEntity(entity, entity1);
            session.saveOrUpdate(entity1);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
        }
    }

    public void deleteOrganization(Long id) {
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            var entity = session.get(OrganizationEntity.class, id);
            session.delete(entity);

            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
        }
    }



}
