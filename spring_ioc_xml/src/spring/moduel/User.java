package spring.moduel;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private String[] names;

    public List<Group> getList() {
        return list;
    }

    public void setList(List<Group> list) {
        this.list = list;
    }

    private List<Group> list ;

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    private Set<Group> sets;

    public Set<Group> getSets() {
        return sets;
    }

    public void setSets(Set<Group> sets) {
        this.sets = sets;
    }

    private Map<String, Group> maps;

    public Map<String, Group> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Group> maps) {
        this.maps = maps;
    }
}
