package mondai;


import java.util.*;

public class Book {
	private String title;
	private Date publishDate;
	private String comment;


	public Book(){
	}

	public Book(String title ,Date publishDate , String comment){
		this.setTitle(title);
		this.setPublishDate(publishDate);
		this.setComment(comment);
	}

	public boolean equals(Object o){
		if (o == this) return true;
		if (o == null) return false;
		if (!(o instanceof Book)) return false;
		Book b = (Book) o;
		if (!this.getTitle().trim().equals(b.getTitle().trim())){
			if((this.getPublishDate().compareTo(b.getPublishDate())) != 0){
				return false;
			}
		}
		return true;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}

	public void setPublishDate(Date date){
		this.publishDate = date;
	}

	public Date getPublishDate(){
		return this.publishDate;
	}

	public void setComment(String comment){
		this.comment = comment;
	}
}