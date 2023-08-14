package Factory.Factorymethod;

import Factory.Factorymethod.Pages.CartPage;
import Factory.Factorymethod.Pages.PostPage;

public class ShopWebsite extends Website{
    @Override
    public void createWebsite() {
        pages.add(new CartPage());
        pages.add(new PostPage());

    }
}
