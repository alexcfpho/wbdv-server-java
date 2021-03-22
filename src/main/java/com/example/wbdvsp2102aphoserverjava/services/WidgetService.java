package com.example.wbdvsp2102aphoserverjava.services;

import com.example.wbdvsp2102aphoserverjava.models.Widget;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {

    private List<Widget> widgets = new ArrayList<>();

    {
        Widget w1 = new Widget(123l, "somename", "ABC123", "HEADING", 2, 100, 25, 1, "h4", "none", "some arbitrary value", "heading widget h4");
        Widget w2 = new Widget(234l, "somename2", "6045c1c031027600173cbbc3", "PARAGRAPH", 1, 50, 10, 2, "p", "none", "some arbitrary value2", "paragraph widget");
        Widget w3 = new Widget(345l, "somename3", "EFG345", "PARAGRAPH", 1, 100, 25, 3, "p", "none", "some arbitrary value3", "paragraph widget");
        Widget w4 = new Widget(456l, "somename4", "6045c1c031027600173cbbc3", "HEADING", 3, 125, 50, 4, "h3", "none", "some arbitrary value4", "heading widget h3");
        Widget w5 = new Widget(567l, "somename5", "KLM567", "PARAGRAPH", 1, 100, 25, 5, "p", "none", "some arbitrary value5", "paragraph widget");
        Widget w6 = new Widget(678l, "simpleWidget", "6045c1c031027600173cbbc3","HEADING");

        widgets.add(w1);
        widgets.add(w2);
        widgets.add(w3);
        widgets.add(w4);
        widgets.add(w5);
        widgets.add(w6);
    }

    public List<Widget> findAllWidgets() {
        return widgets;
    }

    public List<Widget> findWidgetsForTopic(String topicId) {
        List<Widget> ws = new ArrayList<>();
        for(Widget w: widgets) {
            if(w.getTopicId().equals(topicId)) {
                ws.add(w);
            }
        }
        return ws;
    }

    public Widget findWidgetById(Long widgetId) {
        for (Widget w: widgets) {
            if (w.getId().equals(widgetId)) {
                return w;
            }
        }
        return null;
    }

    public Widget createWidgetForTopic(String topicId, Widget widget) {
        widget.setTopicId(topicId);
        widget.setId((new Date()).getTime());
        widgets.add(widget);
        return widget;
    }

    public Integer updateWidget(Long widgetId, Widget widget) {
        for (int i = 0; i < widgets.size(); i++) {
            if (widgets.get(i).getId().equals(widgetId)) {
                widgets.set(i, widget);
                return 1;
            }
        }
        return 0;
    }

    public Integer deleteWidget(Long widgetId) {
        int index = -1;
        for(int i=0; i<widgets.size(); i++) {
            if(widgets.get(i).getId().equals(widgetId)) {
                index = i;
                widgets.remove(index);
                return 1;
            }
        }
        return 0;
    }
}