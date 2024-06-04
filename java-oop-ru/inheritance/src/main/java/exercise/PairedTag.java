package exercise;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;


// BEGIN
public class PairedTag extends Tag {
    private String    body;
    private List<Tag> children;

    public PairedTag(String tagName, Map<String, String> attributes, String body, List<Tag> children) {
        super(tagName, attributes);
        this.body     = body;
        this.children = new ArrayList<Tag>(children);
    }

    @Override
    public String toString() {
        String childsString = children.stream().map(Tag::toString).collect(Collectors.joining());
        return String.format("%s%s%s</%s>", super.toString(), body, childsString, getTagName());
    }
}
// END
