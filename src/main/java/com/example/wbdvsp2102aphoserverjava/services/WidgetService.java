package com.example.wbdvsp2102aphoserverjava.services;

import com.example.wbdvsp2102aphoserverjava.models.Widget;
import com.example.wbdvsp2102aphoserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository repository;

    public List<Widget> findAllWidgets() {
        return (List<Widget>)repository.findAll();
    }

    public List<Widget> findWidgetsForTopic(String tid) {
        return repository.findWidgetsForTopic(tid);
    }

    public Widget findWidgetById(Long wid) {
        Optional<Widget> someWidget = repository.findById(wid);
        return someWidget.orElse(null);
    }

    public Widget createWidget(String tid, Widget widget) {
        widget.setTopicId(tid);
        widget.setId((new Date()).getTime());
        return repository.save(widget);
    }

    public Integer updateWidget(Long wid, Widget widget) {
        Optional<Widget> widgetToUpdate = repository.findById(wid);
        if (widgetToUpdate.isPresent()) {
            Widget fetchedWidget = widgetToUpdate.get();
            fetchedWidget.setText(widget.getText());
            fetchedWidget.setOrdered(widget.getOrdered());
            fetchedWidget.setType(widget.getType());
            fetchedWidget.setSize(widget.getSize());
            fetchedWidget.setWidth(widget.getWidth());
            fetchedWidget.setHeight(widget.getHeight());
            fetchedWidget.setSrc(widget.getSrc());
            repository.save(fetchedWidget);
            return 1;
        }
        return 0;
    }

    public Integer deleteWidget(Long wid) {
        if (repository.findById(wid).isPresent()) {
            repository.deleteById(wid);
            return 1;
        }
        return 0;
    }
}