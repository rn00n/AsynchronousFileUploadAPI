package org.file.api.moduls.item;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class ItemFile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemFileId;
	
	@Column(length = 150)
	private String fullName;
	
}
