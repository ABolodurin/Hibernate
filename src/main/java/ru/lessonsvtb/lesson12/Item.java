package ru.lessonsvtb.lesson12;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int itemId;

    @Column(name = "val")
    private int value;

    @Version
    private long version;

    public Item(int value) {
        this.value = value;
    }

    public Item() {
    }

    public int getItemId() {
        return itemId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
