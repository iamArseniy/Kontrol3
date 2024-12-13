package listener;

import db.DataBaseConfig;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import repository.GiftRepository;
import service.GiftService;

@WebListener
public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DataBaseConfig dataBaseConfig = DataBaseConfig.getInstance();
        GiftRepository giftRepository = new GiftRepository(dataBaseConfig);
        GiftService giftService = new GiftService(giftRepository);

        sce.getServletContext().setAttribute("giftService", giftService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
