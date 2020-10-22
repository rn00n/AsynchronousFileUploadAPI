package org.file.api.moduls.item;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@ToString
@EqualsAndHashCode(of = "itemId")
@NoArgsConstructor @AllArgsConstructor
public class Item {
    @Id @GeneratedValue
    private Long itemId;

    private String itemName;

    private Integer price;

    private String description;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="item_id")
    private List<ItemFile> itemFiles = new ArrayList<>();

    @Transient
    private String[] files;

    private String pictureUrl;

    public void addItemFile(ItemFile itemFile) {
        itemFiles.add(itemFile);
    }

    public void clearItemFile() {
        itemFiles.clear();
    }
}
