package com.example.wbdvsp2102aphoserverjava.models;

import javax.persistence.*;

@Entity
@Table(name="widgets")
public class Widget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Created by DB.
    private Long id;
    private String name;
    private String topicId;
    private String type;
    private Integer size;
    private Integer width;
    private Integer height;
    private String src;
    private String text;
    private Boolean ordered;
    private String value;
    private String cssClass;
    private String style;
    private Integer widgetOrder;

    public Widget() {
    }

    public Widget(Long id, String name, String topicId, String type) {
        this.id = id;
        this.name = name;
        this.topicId = topicId;
        this.type = type;
    }

    public Widget(Long id, String name, String topicId, String type, Integer size, Integer width, Integer height, String src, Integer widgetOrder, String cssClass, String style, String value, String text, Boolean ordered) {
        this.id = id;
        this.name = name;
        this.topicId = topicId;
        this.type = type;
        this.size = size;
        this.width = width;
        this.height = height;
        this.src = src;
        this.widgetOrder = widgetOrder;
        this.cssClass = cssClass;
        this.style = style;
        this.value = value;
        this.text = text;
        this.ordered = ordered;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getOrdered() {
        return ordered;
    }

    public void setOrdered(Boolean ordered) {
        this.ordered = ordered;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}

/*
    create table widget (
       id bigint not null,
        css_class varchar(255),
        height integer,
        name varchar(255),
        size integer,
        style varchar(255),
        text varchar(255),
        topic_id varchar(255),
        type varchar(255),
        value varchar(255),
        widget_order integer,
        width integer,
        primary key (id)
    ) engine=InnoDB
 */

/*
create table widgets (
       id bigint not null auto_increment,
        css_class varchar(255),
        height integer,
        name varchar(255),
        size integer,
        style varchar(255),
        text varchar(255),
        topic_id varchar(255),
        type varchar(255),
        value varchar(255),
        widget_order integer,
        width integer,
        primary key (id)
    ) engine=InnoDB
 */