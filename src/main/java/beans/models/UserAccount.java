package beans.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "userAccount")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserAccount {
    private long   id;
    private long userId;
    private double account;

    public UserAccount() {
    }

    public UserAccount(long id, long userId, double account) {
        this.id = id;
        this.userId = userId;
        this.account = account;
    }

    public UserAccount(long userId, double account) {
        this(-1, userId, account);
    }

    public UserAccount withId(long id) {
        return new UserAccount(id, userId, account);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAccount that = (UserAccount) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        return Double.compare(that.account, account) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        temp = Double.doubleToLongBits(account);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", userId=" + userId +
                ", account=" + account +
                '}';
    }
}
