package com.example.wbdvsp2102aphoserverjava.services;

import com.example.wbdvsp2102aphoserverjava.models.Widget;
import com.example.wbdvsp2102aphoserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository repository;

    public List<Widget> findAllWidgets() {
        return (List<Widget>)repository.findAll();
    }

    public List<Widget> findWidgetsForTopic(String topicId) {
        return repository.findWidgetsForTopic(topicId);
    }

    public Widget findWidgetById(Long widgetId) {
        if (repository.findById(widgetId).isPresent()) {
            return repository.findById(widgetId).get();
        }
    return null;
    }

    public Widget createWidgetForTopic(String topicId, Widget widget) {
        widget.setTopicId(topicId);
        widget.setId((new Date()).getTime());
        return repository.save(widget);
    }

    public Integer updateWidget(Long widgetId, Widget widget) {
        if (repository.findById(widgetId).isPresent()) {
            Widget originalWidget = repository.findById(widgetId).get();
            //@TODO SET NULL CHECK
            originalWidget.setText(widget.getText());
            repository.save(originalWidget);
            return 1;
        }
        return 0;
    }

    public Integer deleteWidget(Long widgetId) {
        repository.deleteById(widgetId);
        return 1;
    }
}