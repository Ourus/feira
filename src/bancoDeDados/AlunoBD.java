
package bancoDeDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Turma;

/**
 *
 * @author jonathan
 */
public class AlunoBD extends ConectarBanco
{
    public int cadastrarAluno (Turma aluno)
    {
        int key=0;
        try 
        {
            conectarBanco();
            String sql="insert into aluno (nome,curso,turno) values (?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stm.setString(1,aluno.getNomeTurma());
            stm.setString(2, aluno.getCurso());
            stm.setString(3, aluno.getTurno());
            stm.executeUpdate();
              ResultSet codPessoa = stm.getGeneratedKeys();
            while (codPessoa.next()) 
            {
                key = codPessoa.getInt(1);
            }
            JOptionPane.showMessageDialog(null, "Aluno: "+aluno.getNomeTurma()+"");
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            desconetarBanco();
            return key;
        }
    }
    
    public ArrayList <Turma> listarAlunosCadastrados()
    {
        ArrayList <Turma> listaAlunos = new ArrayList();
        Turma aluno;
        
        try 
        {
            conectarBanco();
            String sql= "select * from aluno order by nome;";
            stm = con.createStatement();
            ResultSet lista = stm.executeQuery(sql);
            while (lista.next())
            {
                aluno = new Turma();
                aluno.setCodTurma(lista.getInt("codAluno"));
                aluno.setNomeTurma(lista.getString("nome"));
                aluno.setTurno(lista.getString("turno"));
                listaAlunos.add(aluno);
                           
            }
            
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            desconetarBanco();
            return listaAlunos;
        }
        
        
    }
    
   
}
