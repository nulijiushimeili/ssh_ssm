package moduels;

import java.util.HashSet;
import java.util.Set;

public class Message {
    private int id;
    private String title;

    private Set<Content> contents =  new HashSet<Content>();

    public Set<Content> getContents() {
        return contents;
    }

    public void setContents(Set<Content> contents) {
        this.contents = contents;
    }

    public Message(){}

    public Message(String title){
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
