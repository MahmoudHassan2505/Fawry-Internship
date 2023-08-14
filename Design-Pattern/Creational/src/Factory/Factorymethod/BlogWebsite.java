package Factory.Factorymethod;

import Factory.Factorymethod.Pages.AboutPage;
import Factory.Factorymethod.Pages.ContactPage;

public class BlogWebsite extends Website{
    @Override
    public void createWebsite() {
        pages.add(new ContactPage());
        pages.add(new AboutPage());


    }
}
