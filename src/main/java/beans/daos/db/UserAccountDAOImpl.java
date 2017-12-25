package beans.daos.db;

import beans.daos.AbstractDAO;
import beans.daos.UserAccountDAO;
import beans.models.UserAccount;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userAccountDAO")
public class UserAccountDAOImpl extends AbstractDAO implements UserAccountDAO {


    @Override
    public UserAccount create(UserAccount userAccount) {
        UserAccountDAO.validateUserAccount(userAccount);
        if (getByUserId(userAccount.getUserId()) != null) {
            throw new IllegalStateException(
                    String.format("Unable to store userAccount: [%s]. UserAccount with userId: [%d] is already created.",
                            userAccount, userAccount.getUserId()));
        } else {
            Long userId = (Long) getCurrentSession().save(userAccount);
            return userAccount.withId(userId);
        }
    }

    @Override
    public void delete(UserAccount userAccount) {
        getCurrentSession().delete(userAccount);
    }

    @Override
    public UserAccount get(long id) {
        return (UserAccount) getCurrentSession().get(UserAccount.class, id);
    }

    @Override
    public UserAccount getByUserId(long userId) {
        return ((UserAccount) createBlankCriteria(UserAccount.class)
                .add(Restrictions.eq("userId", userId)).uniqueResult());
    }

    @Override
    public UserAccount update(UserAccount userAccount) {
        return ((UserAccount) getCurrentSession().merge(userAccount));
    }

    @Override
    public List<UserAccount> getAll() {
        return ((List<UserAccount>) createBlankCriteria(UserAccount.class).list());
    }
}
