package beans.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "userAccount")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserAccount {
    private long   id;
    private User user;
    private double amount;

    public UserAccount() {
    }

    public UserAccount(long id, User user, double amount) {
        this.id = id;
        this.user = user;
        this.amount = amount;
    }

    public UserAccount(User user, double account) {
        this(-1, user, account);
    }

    public UserAccount withId(long id) {
        return new UserAccount(id, user, amount);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAccount that = (UserAccount) o;

        if (id != that.id) return false;
        if (user != that.user) return false;
        return Double.compare(that.amount, amount) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + user.hashCode();
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", user" + user.getEmail() +
                ", account=" + amount +
                '}';
    }
}
