package java;

import com.iweb.DAO.UserDAO;
import com.iweb.DAO.impl.UserDAOImpl;
import com.iweb.pojo.Product;
import com.iweb.pojo.User;
import com.iweb.util.DButil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collection;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
 /*   public void shopCart(User user)
    {
        UserDAOImpl udi =new UserDAOImpl();
        List<Product> pd =udi.shoppingMethod();
        Double money = 0.00;
        for (Product p: pd) {
            money=money+p.getPromotePrice();
        }
        Double SurplusMoney =user.getMoney()-money;
        user.setMoney(SurplusMoney);
        String sql ="update user money=? where id = ?";
        try(
                Connection c = DButil.getConnection();
                PreparedStatement ps =c.prepareStatement(sql)
                )
        {
            ps.setDouble(1,user.getMoney());
            ps.setInt(2,user.getId());
            ps.execute();
        }
        catch (Exception e)
        {
           e.printStackTrace();
        }*/

   // }

}
