package com.mightyjava.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Video {
	
	@Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String title;

	@NotNull
	private String youTubeURL;
	
	private Date date;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "video_category", joinColumns = { @JoinColumn(name = "video_id") }, inverseJoinColumns = { @JoinColumn(name = "category_id") })
	private Set<Category> categories = new HashSet<Category>();
	
	private transient Long[] selectedCategories;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYouTubeURL() {
		return youTubeURL;
	}

	public void setYouTubeURL(String youTubeURL) {
		this.youTubeURL = youTubeURL;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Long[] getSelectedCategories() {
		return selectedCategories;
	}

	public void setSelectedCategories(Long[] selectedCategories) {
		this.selectedCategories = selectedCategories;
	}
	
}