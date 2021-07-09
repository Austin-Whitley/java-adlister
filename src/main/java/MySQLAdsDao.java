import com.mysql.jdbc.Driver;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads{

    private Connection connection;
    private List<Ad> ads;

    public MySQLAdsDao(Config c) throws SQLException {
        try{
            DriverManager.registerDriver(new Driver()); //specific driver that will be registered into mysql
            connection = DriverManager.getConnection(
                    c.getUrl(),
                    c.getUser(),
                    c.getPassword()
            );
        }catch (SQLException sql){
            throw new RuntimeException("Error connecting to the database", sql);
        }

    }

    @Override
    public List<Ad> all() {
        //since we have a database we need to actually create a new way to pull our ads out
        //first create an instance of or list of ads
        List<Ad> allAds = new ArrayList<>();

        //create a statement object so we can turn it into a result set
        try{
            Statement stmt = connection.createStatement();
            String showAds = "SELECT * FROM ads";
            ResultSet results = stmt.executeQuery(showAds);

            //iterate through our set of data with the .next method
            while(results.next()){
                allAds.add(new Ad( //using the results call the dataType and column name to pull from a set
                        results.getLong("id"),
                        results.getLong("user_id"),
                        results.getString("title"),
                        results.getString("description")
                ));
            }
            //finally return the ads
            return allAds;
        }catch (SQLException error){
            throw new RuntimeException("Error retrieving Ads List");
        }
    }

    @Override
    public Long insert(Ad ad) {
        try{
            //new instance of a statement object so we can use the .execute update method to insert our Ad into the database.
            Statement stmt = connection.createStatement();
            //create a string that will insert our users Ad information
            String insertString = String.format
                    ("INSERT INTO ads (user_id, title, description) VALUES (%d, '%s', '%s')",
                    ad.getUserId(),
                    ad.getTitle(),
                    ad.getDescription());
            //execute the string
            stmt.executeUpdate(insertString, Statement.RETURN_GENERATED_KEYS);
            //we know that everytime a new row is made(ad is posted) the key will auto increment. We need access to that later
            ResultSet results = stmt.getGeneratedKeys();
            results.next();
            return results.getLong(1);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0L;
    }

    //bonus methods


}
