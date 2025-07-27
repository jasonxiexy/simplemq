package com.github.jasonx.consumer.dto;

import java.util.Objects;

public class MqTopicTagDto {

    /**
     * consumer group name
     */
    private String groupName;

    /**
     * topic name
     */
    private String topicName;

    /**
     * tag name
     */
    private String tagName;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        MqTopicTagDto tagDto = (MqTopicTagDto) object;
        return Objects.equals(groupName, tagDto.groupName) &&
                Objects.equals(topicName, tagDto.topicName) &&
                Objects.equals(tagName, tagDto.tagName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName, topicName, tagName);
    }
}
