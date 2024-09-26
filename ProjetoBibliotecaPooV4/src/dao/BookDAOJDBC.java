package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Book;

public class BookDAOJDBC implements BookDAO {

    @Override
    public int inserir(Book book) {
        String sql = "INSERT INTO book(title, author, ano, genre, editora, usuario) VALUES (?, ?, ?, ?, ?, ?)";
        int linhasAfetadas = 0;
        try {
            linhasAfetadas = DAOGenerico.executarComando(sql, 
                    book.getTitle(), 
                    book.getAuthor(), 
                    book.getAno(), 
                    book.getGenre(), 
                    book.getEditora(), 
                    book.getUsuario()); // nome do usuário
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }

    @Override
    public int editar(Book book) {
        String sql = "UPDATE book SET title = ?, author = ?, ano = ?, genre = ?, editora = ?, usuario = ? WHERE codigo = ?";
        int linhasAfetadas = 0;
        try {
            linhasAfetadas = DAOGenerico.executarComando(sql,
                    book.getTitle(), 
                    book.getAuthor(), 
                    book.getAno(), 
                    book.getGenre(), 
                    book.getEditora(), 
                    book.getUsuario(), // nome do usuário
                    book.getCodigo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }

    @Override
    public int apagar(int codigo) throws ClassNotFoundException, SQLException, SQLIntegrityConstraintViolationException {
        String sql = "DELETE FROM book WHERE codigo = ?";
        int linhasAfetadas = 0;
        try {
            linhasAfetadas = DAOGenerico.executarComando(sql, codigo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return linhasAfetadas;
    }

    @Override
    public List<Book> listar() {
        String sql = "SELECT * FROM book";
        List<Book> books = new ArrayList<>();
        try {
            ResultSet rset = DAOGenerico.executarConsulta(sql);
            while (rset.next()) {
                Book book = new Book();
                book.setCodigo(rset.getInt("codigo"));
                book.setTitle(rset.getString("title"));
                book.setAuthor(rset.getString("author"));
                book.setAno(rset.getInt("ano"));
                book.setGenre(rset.getString("genre")); 
                book.setEditora(rset.getString("editora"));
                book.setUsuario(rset.getString("usuario")); // nome do usuário que adicionou o livro
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Book listar(int codigo) {
        String sql = "SELECT * FROM book WHERE codigo = ?";
        Book book = null;
        try {
            ResultSet rset = DAOGenerico.executarConsulta(sql, codigo);
            if (rset.next()) {
                book = new Book();
                book.setCodigo(rset.getInt("codigo"));
                book.setTitle(rset.getString("title"));
                book.setAuthor(rset.getString("author"));
                book.setAno(rset.getInt("ano"));
                book.setGenre(rset.getString("genre")); 
                book.setEditora(rset.getString("editora"));
                book.setUsuario(rset.getString("usuario")); // nome do usuário
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }
}
