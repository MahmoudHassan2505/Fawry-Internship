package Factory.Factorymethod;

public class WebsiteFactory {
    public static Website getWebsite(WebsiteType websiteType){
        switch (websiteType){
            case Blog:
                return new BlogWebsite();
            case Shop:
                return new ShopWebsite();
            default:
                return null;
        }
    }
}
