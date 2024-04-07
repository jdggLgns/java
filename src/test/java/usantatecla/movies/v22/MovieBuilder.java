package usantatecla.movies.v22;

public class MovieBuilder {

	private String title;

	public MovieBuilder() {
		title = "movieName";
	}
	
	public MovieBuilder title(String title) {
		this.title = title;
		return this;
	}

	public Movie childrens() {
		return new ChildrenMovie(this.title);
	}

	public Movie regular() {
		return new RegularMovie(this.title);
	}

	public Movie newRelease() {
		return new NewReleaseMovie(this.title);
	}
}
