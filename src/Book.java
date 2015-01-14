

public class Book {

		private String ISBN;
		private String Title;
		private String Author;
		
		public Book() {
			ISBN = "";
			Title = "";
			Author = "";
		}
		public Book(String x, String y, String z) {
			 ISBN = x;
			 Title = y;
			 Author = z;
		}
		public void setISBN(String x) {
			ISBN = x;
		}
		public void setTitle(String x) {
			Title = x;
		}
		public void setAuthor(String x) {
			Author = x;
		}
		
		public String getBook() {
			return 	"ISBN: " + ISBN + "\n" +
					"Title: " + Title + "\n" +
					"Author: " + Author; 
		}	
		
}
