import java.util.List;

interface Products {
    //all of the products that are inside our database will be referenced here.
    //it will insert and manipulate products inside the database.

    List<Product> all();

    void insert(Product product);



}
