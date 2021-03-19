package com.example.wbdvsp2102aphoserverjava.models;

public class Widget {

    private Long id;
    private String name;
    // created on generic server, gen by mongo. referenced by "_id" property.
    private String topicId;
    private String type;
    private Integer size;
    private Integer width, height;
    private Integer widgetOrder;
    private String cssClass;
    private String style;
    private String value;
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Widget() {
    }

    public Widget(Long id, String name, String topicId, String type, Integer size, Integer width, Integer height, Integer widgetOrder, String cssClass, String style, String value, String text) {
        this.id = id;
        this.name = name;
        this.topicId = topicId;
        this.type = type;
        this.size = size;
        this.width = width;
        this.height = height;
        this.widgetOrder = widgetOrder;
        this.cssClass = cssClass;
        this.style = style;
        this.value = value;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidgetOrder() {
        return widgetOrder;
    }

    public void setWidgetOrder(Integer widgetOrder) {
        this.widgetOrder = widgetOrder;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}