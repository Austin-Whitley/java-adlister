public class DaoFactory {
    private static Ads adsDao;
    private static Products productsDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new ListAdsDao();
        }
        return adsDao;
    }

    public static Products getProductsDao(){
        if(productsDao == null){
            //set products Dao as a ListProducts class because list products implements the interface products.
            productsDao = new ListProducts();
        }
        return productsDao;
    }
}
