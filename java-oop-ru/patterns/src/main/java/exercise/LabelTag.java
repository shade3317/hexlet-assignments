package exercise;


// BEGIN
public final class LabelTag implements TagInterface {
    private String       labelText;
    private TagInterface tag;

    public LabelTag(String labelText, TagInterface tag) {
        this.labelText = labelText;
        this.tag       = tag;
    }

    @Override
    public String render() {
        String tagRendered = tag.render();
        return String.format("<label>%s%s</label>", labelText, tagRendered);
    }
}
// END
