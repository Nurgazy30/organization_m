package kg.nurgazy.organization.management.repository;

import kg.nurgazy.organization.management.config.CopyUtil;
import kg.nurgazy.organization.management.config.HibernateUtil;
import kg.nurgazy.organization.management.entity.EmployeeEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAO{

    public EmployeeEntity getByID(Long id) {
        Transaction transaction = null;
        EmployeeEntity entity = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession() ){
            transaction = session.beginTransaction();
            entity = session.get(EmployeeEntity.class, id);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return entity;
    }

    public List<EmployeeEntity> getAll(){
        Transaction transaction = null;
        List<EmployeeEntity> entityList = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession() ){
            transaction = session.beginTransaction();
            entityList = session.createQuery("from EmployeeEntity").list();
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

        return entityList;
    }

    public void saveEmployee(EmployeeEntity entity) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
        }
    }

    public void updateEmployee(EmployeeEntity entity) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            var entity1 = session.get(EmployeeEntity.class, entity.getId());
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

    public void deleteEmployee(Long id) {
        Transaction transaction = null;
        EmployeeEntity entity = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            entity = session.get(EmployeeEntity.class, id);
            session.delete(entity);

            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
        }
    }

    public void deleteAll(Long organizationId) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.createQuery("DELETE FROM EmployeeEntity WHERE organization_id = :id")
                    .setParameter("id", organizationId)
                    .executeUpdate();

            transaction.commit();
        }
        catch (Exception e) {
        if (transaction!= null){
            transaction.rollback();
        }}
    }



}