package be.iccbxl.pid.rss;

import be.iccbxl.pid.model.Show;
import be.iccbxl.pid.service.ShowService;
import com.rometools.rome.feed.rss.Channel;
import com.rometools.rome.feed.rss.Description;
import com.rometools.rome.feed.rss.Item;
import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndContentImpl;
import javassist.runtime.Desc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

@Component
public class RssFeedView extends AbstractRssFeedView {

    @Autowired
    private ShowService service;

    @Override
    protected void buildFeedMetadata(Map<String, Object> model, Channel feed, HttpServletRequest request) {
        feed.setTitle("Liste des spectacles");
        feed.setDescription("La collection des spectacles");
        feed.setLink("www.spectacles.be");
    }

    @Override
    protected List<Item> buildFeedItems(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {
        List<Item> items = new ArrayList<>();
        List<Show> shows = service.getAll();

        for (Show show : shows) {
            Item item = new Item();
            Description description = new Description();
            item.setTitle(show.getTitle());
            description.setValue(show.getDescription());
            item.setDescription(description);
            item.setPubDate(convertToDateViaSqlTimestamp(show.getCreatedAt()));
            items.add(item);
        }

        return items;
    }

    public Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
        return java.sql.Timestamp.valueOf(dateToConvert);
    }

}
