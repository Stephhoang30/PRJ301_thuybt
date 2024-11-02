/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.implement;

import dal.GenericDAO;
import java.util.LinkedHashMap;
import java.util.List;
import model.Product;

/**
 *
 * @author stephhoang
 */
public class ProductDAO extends GenericDAO<Product> {

    @Override
    public List<Product> findAll() {
        return queryGenericDAO(Product.class);
    }

    @Override
    public int insert(Product t) {
        // dinh nghia cau lenh SQL
        String sql = "INSERT INTO [dbo].[Product]([name], [quantity], [price])\n"
                + "VALUES (?, ?, ?)";

        // khoi tao moi parameter Map (optional)
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("name", t.getName());
        parameterMap.put("quantity", t.getQuantity());
        parameterMap.put("price", t.getPrice());

        // tra ve du lieu
        return insertGenericDAO(sql, parameterMap);
    }

    public void delete(Product t) {
        // dinh nghia cau lenh sql
        String sql = "DELETE FROM [dbo].[Product]\n"
                + "WHERE [id] = ?";

        parameterMap = new LinkedHashMap<>();
        parameterMap.put("id", t.getId());
        deleteGenericDAO(sql, parameterMap);
    }

    public void update(Product t) {
        // dinh nghia cau lenh sql
        String sql = "UPDATE [dbo].[Product]\n"
                + "SET\n"
                + "    [name] = ?,\n"
                + "    [quantity] = ?,\n"
                + "    [price] = ?   \n"
                + "WHERE [id] = ?";

        // khoi tao moi parameter Map (optional)
        parameterMap = new LinkedHashMap<>();
        parameterMap.put("name", t.getName());
        parameterMap.put("quantity", t.getQuantity());
        parameterMap.put("price", t.getPrice());
        parameterMap.put("id", t.getId());

        updateGenericDAO(sql, parameterMap);
    }

    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        System.out.println("Truoc khi co du lieu: ");
        for (Product product : dao.findAll()) {
            System.out.println(product);
        }
        System.out.println("==========================");

        dao.insert(Product.builder()
                .name("")
                .quantity(10)
                .price(15.4)
                .build());

        System.out.println("Sau khi co du lieu: ");
        for (Product product : dao.findAll()) {
            System.out.println(product);
        }
        System.out.println("==========================");
    }

}
