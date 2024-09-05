
package modelo;


public class Book {
    private String title;
    private String author;
    private String genre;
    private String editora;
    private int ano;
    private int codigo;

    /*public Book(String title, String author, String genre, int ano) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.ano = ano;
    }*/

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

     public String getGenre() {
        return genre;
    }

   public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
     public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
   
    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
 
}
