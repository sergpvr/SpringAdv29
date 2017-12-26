package beans.services;

import beans.daos.UserAccountDAO;
import beans.daos.UserDAO;
import beans.models.Ticket;
import beans.models.User;
import beans.models.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dmytro_Babichev
 * Date: 2/1/2016
 * Time: 7:30 PM
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final UserAccountDAO userAccountDAO;

    @Autowired
    public UserServiceImpl(@Qualifier("userDAO") UserDAO userDAO,
                           @Qualifier("userAccountDAO") UserAccountDAO userAccountDAO) {
        this.userDAO = userDAO;
        this.userAccountDAO = userAccountDAO;
    }

    public User register(User user) {
        return userDAO.create(user);
    }

    public void remove(User user) {
        userDAO.delete(user);
    }

    public User getById(long id) {
        return userDAO.get(id);
    }

    public User getUserByEmail(String email) {
        return userDAO.getByEmail(email);
    }

    public List<User> getUsersByName(String name) {
        return userDAO.getAllByName(name);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    public List<Ticket> getBookedTickets() {
        throw new UnsupportedOperationException("not implemented yet");
    }

    @Override
    public void refillAccount(long userId, double amount) {
        User user = userDAO.get(userId);
        UserAccount userAccount = user.getUserAccount();
        if(userAccount == null) {
            user.setUserAccount(new UserAccount(user, amount));
        }  else {
            userAccount.setAmount(userAccount.getAmount() + amount);
        }
        userDAO.update(user);
    }

    @Override
    public List<UserAccount> getUserAccounts() {
        return userAccountDAO.getAll();
    }
}
