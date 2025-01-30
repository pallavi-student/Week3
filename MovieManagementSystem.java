package com.day1.level1;
class Movie {

    String movie_title;
    String director;
    int releaseYear;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String movie_title, String director, int releaseYear, double rating) {
        this.movie_title = movie_title;
        this.director =director;
        this.releaseYear =releaseYear;
        this.rating =rating;
        this.next = null;
        this.prev=null;
    }
}
public class MovieManagementSystem{
    private Movie head;
    private Movie tail;
    public MovieManagementSystem(){
        head=null;
        tail=null;
    }

    public void addMovieAtBeginning(String movie_title,String director,int releaseYear,double rating){
        Movie movie=new Movie(movie_title,director,releaseYear,rating);
        if(head==null){head=movie;
            tail=movie;}
        else{
            head.prev=movie;
            movie.next=head;
            head=movie;
        }
    }
    public void addMovieAtEnd(String movie_title, String director, int releaseyear, double rating){
        Movie movie=new Movie(movie_title,director,releaseyear,rating);
        if(tail==null){
            head=tail=movie;}
        else{
            tail.next=movie;
            movie.prev=tail;
            tail=movie;
        }
    }
    public void addMovieAtPosition(String movie_title,String director,int releaseyear,double rating,int position){
        if(position<0){
            System.out.println("invalid index");
            return;
        }
        if(position==0){
            addMovieAtBeginning(movie_title,director,releaseyear,rating);
            return;
        }
        Movie movie=new Movie(movie_title,director,releaseyear,rating);
        Movie temp=head;
        for(int i=0;temp!=null&&i<position-1;i++){
            temp=temp.next;
        }
        if(temp==null){
            addMovieAtEnd(movie_title,director,releaseyear,rating);
        }
        else{
            movie.next=temp.next;
            movie.prev=temp;
            if(temp.next!=null){
                temp.next.prev=movie;
            }
            temp.next=movie;
            if(movie.next==null){
                temp.next.prev=movie;
            }
            temp.next=movie;
            if(movie.next==null){
                tail=movie;
            }
        }
    }
    public void removeMovieByTitle(String movie_title) {
        Movie temp = head;

        while (temp != null) {
            if (temp.movie_title.equalsIgnoreCase(movie_title)) {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                } else {
                    head = temp.next;
                }

                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                } else {
                    tail = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie with title" + movie_title +" not found.");
    }
    public void searchMoviesByDirector(String director) {
        Movie temp = head;
        boolean found = false;

        while (temp!= null) {
            if (temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No movies found directed by " + director);
        }
    }
    public void searchMoviesByRating(double rating) {
        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No movies found with rating " + rating);
        }
    }
    public void updateRating(String movie_title, double newRating) {
        Movie temp = head;

        while (temp != null) {
            if (temp.movie_title.equalsIgnoreCase(movie_title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie with title " + movie_title +" not found.");
    }
    public void displayMoviesStart() {
        Movie temp = head;

        while (temp != null) {
            displayMovie(temp);
            temp= temp.next;
        }
    }
    public void displayMoviesReverse() {
        Movie current = tail;

        while (current != null) {
            displayMovie(current);
            current = current.prev;
        }
    }
    private void displayMovie(Movie movie) {
        System.out.println("Title: " + movie.movie_title + ", Director: " + movie.director +
                ", Year: " + movie.releaseYear + ", Rating: " + movie.rating);
    }


    public static void main(String[] args) {
        MovieManagementSystem mms = new MovieManagementSystem();

        mms.addMovieAtBeginning("Inception", "Christan Ronaldo", 2010, 8.8);
        mms.addMovieAtEnd("Interstellar", "Christan Ronaldo", 2014, 8.6);
        mms.addMovieAtPosition("The Prestige", "Christan Ronaldo", 2006, 8.5, 1);

        System.out.println("Movies in forward order:");
        mms.displayMoviesStart();

        System.out.println("Movies in reverse order");
        mms.displayMoviesReverse();

        System.out.println("Search movies by director 'Christan Ronaldo'");
        mms.searchMoviesByDirector("Christopher Nolan");

        System.out.println("Update rating for 'Inception'");
        mms.updateRating("Inception", 9.0);

        System.out.println("Movies in forward order after update");
        mms.displayMoviesStart();

        System.out.println("Remove movie 'Interstellar':");
        mms.removeMovieByTitle("Interstellar");

        System.out.println("Movies in normal order after removal:");
        mms.displayMoviesStart();
    }
    }



