package spring.moduel;

import java.util.List;
import java.util.Map;

public class User {
    private String[] names;

    private List<Group> groups;

    private Map<String , Group> maps;

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public Map<String, Group> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Group> maps) {
        this.maps = maps;
    }
}
