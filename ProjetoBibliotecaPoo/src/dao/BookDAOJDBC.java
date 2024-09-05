package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Book;

public class BookDAOJDBC implements BookDAO {
    
    @Override
    public int inserir(Book book) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("INSERT INTO book(title, author, ano, genre, editora) ") 
                .append("VALUES (?, ?, ?, ?, ?)");
     
        String insert = sqlBuilder.toString();
        int linha = 0;
        try {  
            linha = DAOGenerico.executarComando(insert, book.getTitle(), book.getAuthor(), book.getAno(), book.getGenre(), book.getEditora()); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return linha;
    }

    @Override
    public int editar(Book book) {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("UPDATE book SET ")
                .append("title = ?, ")
                .append("author = ?, ")
                .append("ano = ?, ")
                .append("genre = ?, ")
                .append("editora = ? ")
                .append("WHERE codigo = ? ");
        String update = sqlBuilder.toString();
        int linha = 0;
        try {
            linha = DAOGenerico.executarComando(update, book.getTitle(), book.getAuthor(), book.getAno(), book.getGenre(), book.getEditora(), book.getCodigo());
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return linha; 
    }

    @Override
    public int apagar(int codigo) throws ClassNotFoundException, SQLException, SQLIntegrityConstraintViolationException {
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder
                .append("DELETE FROM book ")
                .append("WHERE codigo = ?");
        String delete = sqlBuilder.toString();
        int linha = 0;        
        linha = DAOGenerico.executarComando(delete, codigo);
        return linha;
    }

    @Override
    public List<Book> listar() {
        ResultSet rset;
        String select = "SELECT * FROM book";
        List<Book> books = new ArrayList<>();
        try {        
            rset = DAOGenerico.executarConsulta(select);
            while (rset.next()) {
                Book book = new Book();
                book.setCodigo(rset.getInt("codigo"));
                book.setTitle(rset.getString("title"));
                book.setAuthor(rset.getString("author"));
                book.setAno(rset.getInt("ano"));
                book.setGenre(rset.getString("genre")); 
                book.setEditora(rset.getString("editora"));
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return books;
    }

    @Override
    public Book listar(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
