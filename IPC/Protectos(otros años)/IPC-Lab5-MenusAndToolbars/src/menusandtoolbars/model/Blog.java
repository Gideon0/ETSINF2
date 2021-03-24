package menusandtoolbars.model;

/**
 *
 * @author mario
 */
public enum Blog {
    ATHOS("Athos"),
    PORTHOS("Porthos"),
    ARAMIS("Aramis");
    private final String name;

    private Blog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
