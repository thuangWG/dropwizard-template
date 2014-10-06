package com.amplify.micro.db;

import com.amplify.micro.core.UserWarning;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: thuang
 * Date: 9/22/14
 * Time: 2:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserWarningDAO extends AbstractDAO<UserWarning> {

    public UserWarningDAO(SessionFactory factory) {
        super(factory);
    }


    public UserWarning findById(Long id) {
        return get(id);
    }

    public UserWarning findByBK(String user_Business_Key) {
        UserWarning userWarning = (UserWarning) currentSession().createCriteria(UserWarning.class)
                .add(Restrictions.ilike("user_Business_Key", user_Business_Key))
                .uniqueResult();
        return userWarning;
    }

    public String findByBKSql(String user_Business_Key) {

        Query query = currentSession().getNamedQuery("findUserWarningByBKSql");
        query.setParameter("businessKey", user_Business_Key);
        return query.list().get(0).toString();
    }

    public long create(UserWarning userWarning) {
        return persist(userWarning).getId();
    }

    public List<UserWarning> findAll() {
        return list(namedQuery("com.amplify.core.UserWarning.findAll"));
    }
}
