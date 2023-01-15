package estacionamento.dao;

import estacionamento.entidades.Automovel;
import estacionamento.entidades.AutomovelType;
import estacionamento.entidades.Estacionamento;
import estacionamento.utils.Utils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstacionamentoDAO extends DAO<Estacionamento> {
    public EstacionamentoDAO() throws SQLException{
        super();
    }
    
    @Override
    public void salvar(Estacionamento obj) throws SQLException {
        String sql = "INSERT INTO estacionamento (nome, endereco, cnpj, vagas) " + "VALUES( ?, ?, ?, ? );";
        
        PreparedStatement stmt = getConnection().prepareStatement( sql, new String[]{ "insert_id" } );
        stmt.setString( 1, obj.getNome() );
        stmt.setString(2, obj.getEndereco());    
        stmt.setString(3, obj.getCnpj());
        stmt.setInt(4, obj.getVagas());
        
        
        stmt.executeUpdate();
        obj.setId( Utils.getChavePrimariaAposInsercao( stmt, "insert_id" ) );
        stmt.close();
    }

    @Override
    public void alterar(Estacionamento obj) throws SQLException {
        String sql = "UPDATE estacionamento set nome = ?, endereco = ?, cnpj=?, vagas = ? WHERE id = ?;";
        
        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setString( 1, obj.getNome() );
        stmt.setString(2, obj.getEndereco());    
        stmt.setString(3, obj.getCnpj());
        stmt.setInt(4, obj.getVagas());
        stmt.setLong(5, obj.getId());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void excluir(Estacionamento obj) throws SQLException {
        String sql = "DELETE FROM estacionamento WHERE id = ?;";
    
        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setLong( 1, obj.getId() );
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<Estacionamento> listarTodos() throws SQLException {   
       List<Estacionamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM estacionamento;";
        PreparedStatement stmt = getConnection().prepareStatement( sql );
        ResultSet rs = stmt.executeQuery();
        
        while ( rs.next() ) {

            Estacionamento estacionamento = new Estacionamento();
            estacionamento.setId( rs.getLong( "id" ) );
            estacionamento.setNome( rs.getString( "nome" ) );
            estacionamento.setEndereco(rs.getString( "endereco" ));
            estacionamento.setCnpj(rs.getString( "cnpj" ));
            estacionamento.setVagas(rs.getInt("vagas"));

            lista.add( estacionamento );
        }

        rs.close();
        stmt.close();
        
        return lista;
    }

    @Override
    public Estacionamento obterPorId(int id) throws SQLException {
        String sql = "SELECT * FROM estacionamento WHERE id = ?;";
        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        
        Estacionamento estacionamento = null;
        
        if ( rs.next() ) {

            estacionamento = new Estacionamento();
            estacionamento.setId( rs.getLong( "id" ) );
            estacionamento.setNome( rs.getString( "nome" ) );
            estacionamento.setEndereco(rs.getString( "endereco" ));
            estacionamento.setCnpj(rs.getString( "cnpj" ));
            estacionamento.setVagas(rs.getInt("vagas"));
        }

        rs.close();
        stmt.close();
        return estacionamento;
    }
    
    public Estacionamento obterPorId(long id) throws SQLException {
        String sql = "SELECT * FROM estacionamento WHERE id = ?;";
        PreparedStatement stmt = getConnection().prepareStatement( sql );
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        
        Estacionamento estacionamento = null;
        
        if ( rs.next() ) {

            estacionamento = new Estacionamento();
            estacionamento.setId( rs.getLong( "id" ) );
            estacionamento.setNome( rs.getString( "nome" ) );
            estacionamento.setEndereco(rs.getString( "endereco" ));
            estacionamento.setCnpj(rs.getString( "cnpj" ));
            estacionamento.setVagas(rs.getInt("vagas"));
        }

        rs.close();
        stmt.close();
        return estacionamento;
    }
}
