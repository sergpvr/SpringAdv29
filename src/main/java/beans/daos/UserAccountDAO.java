package beans.daos;

import beans.models.UserAccount;

import java.util.List;
import java.util.Objects;

public interface UserAccountDAO {
    UserAccount create(UserAccount userAccount);

    void delete(UserAccount userAccount);

    UserAccount get(long id);

    UserAccount update(UserAccount userAccount);

    List<UserAccount> getAll();

    static void validateUserAccount(UserAccount userAccount) {
        if (Objects.isNull(userAccount)) {
            throw new NullPointerException("UserAccount is [null]");
        }
        if (Objects.isNull(userAccount.getUser())) {
            throw new NullPointerException("UserAccount's user is [null]. UserAccount: [" + userAccount + "]");
        }

    }

}
