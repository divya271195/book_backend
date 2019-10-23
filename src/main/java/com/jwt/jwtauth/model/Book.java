package com.jwt.jwtauth.model;

// import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// import javax.persistence.Lob;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "books")
@EntityListeners(AuditingEntityListener.class)


@Getter
@Setter

public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)


	@Column(name = "id")

	private int id;

	@Column(name = "author", nullable = false)
	private String author;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "category", nullable = false)
	private String category;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "publishYear", nullable = false)
	private String publishYear;

	@Column(name = "price", nullable = false)
	private double price;

	@Column(name = "inventory")
	private int inventory;

	@Column(name = "icon")
	private String icon;

	@Column(name = "rank")
	private int rank;


}
