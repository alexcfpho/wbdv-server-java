package com.example.wbdvsp2102aphoserverjava.controller;

import com.example.wbdvsp2102aphoserverjava.models.Widget;
import com.example.wbdvsp2102aphoserverjava.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {


    private final WidgetService service;

    @Autowired
    public WidgetController(WidgetService service) {
        this.service = service;
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return service.findAllWidgets();
    }

    @GetMapping("/api/topics/{topicId}/widgets")
    public List<Widget> findWidgetsForTopic(
            @PathVariable("topicId") String tid) {
        return service.findWidgetsForTopic(tid);
    }

    @PostMapping("/api/topics/{topicId}/widgets")
    public Widget createWidget (
            @PathVariable("topicId") String tid, @RequestBody Widget widget) {
            return service.createWidgetForTopic(tid, widget);
    }

    @PutMapping("/api/widgets/{widgetId}")
    public Integer updateWidget(
            @PathVariable("widgetId") Long wid, @RequestBody Widget widget) {
        return service.updateWidget(wid, widget);
    }

    @DeleteMapping("/api/widgets/{widgetId}")
    public Integer deleteWidget(@PathVariable("widgetId") Long id) {
        return service.deleteWidget(id);
    }
}