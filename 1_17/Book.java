package lesson2;

import java.util.Date;

public class Book implements Comparable<Book>{
	private String title;
	private Date publishDate;
	private String comment;

	public Book (String title, Date publishDate) {
		this.setTitle(title);
		this.setPublishDate(publishDate);
	}

	public Book(){};

	public String getTitle() {
		return this.title;
	}

	public Date getPublishDate() {
		return this.publishDate;
	}

	public String getComment() {
		return this.comment;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (o == null) return false;
		if (!(o instanceof Book)) return false;
		Book b = (Book) o;
		if(b.getTitle().trim() == this.getTitle().trim() && 
			b.getPublishDate().equals(this.getPublishDate())) {
			return true;
		}
		return false;
	}

	public int compareTo(Book b) {
		
	}


}