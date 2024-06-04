package exercise;

import java.util.stream.Collectors;
import java.util.Map;
import java.util.LinkedHashMap;


// BEGIN
public abstract class Tag {
    private String              tagName;
    private Map<String, String> attributes;

    public Tag(String tagName, Map<String, String> attributes) {
        this.tagName    = tagName;
        this.attributes = new LinkedHashMap<>(attributes);
    }

    public String getTagName() {
        return tagName;
    }

    public String getAttributesString() {
        return attributes
                .entrySet()
                .stream()
                .map(e -> String.format(" %s=\"%s\"", e.getKey(), e.getValue()))
                .collect(Collectors.joining());
    }

    public String toString() {
        return String.format("<%s%s>", getTagName(), getAttributesString());
    }
}
// END
